package com.mc;

public class Main {

    /*
    Assumptions:
    each string permutation will be printed on a separate line
    this program will print an error message for cases when no strings are provided
    this program will print an error message for cases when more than 1 string is provided
    case sensitivity matters for the string provided
    if duplicate permutations exist, we only return one of them

    this runs in O(n!) where n is the number of characters in the string
    further practical runtime improvements can be achieved by implementing multithreading
    */
    
    public static void main(String[] args) {
        try {
            StringPermutater.printStringPermutations(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
