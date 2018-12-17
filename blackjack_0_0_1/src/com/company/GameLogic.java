package com.company;

import java.util.concurrent.ThreadLocalRandom;

class GameLogic {

    private Deck deck;
    private ConsoleInterface view;
    private int userScore;
    private int dealerScore;
    private boolean userStand= false;
    private boolean dealerStand= false;



    GameLogic() {

        view = new ConsoleView();
        resetDeck();
        startUpDraw();
    }

    GameLogic(Boolean test) {
        resetDeck();
    }

    private int getRandomNumber(int cardsInDeck) {
        return ThreadLocalRandom.current().nextInt(1, cardsInDeck +1);
    }

    private void resetDeck() {
        deck = new Deck();
        userScore = 0;
        dealerScore = 0;
        userStand= false;
        dealerStand= false;
    }

    private void startUpDraw() {
        userDrawAction();
        dealerDrawnAction();
        userDrawAction();
        dealerDrawnAction();


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

    private void userDrawAction() {
        Card card;
        card = deck.drawCard(getRandomNumber(deck.cardsRemaining()));
        view.printDrawnCard(card.printCardInfo());
        userScore = userScore + card.getScoreValue();
        view.printUserScore(userScore);
    }

    private void userDraw() {
        if (!userStand) {
            if ((userScore > dealerScore) && (dealerStand)) {

                restartGameUserWin();
            }

            view.askUserHit();

            if (view.userChoice()) {
                userDrawAction();

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
            else if ((dealerScore < userScore) && (userStand)) {
                dealerDrawnAction();
            }
            else if ((dealerScore == userScore) && (userStand)) {
                view.printDealerStand();
                dealerStand= true;
            }
            else {
                if ((dealerScore > 16)) {
                    view.printDealerStand();
                    dealerStand= true;
                }
                else {
                    dealerDrawnAction();
                }
            }
        }
        if (dealerScore > 21) {
            restartGameUserWin();
        }

                if (dealerStand && userStand) {
                    if ((dealerScore > userScore)) {
                        restartGameUserLost();
                    }
                } else if (!userStand) {
                    userDraw();
                }
    }

    private void dealerDrawnAction() {
        Card card = deck.drawCard(getRandomNumber(deck.cardsRemaining()));
        view.printEnemyDraw(card.printCardInfo());
        dealerScore = dealerScore + card.getScoreValue();

        view.printEnemyScore(dealerScore);
    }


    private boolean checkDealerBlackjack() {
        return dealerScore == 21;
    }

    private boolean checkUserBlackjack() {
        return userScore == 21;
    }
}
