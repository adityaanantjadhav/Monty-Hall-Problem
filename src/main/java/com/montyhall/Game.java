package com.montyhall;

import java.util.Scanner;

public class Game {
    private boolean win;
    private Door doors[];


    public Game(){
        win=false;
        doors=new Door[3];
        for(int i=0;i<3;i++){
            doors[i]=new Door();
        }
                                                    
        int treasureDoor=generateRandomNumber(0, 2);                       
        doors[treasureDoor].setTreasureDoor(true);
    }

    public int generateRandomNumber(int x1,int x2){ //formula to generate random no. in range [x1,x2]
        double f=Math.random()/Math.nextDown(1.0);  //random function returns no. in range [0.0,1)  we divide it by largest no. that random returns to get range of [0.0,1.0]
        return (int) ((x2-x1)*f+x1);                  // randomNo= (x2-x1)*f+x1 
    }


    private void displayDoors(boolean finalResult){
    	
    	System.out.println("-------------------------------------------------");
        for(int i=0;i<3;i++){ 
            System.out.print(" ___");
        }
        
        System.out.println();
        for(int i=0;i<3;i++){
            System.out.print("|   ");
        }
        System.out.println("|   ");
        for(int i=0;i<3;i++){
            System.out.print("| ");
            if(doors[i].getDoorType()==DoorType.OPENED)
                System.out.print("X");
            else{
                if(finalResult){
                    if(doors[i].isTreasureDoor()) System.out.print("$");
                    else System.out.print("0");
                }
                else{
                    System.out.print(i+1);
                }
            }
            System.out.print(" ");
        }System.out.println("|");
        for(int i=0;i<3;i++){
            System.out.print("|___");
        }
        System.out.println("|");
        for(int i=0;i<3;i++){
            System.out.print("  ");
            if(doors[i].getDoorType()==DoorType.SELECTED) System.out.print("^ ");
            else System.out.print("  ");
        }
        System.out.println();
        for(int i=0;i<3;i++){
            System.out.print("  ");
            if(doors[i].getDoorType()==DoorType.SELECTED) System.out.print("| ");
            else System.out.print("  ");
        }
        System.out.println();

    }

    public int doorToBeRevealed(){
        int iter=generateRandomNumber(0, 1);
        if(iter==0){
            for(int i=0;i<3;i++){
                if(doors[i].getDoorType()!=DoorType.SELECTED && !doors[i].isTreasureDoor()){
                    return i;
                }
            }
        }
        else{
            for(int i=2;i>=0;i--){
                if(doors[i].getDoorType()!=DoorType.SELECTED && !doors[i].isTreasureDoor()){
                    return i;
                }
            }
        }
        return 99;
    }


    public void playGame(){
        boolean isInput=false;
        Scanner sc=new Scanner(System.in);
        while(!isInput){
            displayDoors(false);
            System.out.println("Select a door between 1 to 3");
            int selected=sc.nextInt();
            selected--;
            if(selected>2 && selected<0){
                System.out.println("You entered wrong door number! Choose number between 1 to 3");
            }
            else{
                doors[selected].setDoorType(DoorType.SELECTED);
                isInput=true;
            }
        }
        int revealDoor=doorToBeRevealed();
        doors[revealDoor].setDoorType(DoorType.OPENED);
        displayDoors(false);
        System.out.println("I am revealing one door to make it easier for you...\nThe door "+(revealDoor+1)+" is revealed and it doesn't have money!\1");
        System.out.println("***********\nNow do you want to switch door you selected earlier with remaining door:");
        String switchDoor="No";
        Scanner st=new Scanner(System.in);
        switchDoor=st.next();
        while(switchDoor.charAt(0)=='y'|| switchDoor.charAt(0)=='Y'){
            for(int i=0;i<3;i++){
                if(doors[i].getDoorType()==DoorType.SELECTED){
                    doors[i].setDoorType(DoorType.CLOSED);
                }
                else if(doors[i].getDoorType()==DoorType.CLOSED){
                    doors[i].setDoorType(DoorType.SELECTED);
                }
            }
            
            displayDoors(false);
            System.out.println("Do you want to Switch back ?");
            switchDoor=st.next();
        }
        System.out.println("Revealing the doors....\n PRESS ANY CHARACTER AND ENTER ");
        sc.next();
        displayDoors(true);

        if(isWin()){
            win=true;
            System.out.println("\n!!!!!!!!!!!! Congratulations! You won the Money.!!!!!!!!!\n");
        }
        else{
            System.out.println("\n!!!!!!!!!!!! Sorry! You lost the Money. !!!!!!!!!");
        }
    }


    private boolean isWin(){
        for(int i=0;i<3;i++){
        	if(doors[i].isTreasureDoor()) System.out.print("Treasure was behind "+(i+1)+" door. ");
            if(doors[i].getDoorType()==DoorType.SELECTED && doors[i].isTreasureDoor()){
                return true;
            }
        }
        return false;
    }
    
    public boolean getWin() {
    	return this.win;
    }


}
