package com.blackjack;

import java.util.Random;

public class Deck {

    //representing a real deck.
    private Card[] myCards;
    //representing that how many cards are left in the deck array.
    private int numCards;
    //no arg constructor
    public Deck(){
        this(1, false);
    }

    //constructor
    public Deck(int numDeck, boolean shuffle){
        this.numCards = numDeck*52;
        this.myCards = new Card[this.numCards];
        //initially deck is empty
        int c = 0;

        //setting all cards in the decks
        for(int d= 0; d<numDeck; d++){
            //setting all four suits
            for(int s = 0; s<4; s++){
                //setting all 13 cards
                for(int n=1; n<=13; n++){
                    this.myCards[c] = new Card(Suit.values()[s], n);
                    c++;
                }
            }
        }
        //if chosen we will shuffle
        if(shuffle){
            this.shuffle();
        }
    }

    //shuffle method
    public void shuffle(){
        Random rng = new Random();
        Card temp;
        int j;

        for (int i = 0; i < this.numCards; i++) {

            //getting a random card;
            j = rng.nextInt(this.numCards);
            //doing swap
            temp = this.myCards[i];
            this.myCards[i] = this.myCards[j];
            this.myCards[j] = temp;
        }
    }

    //method to deal next card
    public Card dealNextCard(){
        //fetching the card which is in the top
        Card top = this.myCards[0];

        //now lets shift all cards to left by one.
        for(int c = 1; c < this.numCards; c++){
            this.myCards[c-1] = this.myCards[c];
        }
        this.myCards[this.numCards-1] = null;

        this.numCards--;

        return top;
    }

    //printing the deck
    public void printDeck(int numToPrint){
        for(int c =0; c<numToPrint; c++){
            System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());
        }
        System.out.printf("\t\t[%d other]\n", this.numCards-numToPrint);
    }
}

