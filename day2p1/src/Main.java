import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> reports = new ArrayList<>(); // lines
        List<Integer> levels;

        List<String> fileInput = Files.readAllLines(Path.of("/home/zenyfh/IdeaProjects/AdventOfCode/day2p1/src/input.txt"), StandardCharsets.UTF_8);
        for (String line : fileInput) {
            if (Objects.equals(line, "")) continue;
            levels = new ArrayList<>();
            for (String report : line.split(" ")) {
                levels.add(Integer.parseInt(report));
            }
            reports.add(levels);
        }

        // now check if safe

        int safe = 0;

        reports:
        for (int i = 0; i < reports.size(); i++) {
            Boolean decreasing = null;
            System.out.println(reports.get(i));
            for (int j = 0; j < reports.get(i).size()-1; j++) {
                int firstNum = reports.get(i).get(j);
                int secondNum = reports.get(i).get(j+1);
                if (firstNum == secondNum) {
                    System.out.println("was the same.");
                    continue reports;
                }
                if (decreasing != null) {
                    if (decreasing != firstNum > secondNum) {
                        System.out.println(decreasing + " became " + !decreasing);
                        continue reports;
                    }
                }

                decreasing = firstNum > secondNum;
                int difference = abs(firstNum-secondNum);
                System.out.println(difference);
                if (1 > difference || difference > 3) {
                    System.out.println(firstNum + " decreasing " + secondNum);
                    continue reports;
                }
            }
            System.out.println("the above is safe.");
            safe++;
        }

        System.out.println("answer: " + safe);
    }
}