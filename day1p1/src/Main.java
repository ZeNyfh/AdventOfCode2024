import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        List<String> fileInput = Files.readAllLines(Path.of("/home/zenyfh/IdeaProjects/AdventOfCode/day1p1/src/input.txt"), StandardCharsets.UTF_8);
        for (String line : fileInput) {
            if (Objects.equals(line, "")) {
                continue;
            }
            String[] splitString = line.split(" {3}");
            l1.add(Integer.parseInt(splitString[0]));
            l2.add(Integer.parseInt(splitString[1]));
        }

        Collections.sort(l1);
        Collections.sort(l2);

        int total = 0;
        for (int i = 0; i < l1.size(); i++) { // they are the same size, only need 1 loop
            total += abs(l1.get(i) - l2.get(i));
        }
        System.out.println(total);


    }
}