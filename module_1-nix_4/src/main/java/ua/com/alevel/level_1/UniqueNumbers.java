package ua.com.alevel.level_1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueNumbers {

    private final Set<Integer> numbers = new HashSet<>();

    public  void go() {
        System.out.println("1 level, 3 task: Unique Numbers");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the size of the array");
        int size = scanner.nextInt();
        System.out.println("Write the numbers in order, to check the number of unique");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int n : arr) {
            numbers.add(n);
        }
        System.out.println(numbers.size());
    }

}
