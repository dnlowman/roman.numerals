package com.daniellowman;

import java.util.HashMap;

public class Solver {
    public static final HashMap<Character, Integer> characters = new HashMap<>();

    static {
        characters.put('I', 1);
        characters.put('V', 5);
        characters.put('X', 10);
        characters.put('L', 50);
        characters.put('C', 100);
        characters.put('D', 500);
        characters.put('M', 1000);
    }

    public int solve(String romanNumeral) {
        var result = 0;
        var previous = 0;
        for(var character : romanNumeral.toCharArray()) {
            var current = characters.get(character);

            if(previous == 0)
                result = current;
            else if(current <= previous) {
                result += current;
            }
            else if(current > previous) {
                result += (current - previous) - previous;
            }
            else
                result += current;
            previous = current;
        }

        return result;
    }

}
