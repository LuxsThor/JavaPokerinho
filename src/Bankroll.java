public class Bankroll {
    private int bankroll;

    public Bankroll(){
        bankroll = 0;
    }

    public Bankroll(int bankroll){
        this.bankroll = bankroll;
    }

    public int getBankroll() {
        return bankroll;
    }

    public void setBankroll(int bankroll) {
        this.bankroll = bankroll;
    }

    public void alterBankroll(int change){
        bankroll += change;
    }

    public static void main(String[] args) {
        Bankroll mybank = new Bankroll();
        Bankroll billsbank = new Bankroll(999999999);
        System.out.println("I am poor I have a balance of " + mybank.getBankroll() +" while Bill has " + billsbank.getBankroll());
        mybank.alterBankroll(100000);
        System.out.println("i got paid recently! now I have "+mybank.getBankroll());
        billsbank.setBankroll(0);
        System.out.println("bill died and all his money got donated his account now has " + billsbank.getBankroll());
    }
}
