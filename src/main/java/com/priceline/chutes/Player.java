package com.priceline.chutes;

import java.util.Random;
import java.util.UUID;

public class Player {

    String name;
    int boardPosition = 0;
    int curruntSpinValue = 0;
    UUID playerId;

    Player(String name){
        this.name = name;
        this.playerId = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBoardPosition() {
        return boardPosition;
    }

    public void setBoardPosition(int boardPosition) {
        this.boardPosition = boardPosition;
    }

    public int getCurruntSpinValue() {
        return curruntSpinValue;
    }

    public void setCurruntSpinValue(int curruntSpinValue) {
        this.curruntSpinValue = curruntSpinValue;
    }

    public int getPosition() {
        return boardPosition;
    }

    public void setPosition(int position) {
        this.boardPosition = position;
    }

    public void spin(){
        curruntSpinValue= new Random().nextInt(6) + 1;
    }

    public int getCurruntSpingValue(){
        return curruntSpinValue;
    }
    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }
}
