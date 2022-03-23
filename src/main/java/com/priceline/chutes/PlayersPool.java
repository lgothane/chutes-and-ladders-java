package com.priceline.chutes;

import java.util.LinkedList;
import java.util.Queue;

public class PlayersPool {
    public Queue<Player> players = new LinkedList<>();
    public Queue<Player> winningPlayer = new LinkedList<>();
    int payPosition=0;
    public boolean addPlayer(Player player){
        return players.add(player);
    }
    public Player currentPlayer(){
        return players.peek();
    }
    public boolean isMorePlayer(){
        return !players.isEmpty();
    }

    public void printWinningpool(){
        int position=1;
        System.out.println("========GAME - RESULT ===========");
        while(!winningPlayer.isEmpty()){
            Player p1=winningPlayer.remove();

            if(winningPlayer.isEmpty()){
                System.out.println("Player " + p1.name + " at Last position "+ position++);
            }else {
                System.out.println("Player " + p1.name + " at winner position " + position++);
            }

        }
    }

}
