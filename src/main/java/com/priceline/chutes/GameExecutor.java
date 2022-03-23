package com.priceline.chutes;

import com.priceline.chutes.rules.*;

import java.util.ArrayList;

public class GameExecutor {
    PlayersPool playersPool;
    Board board;
    RuleExecutor ruleExecutor = new RuleExecutor();
    ArrayList<GameRule> ruleArrayList = new ArrayList<>();
    RuleStatusProcessor processor;
    GameExecutor(PlayersPool pool,Board board){
        this.playersPool = pool;
        this.board  =board;
        ruleExecutor.addRules(new SpinRule(board));
        ruleExecutor.addRules(new RespinRule(board));
        ruleExecutor.addRules(new MoveOtherPlayerRule(board,playersPool));
        processor = new RuleStatusProcessor(board,playersPool);
    }

    public Player executeGame(){
        ruleExecutor.ruleExecutor(playersPool.currentPlayer(),processor);
        return playersPool.currentPlayer();
    }
}
