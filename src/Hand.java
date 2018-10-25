public class Hand {
    private Card[] hand;
    private Deck deck;
    private int[] suits;
    private int[] ranks;

    public Hand(){
        hand = new Card[5];
        deck = new Deck();
        suits = new int[5];
        ranks = new int[14];
    }

    public void newHand(){
        deck.shuffle();
        for(int i = 0; i < 5; i++){
            hand[i] = deck.deal();
            suits[hand[i].getSuit()]++;
            ranks[hand[i].getValue()]++;


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

    public void updateHand(boolean keep[] ) {
        for (int i = 0; i < 5; i++) {
            if (!keep[i])
                suits[hand[i].getSuit()]--;
            ranks[hand[i].getValue()]--;

            hand[i] = deck.deal();

            suits[hand[i].getSuit()]++;
            ranks[hand[i].getValue()]++;
        }
        sort();
    }

    private void sort(){
        int max = 0;
        for (int place = 4; place > 0; place--){
            for(int i = 0; i < place; i++){
                if(hand[i].getValue() > hand[place].getValue()){
                    max = i;
                }
                Card temp = hand[place];
                hand[place] = hand[max];
                hand[max] = temp;
            }
        }
    }

    private boolean royalFlush() {
        boolean samesuit = false;
        boolean streetfromace = false;

        for (int i = 1; i < 5; i++)
            if (suits[i] == 5) samesuit = true;

        if (ranks[1] == 1 && ranks[13] == 1 && ranks[12] == 1 && ranks[11] == 1) streetfromace = true;

        if (samesuit && streetfromace) return true;
        else return false;
    }


    // stubs
    private boolean straightFlush()
    { return false; }
    private boolean fourOfAKind()
    { return false; }
    private boolean fullHouse()
    { return false; }
    private boolean flush()
    { return false; }
    private boolean straight()
    { return false; }
    private boolean threeOfAKind()
    { return false; }
    private boolean twoPair()
    { return false; }
    private boolean pair()
    { return false; }

    public static void main(String[] args) {
        Hand testhand = new Hand();
        testhand.newHand();
        String[] testhanddescription = testhand.getHand();
        for(int i = 0; i < 5; i++){
            System.out.println(testhanddescription[i]);
        }
    }
}
