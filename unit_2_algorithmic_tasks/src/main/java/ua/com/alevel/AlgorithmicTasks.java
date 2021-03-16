package ua.com.alevel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AlgorithmicTasks {

    static Scanner scanner = new Scanner(System.in);

    public static int findSumOfNumbers(String str) {
        StringBuilder strResult = new StringBuilder("0");
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                strResult.append(c);
            } else {
                sum += Integer.parseInt(strResult.toString());
                strResult = new StringBuilder("0");
            }
        }
        return sum + Integer.parseInt(strResult.toString());
    }

    public static void howManySymbolsInLine(String input) {
        Map<Character, Integer> Line = new TreeMap<>(new HashMap<>
                (Math.min(input.length(), Character.MAX_VALUE) / 2));
        char c;
        for (int i = 0; i < input.length(); ++i) {
            c = input.charAt(i);
            if (!Line.containsKey(c)) {
                Line.put(c, 0);
            }
            Line.put(c, Line.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> entry : Line.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print("-");
            System.out.print(entry.getValue());
            System.out.println(" ");
        }
    }

    public static void whenLessonEnds(int lesson) {
        int hour, minutes;
        hour = lesson * 45 + (lesson / 2) * 5 + ((lesson + 1) / 2 - 1) * 15;
        minutes = hour % 60;
        System.out.println(lesson + " lesson - " + (hour / 60 + 9 + ":" + minutes));
    }

    public static void main(String[] args) {

        Scanner check = new Scanner(System.in);
        System.out.println("You might select number of task");
        System.out.println("If you want find sum of numbers from line, write: 1");
        System.out.println("If you want count letters in line, write: 2");
        System.out.println("If you want to know what time the lesson ends, write: 3");
        int option = check.nextInt();
        switch (option) {
            case 1:
                System.out.println("You are selected 1 program!");
                System.out.println("You will find sum of numbers from line including numbers. Just write");
                String str = scanner.nextLine();
                System.out.println("Result: ");
                System.out.println(AlgorithmicTasks.findSumOfNumbers("result: " + str));
                break;
            case 2:
                System.out.println("You are selected 2 program!");
                System.out.println("Write some line");
                String input = scanner.nextLine();
                System.out.println("Result: ");
                howManySymbolsInLine(input);

                break;
            case 3:
                System.out.println("You are selected 3 program!");
                System.out.println("Write the number of lesson");
                int lesson = scanner.nextInt();
                System.out.println("Result: ");
                whenLessonEnds(lesson);
                break;
            default:
                System.out.println("You are selected non-existent number of task");
                break;
        }
    }
}
