package org.example;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.File;
import java.util.ArrayList;

public class Word {

    private static List<String> wordsToChoose;
    private static int wordGenerateMode;



    public static String getCountryName() {
        Random random = new Random();

        if (wordsToChoose == null || wordGenerateMode == 2) {
            String[] toList = Locale.getISOCountries();
            wordsToChoose = Arrays.asList(toList);
            wordGenerateMode = 1;
        }

        String countryCode = wordsToChoose.get(random.nextInt(249));
        Locale loc = new Locale("English", countryCode);
        String countryName = loc.getDisplayCountry(Locale.US).toLowerCase();
        return countryName;
    }

    public static String getFruitsName() throws FileNotFoundException {

        if (wordsToChoose == null || wordGenerateMode == 1) {
            Path path = Paths.get("src/main/java/org/example/fruits.txt");
            File file = path.toFile();
            Scanner scanner = new Scanner(file);

            wordsToChoose = new ArrayList<>();

            while(scanner.hasNext()) {
                wordsToChoose.add(scanner.nextLine());
            }
        }

        Random random = new Random();
        String fruitName = wordsToChoose.get(random.nextInt(wordsToChoose.size()));

        return fruitName;
    }

}
