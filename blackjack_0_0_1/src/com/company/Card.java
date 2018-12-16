package com.company;

public class Card {

    private int cardIdx;
    private int scoreValue;
    private int suite;
    private String cardName;
    private String suiteName;


    Card(int idx, int suiteidx) {
        suite = suiteidx;
        cardIdx = idx;

        switch (suite) {
            case 1: {
                suiteName= "Hearts";
                break;
            }
            case 2: {
                suiteName= "Diamonds";
                break;
            }
            case 3: {
                suiteName= "Clubs";
                break;
            }
            case 4: {
                suiteName= "Spades";
                break;
            }
        }

        switch (idx) {
            case 1: {
                cardName = "Ace";
                scoreValue = 11;
                break;
            }
            case 2: {
                cardName = "Two";
                scoreValue = 2;
                break;
            }
            case 3: {
                cardName = "Three";
                scoreValue = 3;
                break;
            }
            case 4: {
                cardName = "Four";
                scoreValue = 4;
                break;
            }
            case 5: {
                cardName = "Five";
                scoreValue = 5;
                break;
            }
            case 6: {
                cardName = "Six";
                scoreValue = 6;
                break;
            }
            case 7: {
                cardName = "Seven";
                scoreValue = 7;
                break;
            }
            case 8: {
                cardName = "Eight";
                scoreValue = 8;
                break;
            }
            case 9: {
                cardName = "Nine";
                scoreValue = 9;
                break;
            }
            case 10: {
                cardName = "Ten";
                scoreValue = 10;
                break;
            }
            case 11: {
                cardName = "Jack";
                scoreValue = 10;
                break;
            }
            case 12: {
                cardName = "Queen";
                scoreValue = 10;
                break;
            }
            case 13: {
                cardName = "King";
                scoreValue = 10;
                break;
            }
        }
    }

    String printCardInfo() {
        String temp;
        temp= cardName + " of " + suiteName + ".";
        return temp;
    }

    int getScoreValue() {
        return scoreValue;
    }
    public int getCardIdx() { return cardIdx;}




}
