import java.io.*;
import java.util.*;


public class Card {

    private int suit; // 1  Hearts, 2  Diamonds, 3  Clubs, 4  Spades
    private int value;
    //defautl constructor by default ace of hearts
    public Card(){
        suit = 1;
        value = 1;
    }

    public Card(int suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public int getSuit(){
        return suit;
    }

    public void setSuit(int suit){
        this.suit = suit;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public String getName(){
        String cardname = "";
        if(value==1)
            cardname = "Ace of";
        else if(value==11)
            cardname = "Jack of";
        else if(value==12)
            cardname = "Queen of";
        else if (value == 13)
            cardname = "King of";
        else
            cardname = value + " of";

        if(suit==1)
            cardname += " Hearts";
        else if(suit==2)
            cardname += " Diamonds";
        else if (suit==3)
            cardname += " Clubs";
        else
            cardname += " Spades";

        return cardname;
    }
    // some testeraction!!
    public static void main(String[] args) {
        Scanner testcardscan = new Scanner(System.in);
        System.out.println("give me the suit of the card 1  Hearts, 2  Diamonds, 3  Clubs, 4  Spades");
        int cardsuit = testcardscan.nextInt();
        System.out.println("give me the value of the card 1 (Ace)to 13(King)");
        int cardvalue = testcardscan.nextInt();
        Card testcard = new Card(cardsuit, cardvalue);
        System.out.println(testcard.getName() + " should have the values " + cardsuit + " and " + cardvalue);
        Card shittycard = new Card(1,2);
        System.out.println("this is a shitty card " + shittycard.getName());
    }
}
