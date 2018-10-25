public class Hand {
    Card[] hand;
    Deck deck;

    public Hand(){
        hand = new Card[5];
        deck = new Deck();
    }

    public void newHand(){
        deck.shuffle();
        for(int i = 0; i < 5; i++){
            hand[i] = deck.deal();
        }
    }
    // getHand to have a description of Cards in Hand
    public String[] getHand(){
        // an new String array of size 5 to get the names of cards
        String[] cardinhand = new String[5];
        for(int i = 0; i < 5; i++){
            cardinhand[i] = hand[i].getName();
        }

        return cardinhand;
    }

    public static void main(String[] args) {
        Hand testhand = new Hand();
        testhand.newHand();
        String[] testhanddescription = testhand.getHand();
        for(int i = 0; i < 5; i++){
            System.out.println(testhanddescription[i]);
        }
    }
}
