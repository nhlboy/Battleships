package tech.kitcorp;

import java.util.ArrayList;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        // Create enemy army
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Ваша цель - потопить три \"сайта\".");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to do this with minimum missile lunches");

        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);

            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while(!dotComList.isEmpty()) {

            String userGuess = helper.getUserInput("Shoot");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;

        String result = "Missed";

        for (DotCom dotComToTest : dotComList) {
            result = dotComToTest.checkYourself(userGuess);

            if(result.equals("Hit confirmed")) {
                break;
            }
            if (result.equals("Eliminated")) {
                dotComList.remove(dotComToTest);
                break;
            }
        }

        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All targets eliminated");
        if(numOfGuesses <= 18) {
            System.out.println("You used " + numOfGuesses + "missiles");
        } else {
            System.out.println("No more missiles left");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
