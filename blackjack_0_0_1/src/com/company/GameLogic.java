package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class GameLogic {

    Deck deck;
    ConsoleView view;
    int userScore;
    int dealerScore;
    boolean userStand= false;
    boolean dealerStand= false;



    GameLogic() {

        view = new ConsoleView();
        resetDeck();
        startUpDraw();
    }

    int getRandomNumber(int cardsInDeck) {
        int rnd = ThreadLocalRandom.current().nextInt(1, cardsInDeck +1);
        return rnd;
    }

    private void resetDeck() {
        deck = new Deck();
        userScore = 0;
        dealerScore = 0;
        userStand= false;
        dealerStand= false;
    }

    void startUpDraw() {
        Card card;
        card = deck.drawCard(getRandomNumber(deck.cardsRemaining()));
        view.printDrawnCard(card.printCardInfo());
        userScore = userScore + card.getScoreValue();

        card = deck.drawCard(getRandomNumber(deck.cardsRemaining()));
        view.printEnemyDraw(card.printCardInfo());
        dealerScore = dealerScore + card.getScoreValue();

        card = deck.drawCard(getRandomNumber(deck.cardsRemaining()));
        view.printDrawnCard(card.printCardInfo());
        userScore = userScore + card.getScoreValue();

        card = deck.drawCard(getRandomNumber(deck.cardsRemaining()));
        view.printEnemyDraw(card.printCardInfo());
        dealerScore = dealerScore + card.getScoreValue();

        view.printUserScore(userScore);
        view.printEnemyScore(dealerScore);

        if (checkUserBlackjack()) {
            view.printUserBlackjack();
            view.printUserWin();
            restartGameUserWin();
        }

        if (checkDealerBlackjack()) {
            view.printEnemyBlackjack();
            restartGameUserLost();
        }

        userDraw();


    }

    private void userDraw() {
        if (!userStand) {
            if ((userScore > dealerScore) && (dealerStand)) {

                restartGameUserWin();
            }

            view.askUserHit();

            if (view.userChoice()) {
                Card card = deck.drawCard(getRandomNumber(deck.cardsRemaining()));
                view.printDrawnCard(card.printCardInfo());
                userScore = userScore + card.getScoreValue();
                if (userScore > 21 && card.cardIdx == 1) userScore= userScore - 10;

                view.printUserScore(userScore);

                if (userScore > 21) {
                    restartGameUserLost();
                }
            }
            else {
                userStand = true;
            }
        }
        if (dealerStand && userStand) {
            if (( dealerScore>= userScore)) {
               restartGameUserLost();
            }
        }
        else if (!dealerStand) {
            dealerDraw();
        }

    }

    private void restartGameUserLost() {
        view.printUserLost();
        view.askUserNewGame();
        if(view.userChoice()) {
            resetDeck();
            startUpDraw();
        }
        else {
            System.exit(0);
        }
    }

    private void restartGameUserWin() {
        view.printUserWin();
        view.askUserNewGame();
        if(view.userChoice()) {
            resetDeck();
            startUpDraw();
        }
        else {
            System.exit(0);
        }
    }

    private void dealerDraw() {
        if (!dealerStand) {

            if ((dealerScore > userScore) && (userStand)) {
                restartGameUserLost();
            }

            if (dealerScore > 16) {
                view.printDealerStand();
                dealerStand = true;
            }

            if ((dealerScore < userScore) && (userStand)) {
                Card card = deck.drawCard(getRandomNumber(deck.cardsRemaining()));
                view.printEnemyDraw(card.printCardInfo());
                dealerScore = dealerScore + card.getScoreValue();

                view.printEnemyScore(dealerScore);

                if (dealerScore > 21) {
                    restartGameUserWin();
                }
            }

            if ((dealerScore == userScore) && (userStand)) {

                    Card card = deck.drawCard(getRandomNumber(deck.cardsRemaining()));
                    view.printEnemyDraw(card.printCardInfo());
                    dealerScore = dealerScore + card.getScoreValue();

                    view.printEnemyScore(dealerScore);

                    if (dealerScore > 21) {
                        restartGameUserWin();
                    }

                }
            }



                if (dealerStand && userStand) {
                    if ((dealerScore > userScore)) {
                        restartGameUserLost();
                    }
                } else if (!userStand) {
                    userDraw();
                }
    }



    private boolean checkDealerBlackjack() {

        if (dealerScore == 21) {
            return true;
        }
        return false;
    }

    private boolean checkUserBlackjack() {
        if (userScore == 21) {
            return  true;
        }
        return false;
    }
}
