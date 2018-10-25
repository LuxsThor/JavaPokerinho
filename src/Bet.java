import java.io.*;
import java.util.*;


public class Bet {
    //class and object variables
    private int bet;

    //constructors
    public Bet(){
        bet = 0;
    }

    public Bet(int bet){
        this.bet = bet;
    }

    // getters and setters
    public int getBet(){
        return bet;
    }

    public void setBet(int bet){
        this.bet = bet;
    }

    //some testing action
    public static void main(String[] args) {
        Bet testbet = new Bet();
        System.out.println("the testbet value is "+ testbet.getBet());
        testbet.setBet(5);
        System.out.println("after setting the bet to 5 it is: " + testbet.getBet());
        Bet anothertestbet = new Bet(6);
        System.out.println("this bets value should already be set to 6 and its value is: " + anothertestbet.getBet());
    }
}


