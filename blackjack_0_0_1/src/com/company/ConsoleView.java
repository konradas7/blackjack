package com.company;

import java.util.Scanner;

class ConsoleView implements ConsoleInterface {


    private String tempText;

    private void print() {
        System.out.println(tempText);
    }

    public void printDrawnCard(String text) {
        tempText = "You have drawn: " + text;
        print();
    }

    public boolean userChoice() {
            Scanner scanIn = new Scanner(System.in);
            String choice = "n";
            choice = scanIn.nextLine();
        return choice.equalsIgnoreCase("Y");


    }

    public void askUserHit() {
        tempText= "Hit? (Y/N)";
        print();
    }

    public void askUserNewGame() {
        tempText= "Do you want to play again? (Y/N)";
        print();
    }

    public void printUserLost() {
        tempText= "Sorry, you have lost!";
        print();
    }

    public void printUserWin() {
        tempText= "Congratulations, you have won!";
        print();
    }

    public void printUserScore(int score) {
        tempText= "Your score currently is: " + score;
        print();
    }

    public void printEnemyDraw(String text) {
        tempText= "The dealer has drawn a card: " + text;
        print();
    }

    public void printEnemyScore(int score) {
        tempText= "The dealers score currently is: " + score;
        print();
    }

    public void printUserBlackjack() {
        tempText= "Blackjack!";
        print();
    }

    public void printEnemyBlackjack() {
        tempText= "Dealer Blackjack!";
        print();
    }


    public void printDealerStand() {
        tempText = "Dealer stands";
        print();
    }
}
