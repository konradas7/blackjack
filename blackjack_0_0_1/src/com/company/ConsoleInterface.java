package com.company;

public interface ConsoleInterface {
    void printUserBlackjack();

    void printUserWin();

    void printEnemyBlackjack();

    void printDrawnCard(String s);

    void printUserScore(int userScore);

    void askUserHit();

    boolean userChoice();

    void printUserLost();

    void askUserNewGame();

    void printDealerStand();

    void printEnemyDraw(String s);

    void printEnemyScore(int dealerScore);
}
