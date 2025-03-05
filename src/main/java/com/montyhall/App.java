package com.montyhall;

import java.util.Scanner;
import com.montyhall.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("Enter your name:");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        User user=new User(0, name);

        
        String playAgain="Yes";
        while(playAgain.charAt(0)=='Y' || playAgain.charAt(0)=='y'){
            String start="No";
            System.out.println("---------------------\nHey "+name+" should we start the game?");
            start=sc.next();
            if(start.charAt(0)=='Y' || start.charAt(0)=='y'){
                Game game=new Game();
                game.playGame();
                user.setNumberOfGames();
                if(game.getWin())
                    user.setWins();

                System.out.println("Probability of winning is :"+user.getProbability());
            }
            else{
                System.out.println("What to do:\n1:Display user info\n2:Display probability\n3:Play the game\n4:Exit");
                Scanner st=new Scanner(System.in);
                int opt=st.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("Username:"+user.getUserName());
                        System.out.println("Games played:"+user.getNumberOfGames());
                        System.out.println("Wins:"+user.getWins());
                        System.out.println("Probability:"+user.getProbability());
                        break;
                        
                    case 2:
                        System.out.println("Probability:"+user.getProbability());
                        break;

                    case 3:
                        playAgain="yes";
                        break;
                    default:
                    	String temp="yes";
                        System.out.println("Are you sure you want to quit:");
                        temp=sc.nextLine();
                        if(temp.charAt(0)=='Y'|| temp.charAt(0)=='y')
                            playAgain="No";
                        break;
                }
            }
        }
        
    }
}
