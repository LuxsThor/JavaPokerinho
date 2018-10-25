import java.io.*;
import java.util.*;

public class Deck {
    Card[] deck;
    private int nextcard;

    public Deck(){

        deck = new Card[53];

        for (int rank = 1; rank<13; rank++) // for each rank Ace...King
        { // place cards in order in deck
            deck[rank] = new Card(1,rank); // first suit;
            deck[rank + 13] =  new Card(2,rank); // second suit;
            deck[rank+ 26] = new Card(3,rank); // third suit;
            deck[rank + 39] = new Card(4,rank); // fourth suit
        }
        nextcard = 1;

    }

    public Card deal(){
        if(nextcard>52){
            shuffle();
        }
        Card dealing = deck[nextcard];
        nextcard++;
        return dealing;

    }

    public void shuffle() {
        Random randomNumber = new Random();
        for (int card = 1; card <= 52; card++)
        { // find a random place in the deck
            int rand = randomNumber.nextInt(52) + 1; // integer between 1 and 52, inclusive
            //swap deck[card] with deck[rand]
            Card temp = deck[card];
            deck[card] = deck[rand];
            deck[rand] = temp;
        }
        nextcard = 1;
    }

    public static void main(String[] args) {
        Deck testdeck = new Deck();
        System.out.println("the first card of the unshuffled deck should be ace of hearts and it is: " + testdeck.deal().getName());
        testdeck.shuffle();
        System.out.println("the next few dealt cards should be some random cards " + testdeck.deal().getName() + " " + testdeck.deal().getName() + " " + testdeck.deal().getName() + " " + testdeck.deal().getName());
    }
}
