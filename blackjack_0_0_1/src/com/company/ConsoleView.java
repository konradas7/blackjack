package com.company;

import java.util.Scanner;

class ConsoleView {


    private String tempText;

    private void print() {
        System.out.println(tempText);
    }

    void printDrawnCard(String text) {
        tempText = "You have drawn: " + text;
        print();
    }

    boolean userChoice() {
            Scanner scanIn = new Scanner(System.in);
            String choice = "n";
            choice = scanIn.nextLine();
        return choice.equalsIgnoreCase("Y");


    }

    void askUserHit() {
        tempText= "Hit? (Y/N)";
        print();
    }

    void askUserNewGame() {
        tempText= "Do you want to play again? (Y/N)";
        print();
    }

    void printUserLost() {
        tempText= "Sorry, you have lost!";
        print();
    }

    void printUserWin() {
        tempText= "Congratulations, you have won!";
        print();
    }

    void printUserScore(int score) {
        tempText= "Your score currently is: " + score;
        print();
    }

    void printEnemyDraw(String text) {
        tempText= "The dealer has drawn a card: " + text;
        print();
    }

    void printEnemyScore(int score) {
        tempText= "The dealers score currently is: " + score;
        print();
    }

    void printUserBlackjack() {
        tempText= "Blackjack!";
        print();
    }

    void printEnemyBlackjack() {
        tempText= "Dealer Blackjack!";
        print();
    }


    void printDealerStand() {
        tempText = "Dealer stands";
        print();
    }
}
