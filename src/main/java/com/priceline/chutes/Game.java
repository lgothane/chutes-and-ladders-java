package com.priceline.chutes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    public PlayersPool playGame(ArrayList<String> playerName) throws InterruptedException {
        PlayersPool playerPool = new PlayersPool();
        playerName.stream().forEach(e->playerPool.addPlayer(new Player(e)));
        GameExecutor gameExecutor = new GameExecutor(playerPool,new Board());
        while (gameExecutor.executeGame()!=null) {
            Thread.sleep(100);
        }
        return playerPool;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of players- ");
        int num= sc.nextInt();
        ArrayList<String> playerName = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter player - " + (i+1));
            playerName.add(sc.next());
        }
        try {
            new Game().playGame(playerName).printWinningpool();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
