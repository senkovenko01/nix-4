package ua.com.alevel.controller;

import ua.com.alevel.list.MathSet;


import java.util.Iterator;
import java.util.Scanner;

public class IntegerController {
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        MathSet<Integer> mathSet = new MathSet<>();
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
                    int s = scanInt();
                    if (mathSet.contains(s))
                        System.out.println("This element already exist in mathSet");
                    else {
                        mathSet.add(s);
                        System.out.println("Element is added");
                    }
                    break;
                }
                case "2": {

                    System.out.println("How much element add?");
                    int count = scanInt();
                    System.out.println("Enter element(s)");
                    MathSet<Integer> newSet = new MathSet<>();
                    for (int i = 0; i < count; i++) {
                        newSet.add(scanInt());
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
                                int a = scanInt();
                                System.out.println("Enter last index:");
                                int b = scanInt();
                                try {
                                    mathSet.sortDesc(a, b);
                                    print(mathSet);
                                } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("INCORRECT INPUT!!!");
                                }
                                break;
                            }
                            case "3": {
                                System.out.println("Enter start element:");
                                int a = scanInt();
                                try {
                                    mathSet.sortDesc(a);
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
                                int a = scanInt();
                                System.out.println("Enter last index:");
                                int b = scanInt();
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
                                int a = scanInt();
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
                    int a = scanInt();
                    System.out.println("Enter last index:");
                    int b = scanInt();
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

    public static void print(MathSet mathSet) {

        Iterator<Integer> iterator = mathSet.iterator();

        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next() + " ");
            System.out.println();
        }
    }

    public static int scanInt() {

        int res;
        while (true) {

            System.out.println("Enter integer: ");
            String number = scanner.nextLine();
            try {
                res = Integer.parseInt(number);
                return res;
            } catch (NumberFormatException e) {
                System.out.println("Enter the number");
            }
        }
    }
}

