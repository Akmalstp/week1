package com.blackjack;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {

        //init the deck
        Scanner sc  = new Scanner(System.in);
        Deck theDeck = new Deck(1,true);

        //init the players
        Player me = new Player("Akmal");
        Player dealer = new Player("Dealer");

        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());

        //print initial hands
        System.out.println("Cards are dealt\n");
        me.printHand(true);
        dealer.printHand(false);
        System.out.println("\n");

        //hitting flags
        boolean meDone = false;
        boolean dealerDone = false;
        String ans;

        while(!meDone || !dealerDone){
            //players turn
            if(!meDone){
                System.out.print("Hit or Stay? (Enter H or S): ");
                ans = sc.next();
                System.out.println();

                //If player hits
                if(ans.compareToIgnoreCase("H")==0){
                    meDone = !me.addCard(theDeck.dealNextCard());
                    me.printHand(true);
                }else{
                    meDone = true;
                }
            }
            if(!dealerDone){
                if(dealer.getHandSum() < 17){
                    System.out.println("The Dealer hits\n");
                    dealerDone = !dealer.addCard(theDeck.dealNextCard());
                    dealer.printHand(false);
                }else{
                    System.out.println("The Dealer stays\n");
                    dealerDone = true;
                }
            }
            System.out.println();
        }
        sc.close();
        //printing final sum
        me.printHand(true);
        dealer.printHand(true);

        int mySum = me.getHandSum();
        int dealerSum = dealer.getHandSum();

        if(mySum > dealerSum && mySum <= 21 || dealerSum > 21){
            System.out.println("Your win!");
        }else{
            System.out.println("Dealer wins!");
        }
    }
}
