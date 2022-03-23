package com.priceline.chutes.rules;

import com.priceline.chutes.Board;
import com.priceline.chutes.BoardSquare;
import com.priceline.chutes.Player;

public class SpinRule implements GameRule {

    Board board;
    public SpinRule(Board board){
      this.board = board;
    }
    public RuleStatus ruleExecutor(Player player){
        player.spin();
        int spinResult =player.getCurruntSpingValue();
        System.out.println("Player " + player.getName() + " Spin Number " + spinResult);
        return RuleStatus.MOVE_BOARD;
    }

}
