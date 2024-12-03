package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File myFile = new File("src/main/resources/input.txt");
            Scanner myReader = new Scanner(myFile);
            int mySafeReports = 0;
            while (myReader.hasNextLine()) {
                List<Integer> lane = new ArrayList<>();
                String data = myReader.nextLine();
                String[] words = data.split(" ");
                for (String word : words) {
                    lane.add(Integer.parseInt(word));
                }

                if (isSafe(lane) || canBeMadeSafe(lane)) {
                    mySafeReports++;
                }

            }

            System.out.println(mySafeReports);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }



    private static boolean isSafe(List<Integer> levels){
        boolean increasing = true;
        boolean decreasing = true;
        int myDiff = 0;

        for (int i = 1; i < levels.size(); i++) {
            myDiff = Math.abs(levels.get(i) - levels.get(i - 1));
            //myDiff = levels.get(i) - levels.get(i - 1);

            if (myDiff < 1 || myDiff > 3) {
                return false;
            }

            if (levels.get(i) > levels.get(i - 1)) {
                decreasing = false;
            }
            if (levels.get(i) < levels.get(i - 1)) {
                increasing = false;
            }
        }

        return increasing || decreasing;
    }

    private static boolean canBeMadeSafe(List<Integer> levels){
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> myModifiedLevels = new ArrayList<>(levels);
            myModifiedLevels.remove(i);
            if (isSafe(myModifiedLevels)) {
                return true;
            }
        }
        return false;
    }
}