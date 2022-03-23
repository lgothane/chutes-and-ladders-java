package com.priceline.chutes.rules;

import com.priceline.chutes.Board;
import com.priceline.chutes.Player;
import com.priceline.chutes.PlayersPool;

public class MoveOtherPlayerRule implements GameRule {
    Board board;
    PlayersPool pool;
    public MoveOtherPlayerRule(Board board,PlayersPool pool){
        this.board = board;
        this.pool = pool;
    }
    public RuleStatus ruleExecutor(Player currentplayer){
        if(pool.players.stream().filter(player -> player.getPlayerId()!=currentplayer.getPlayerId() && player.getPosition()==currentplayer.getPosition()).findAny().isPresent()){
            return RuleStatus.MOVE_OTHER;
        }
        return RuleStatus.NEXT_PLAYER;
    }
}
