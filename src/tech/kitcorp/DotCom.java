package tech.kitcorp;

import java.util.ArrayList;

public class DotCom {

    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "Miss";
        int index = locationCells.indexOf(userInput);
        if(index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "Eliminated";
                System.out.println(name + " has been eliminated");
            } else {
                result = "Hit confirmed";
            }
        }
        return result;
    }
}