package ua.com.alevel.reverse;

import ua.com.alevel.ReverseString;

public class Application {

    public void run() {

        String input = "Some line";
        System.out.println("original: " + input + " - Simple reverse: " + ReverseString.reverse(input));
        System.out.println("original: " + input + " - Reverse with destination: " + ReverseString.reverse(input, "lin"));
        System.out.println("original: " + input + " - Reverse with first and last index: "
                + ReverseString.reverse(input, 2, 5));
    }


}
