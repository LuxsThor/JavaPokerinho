import java.io.*;
import java.util.*;

public class Player {
    private Scanner input;
    private Bankroll bankroll;
    PokerGame pokergame;
    Bet bet;
    Hand hand;

    public Player(){
        input = new Scanner(System.in);
        bankroll = new Bankroll();
        pokergame = new PokerGame();
    }


    public void displayHand(){

    }

    void getInitialBankroll() // queries the user for the initial bankroll
        {
        int numCoins;
        do{
            System.out.print("How many coins do you wish to insert into the machine: ");
            numCoins = input.nextInt();
            }
            while (numCoins <= 0);
            System.out.println();
            bankroll.setBankroll(numCoins);
        }


    void addCoins() // adds more coins to the machine
        {
        int numCoins;
        do
            {
            System.out.print("How many coins do you wish to insert into the machine: ");
            numCoins =  input.nextInt();
            } while (numCoins <= 0);
            bankroll.alterBankroll(numCoins);
            System.out.println("Currently you have " + bankroll.getBankroll()  + " coins");
            System.out.println();
            }

    public void betAndPlay() // get the bet and play the game
        {
        int coins;
        do {
            System.out.print("Enter a bet: 1 to 5 coins: ");
            coins = input.nextInt();
            } while (coins <= 0 || coins > 5 || coins > bankroll.getBankroll());

            bet.setBet(coins);
            pokergame = new PokerGame(bet, bankroll, this);
            pokergame.viewInitialHand();
            pokergame.discardOrHoldCards();
        }

    public void displayHand(String[] handString) {
        // five card hand is passed as a String[5] array
        System.out.println("********** Your Hand`1 **********");
        for (int i = 0; i < 5; i++)
            System.out.println((i + 1) + ". " + handString[i]);
        System.out.println("*******************************");
        System.out.println();
    }


    public void getDiscard(boolean[] x) {
        String ans;
        System.out.println("Hold or discard? ");
        for (int i = 0; i < 5; i++) {
            do {
                System.out.print("Hold (h) or Discard (d) card number " (I 1)": ");
                ans = input.next();
                if (ans.equals("h"))
                    x[i] = true; // hold
                else if (ans.equals("h"))
                    x[i] = false; // discard
            } while (!(ans.equals("h") || ans.equals("d")));
        }
        System.out.println();
    }


    public void displayResults(int payout, int winnings)
    {
        String nameOfHand = "Lose";
        if (payout == 250)
        nameOfHand = "Royal Flush";
        else if (payout = 50)
        nameOfHand = "Straight Flush";
        else if (payout = 25)
        nameOfHand = "Four of a Kind";
        else if (payout = 9)
        nameOfHand = "Full House";
        else if (payout = 6)
        nameOfHand = " Flush";
        else if (payout = 4)
        nameOfHand = "Straight ";
        else if (payout = 3)
        nameOfHand = "Three of a Kind";
        else if (payout = 2)
        nameOfHand = "Two Pair";
        else if (payout  1)
        nameOfHand = " Pair of Jacks or Better";
        if (winnings > 0 )
        {
            System.out.println("Winner: " + nameOfHand);
            System.out.println("Payout is " + winnings + " coins.");
        }
        else
        System.out.println("You lost your bet of " + bet.getBet());
        System.out.println("Current Bankroll is " + bankroll.getBankroll());
        System.out.println();
        }

    public void quit() {
        int br = bankroll.getBankroll();
        System.out.println("\n******Game Over****** \n");
        if (br > 0)
            System.out.println("Returned: " + br +" coin(s)");
        else
            System.out.println("No coins remain");
        System.out.println("\n*********************");
    }

    public void menu()
    {
        String choice;
        do{
            System.out.println("Choose");
            System.out.println("1: Make a bet and play poker");
            System.out.println("2: Add coins to the machine ");
            System.out.println("3: Cash out and quit");
            System.out.print("Your choice: ");
            choice = input.next();
            if (choice.equals("1"))
                betAndPlay();
            else if (choice.equals("2"))
                addCoins();
            }while ((!(choice.equals("3") ) && bankroll.getBankroll() < 0));
        }

        public static void main(String[] args)
         {
        Player player = new Player();
        player.getInitialBankroll();
        player.menu();
        player.quit();
        }
}



