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
            int mySafe = 0;
            while (myReader.hasNextLine()) {
                List<Integer> lane = new ArrayList<>();
                String data = myReader.nextLine();
                String[] words = data.split(" ");
                for (String word : words) {
                    lane.add(Integer.parseInt(word));
                }

                boolean ascending = false;
                boolean descending = false;
                int myDiff = 3;

                for (int i = 0; i < lane.size() - 1; i++) {
                    if (lane.get(i) > lane.get(i + 1)) {
                        if (ascending) {
                            ascending = false;
                            break;
                        }
                        else if (lane.get(i) > lane.get(i + 1) + myDiff) {
                            descending = false;
                            break;
                        }
                        descending = true;
                    }
                    else if (lane.get(i) < lane.get(i + 1)) {
                        if (descending) {
                            descending = false;
                            break;
                        }
                        else if (lane.get(i) < lane.get(i + 1) - myDiff) {
                            ascending = false;
                            break;
                        }
                        ascending = true;
                    }
                    else {
                        ascending = false;
                        descending = false;
                        break;
                    }
                }

                if (ascending || descending) {
                    mySafe++;
                }
            }

            System.out.println(mySafe);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}