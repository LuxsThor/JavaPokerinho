public class PokerGame {
    private Bet bet;
    private Player player;
    private Bankroll bankroll;
    private boolean[] holdcards;
    private Hand hand;

    public PokerGame(){
        hand = new Hand();
        holdcards = new boolean[5];
    }

    public PokerGame(Bet coins, Bankroll br, Player someperson){
        bet = coins;
        bankroll = br;
        player = someperson;
        hand = new Hand();
        holdcards = new boolean[5];
    }

    public int updateBankroll(int payout){
        int winnings = payout * (bet.getBet());  // negative for a loss
        bankroll.alterBankroll(winnings);
        return winnings;
    }

    public void viewInitialHand(){
        hand.newHand(); // send a message to hand, instantiate a hand
        player.displayHand(hand.getHand()); // tell player to display the new hand
    }

    public void discardOrHoldCards(){
        player.getDiscard(holdcards); // ask player for the discard list
        hand.updateHand(holdcards); // passes discards to hand and hand updates itself
        player.displayHand(hand.getHand()); // tell player to show the (revised) hand
        int payout = hand.evaluateHand(); // tell hand to evaluate itself and return the payout
        int winnings = updateBankroll(payout); // update the bankroll, a PokerGame method
        player.displayResults(payout, winnings); // tell player to display outcome of the game
    }
}
