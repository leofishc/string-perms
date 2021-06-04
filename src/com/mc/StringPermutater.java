package com.mc;

import java.util.HashSet;
import java.util.Set;

public final class StringPermutater {

    public static void printStringPermutations(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("No string provided to permutate");
        }
        if (args.length > 1) {
            throw new Exception("Permutation of multiple strings not supported");
        }

        Set<String> permutations = permutateString(args[0]);

        permutations.forEach(System.out::println);
    }

    public static Set<String> permutateString(String string) {
        Set<String> permutations = new HashSet<>();

        if (string != null && !string.isEmpty()) {
            permutateStringHelper(permutations, new StringBuilder(), new StringBuilder(string));
        }
        return permutations;
    }

    private static void permutateStringHelper(Set<String> permutations, StringBuilder currentString, StringBuilder remainingString) {
        if (remainingString.length() == 0) {
            permutations.add(currentString.toString());
            return;
        }
        for (int i = 0; i < remainingString.length(); i++) {
            StringBuilder currentStringCopy = new StringBuilder(currentString);
            currentStringCopy.append(remainingString.charAt(i));

            StringBuilder remainingStringCopy = new StringBuilder(remainingString);

            permutateStringHelper(permutations, currentStringCopy, remainingStringCopy.deleteCharAt(i));
        }
    }
}
