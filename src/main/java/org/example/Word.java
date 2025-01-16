package org.example;

import java.util.Locale;
import java.util.Random;

public class Word {

    private String word;

    Word() {
        Random random = new Random();
        String countryCode = Locale.getISOCountries()[random.nextInt(249)];
        Locale loc = new Locale("English", countryCode);
        this.word = loc.getDisplayCountry(Locale.US).toLowerCase();
    }

    public String getWord() {
        return word;
    }
}
