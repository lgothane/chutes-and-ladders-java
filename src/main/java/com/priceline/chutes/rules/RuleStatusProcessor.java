package com.priceline.chutes.rules;

import com.priceline.chutes.Board;
import com.priceline.chutes.BoardSquare;
import com.priceline.chutes.Player;
import com.priceline.chutes.PlayersPool;

public class RuleStatusProcessor {
    Board board;
    PlayersPool pool;
    public RuleStatusProcessor(Board board,PlayersPool pool){
        this.board = board;
        this.pool = pool;
    }

    public void processRuleResult(RuleStatus status, Player currentPlayer){
        if(status==RuleStatus.MOVE_BOARD){
            int nextPosition = currentPlayer.getPosition() + currentPlayer.getCurruntSpingValue();
            if (nextPosition < 100) {
                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                nextPosition += nextSquare.getNumberSquaresToSkip();
                System.out.println("Player " + currentPlayer.getName() + " next position " + nextPosition);
                currentPlayer.setPosition(nextPosition);
            }
        }
        if(status==RuleStatus.SPIN_AGAIN){
            int nextPosition = currentPlayer.getPosition() + currentPlayer.getCurruntSpingValue();
            if (nextPosition < 100) {
                BoardSquare nextSquare = board.getSquareAtPosition(nextPosition);
                nextPosition += nextSquare.getNumberSquaresToSkip();
                System.out.println("Player " + currentPlayer.getName() + " next position " + nextPosition);
                currentPlayer.setPosition(nextPosition);
            }
        }
        if(status==RuleStatus.MOVE_OTHER){
            pool.players.stream().filter(allplayer -> allplayer.getPlayerId()!=currentPlayer.getPlayerId() && allplayer.getPosition()==currentPlayer.getPosition())
                    .forEach(e->{
                        System.out.println("Player " + e.getName() + " move back to position " + (e.getPosition()- currentPlayer.getCurruntSpinValue()));
                        e.setBoardPosition(e.getPosition()- currentPlayer.getCurruntSpinValue());
                    });
        }
    }

    public void nextPlayer(Player player){
        Player p1=pool.players.peek();
        if(p1.getBoardPosition() == 100){
            System.out.println("Player " + p1.getName() + " Cleared board and Won ");
            pool.winningPlayer.add(pool.players.remove());
            if(pool.players.size()==1){
                Player last=pool.players.remove();
                pool.winningPlayer.add(last);
            }
        }else {
            pool.players.add(pool.players.remove());
        }
    }
}
