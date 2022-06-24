package com.sudukoSol;

public class RecDemo {

    //to print symetrically in a ginven range.
    public void printHello(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printHello(n-1);
        System.out.println(n);
    }

    //to calculate sum of n natural numbers
    public int nSum(int n){
        if(n==1){
            return 1;
        }
        return n + nSum(n-1);
    }

    //to calculate power of a given number
    public int powerOf(int num, int power){
        if(power==0){
            return 1;
        }
        return num * powerOf(num, power-1);
    }

    public static void main(String[] args) {
        RecDemo rd = new RecDemo();
        rd.printHello(5);
        System.out.println(rd.nSum(5));
        System.out.println(rd.powerOf(5,3));
    }
}
