package com.montyhall;

public class User {
    private int id;
    private String userName;
    private int numberOfGames;
    private int wins;
    private double probability;

    public User(int id,String userName){
        this.id=id;
        this.userName=userName;
        numberOfGames=0;
        wins=0;
        probability=0;        
    }

    public String getUserName(){
        return userName;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }
    public void setNumberOfGames() {
        numberOfGames+=1;
    }
    public int getWins() {
        return wins;
    }
    public void setWins() {
        wins+=1;
    }
    public int getProbability() {
        probability=wins/(double)numberOfGames;
        return (int) (probability*100);
    }
}
