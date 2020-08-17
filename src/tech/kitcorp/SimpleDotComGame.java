package tech.kitcorp;

public class SimpleDotComGame {

    public static void main(String[] args) {

        // Temp variable for counting player's turns
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();

        DotCom theDotCom = new DotCom();

        int randomNum = (int) (Math.random() * 5);

        int[] locations = {randomNum, randomNum+1, randomNum+2};
        theDotCom.setLocationCells(locations);

        boolean isAlive = true;

        while(isAlive == true) {
            String guess = helper.getUserInput("Pls enter the number:");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("Target Eliminated")) {
                isAlive = false;
                System.out.println("You did " + numOfGuesses + " missile lunches");
            }
        }
    }
}
