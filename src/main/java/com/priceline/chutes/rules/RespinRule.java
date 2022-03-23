package com.priceline.chutes.rules;

import com.priceline.chutes.Board;
import com.priceline.chutes.BoardSquare;
import com.priceline.chutes.Player;

public class RespinRule implements GameRule {
    Board board;
    public RespinRule(Board board){
        this.board = board;
    }
    public RuleStatus ruleExecutor(Player player){
        int previousSpinResult =player.getCurruntSpingValue();
        int currentSpinResult = 0;
        int nextPosition=0;
        if(previousSpinResult==6) {
            player.spin();
            currentSpinResult =player.getCurruntSpingValue();
            System.out.println("Player " + player.getName() + " Re-Spin Number " + currentSpinResult);
            if(currentSpinResult == 6 && nextPosition < 100){
                return RuleStatus.SPIN_AGAIN;
            }else {
                return RuleStatus.MOVE_BOARD;
            }
        }else{
            return RuleStatus.NEXT_PLAYER;
        }

    }
}
