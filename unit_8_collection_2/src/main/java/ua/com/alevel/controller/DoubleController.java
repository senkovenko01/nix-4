package ua.com.alevel.controller;

import ua.com.alevel.list.MathSet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class DoubleController {

    private static final Scanner scanner = new Scanner(System.in);

    public void run(){

        MathSet<Double> mathSet = new MathSet<>();
        boolean close = true;
        while (close) {

            System.out.println("0. - Exit\n" +
                    "1. -  Add\n" +
                    "2. -  Join\n" +
                    "3. -  Sort\n" +
                    "4. -  Get element(s)\n" +
                    "5. -  Squash\n" +
                    "6. -  Print");

            switch (scanner.nextLine()) {
                case "1": {
                    double a = scanDouble();
                    if (mathSet.contains(a))
                        System.out.println("This element already exist in mathSet");
                    else {
                        mathSet.add(a);
                        System.out.println("Element is added");
                    }
                    break;
                }
                case "2": {
                    System.out.println("How much element add?");
                    int count = IntegerController.scanInt();
                    System.out.println("Enter element(s)");
                    MathSet<Double> newSet = new MathSet<>();
                    for (int i = 0; i < count; i++) {
                        newSet.add(scanDouble());
                    }
                    print(newSet);
                    mathSet.join(newSet);
                    break;
                }
                case "3": {
                    boolean fal = true;
                    while (fal) {

                        System.out.println("0. - Exit\n" +
                                "1. -  Decs sort all\n" +
                                "2. -  Desc sort (might enter first and last index)\n" +
                                "3. -  Decs sort (begin from element)\n" +
                                "4. - Asc sort all\n" +
                                "5. - Asc sort (might enter first and last index)\n" +
                                "6. - Acs sort (begin from element)\n");

                        switch (scanner.nextLine()) {
                            case "1": {
                                mathSet.sortDesc();
                                print(mathSet);
                                break;
                            }
                            case "2": {
                                System.out.println("Enter first index:");
                                int a = IntegerController.scanInt();
                                System.out.println("Enter last index:");
                                int b = IntegerController.scanInt();
                                try {
                                    mathSet.sortDesc(a, b);

                                    print(mathSet);
                                } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("INCORRECT INPUT");
                                }
                                break;
                            }
                            case "3": {
                                System.out.println("Enter start element:");
                                double f = scanDouble();
                                try {
                                    mathSet.sortDesc(f);
                                    print(mathSet);
                                } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("INCORRECT INPUT!!!");
                                }
                                break;
                            }
                            case "4": {
                                mathSet.sortAsc();
                                print(mathSet);
                                break;
                            }
                            case "5": {
                                System.out.println("Enter first index:");
                                int a = IntegerController.scanInt();
                                System.out.println("Enter last index:");
                                int b = IntegerController.scanInt();
                                try {
                                    mathSet.sortAsc(a, b);
                                    print(mathSet);
                                } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("INCORRECT INPUT!!!");
                                }
                                break;
                            }
                            case "6": {
                                System.out.println("Enter start element:");
                                double a = scanDouble();
                                try {
                                    mathSet.sortAsc(a);
                                    print(mathSet);
                                } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("INCORRECT INPUT!!!");
                                }
                                break;
                            }
                            case "0": {
                                fal = false;
                            }
                        }
                    }
                    break;
                }
                case "4": {
                    boolean fal = true;
                    while (fal) {
                        System.out.println("0. - Exit\n" +
                                "1. -  Max value\n" +
                                "2. -  Min value\n" +
                                "3. -  Average\n" +
                                "4. - Median");
                        switch (scanner.nextLine()) {
                            case "1": {
                                System.out.println("Max = " + mathSet.getMax());
                                break;
                            }
                            case "2": {
                                System.out.println("Min = " + mathSet.getMin());
                                break;
                            }
                            case "3": {
                                System.out.println("Average = " + mathSet.getAverage());
                                break;
                            }
                            case "4": {
                                System.out.println("Median = " + mathSet.getMedian());
                                break;
                            }
                            case "0": {
                                fal = false;
                            }
                        }
                    }
                    break;
                }
                case "5": {
                    System.out.println("Enter first index:");
                    int a = IntegerController.scanInt();
                    System.out.println("Enter last index:");
                    int b = IntegerController.scanInt();
                    try {
                        mathSet = mathSet.squash(a, b);
                        print(mathSet);

                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                        System.out.println("INCORRECT INPUT");
                    }
                    break;
                }
                case "6": {
                    print(mathSet);
                    break;
                }
                case "0": {
                    close = false;
                }
            }
        }
    }

    public static void print(MathSet set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
            System.out.print(" " + iterator.next() + " ");
        System.out.println();
    }

    public static double scanDouble() {

        double res;
        while (true) {
            System.out.println("Enter double: ");
            String number = scanner.nextLine();
            try {
                res = Double.parseDouble(number);
                return res;
            } catch (NumberFormatException e) {
                System.out.println("Enter the number");
            }
        }
    }
}
