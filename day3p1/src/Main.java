import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> fileInput = Files.readAllLines(Path.of("/home/zenyfh/Documents/AdventOfCode2024/day3p1/src/input.txt"), StandardCharsets.UTF_8);
        Pattern p = Pattern.compile("mul\\((\\d{1,}),(\\d{1,})\\)");
        List<String> muls = new ArrayList<>();
        int total = 0;
        for (String line : fileInput) {
            if (Objects.equals(line, "")) {
                continue;
            }
            Matcher m = p.matcher(line);
            while (m.find()) {
                total += Integer.parseInt(m.group(1))*Integer.parseInt(m.group(2));
            }
        }
        System.out.println(total);
    }
}