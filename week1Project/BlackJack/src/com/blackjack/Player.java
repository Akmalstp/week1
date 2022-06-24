package com.blackjack;

public class Player {

    private String name;
    private Card[] hand = new Card[10];
    private int numCards;

    public Player(String aName) {
        this.name = aName;

        //initially players hand should be empty.
        this.emptyHand();
    }
    //method to empty player hand.
    public void emptyHand() {
    for(int c = 0; c<10;c++) {
        this.hand[c] = null;
       }
    this.numCards =0;
  }
  //method to add card.
    public boolean addCard(Card aCard){
        //checking if max card limit is reached or not.
        if(this.numCards == 10){
            System.err.printf("%s's hand already has 10 cards; "+"cannot add another\n"+this.name);
            System.exit(1);
        }
        this.hand[this.numCards] = aCard;
        this.numCards++;

        return (this.getHandSum() <=21);
    }

    public int getHandSum(){
        int handSum = 0;
        int cardNum;
        int numAces = 0;

        for(int c=0; c < this.numCards; c++){
            //adding values of current card
            cardNum = this.hand[c].getNumber();

            if(cardNum == 1){
                numAces++;
                handSum += 11;
            }else if(cardNum>10){
                handSum += 10;
            }else{
                handSum += cardNum;
                }

            }
        //when Aces causes our hand sum to become more than 21;
        while(handSum > 21 && numAces >0){

            handSum -= 10;
            numAces--;
        }
        return handSum;
    }
    //printing hand of player
    public void printHand(boolean showFirstCard){
        System.out.printf("%s's cards:\n", this.name);
        for(int c=0; c<this.numCards; c++){
            if(c==0 && !showFirstCard){
                System.out.println("  [hidden]");
            }else{
                System.out.printf("  %s\n", this.hand[c].toString());
            }
        }
    }
}
