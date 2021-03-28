package ua.com.alevel.level_2;

import java.util.Scanner;
import java.util.Stack;

public class Brackets {
    static char rev(char c) {

        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        } else if (c == '}') {
            return '{';
        }

        return c;
    }

    public void go() {
        System.out.println("2 level: Brackets");
        System.out.println("Write line with brackets to check the correctness of their order");
        Scanner con = new Scanner(System.in);
        String Line;
        Line = con.nextLine();
        Stack<Character> s = new Stack<>();

        int Flag = 0;
        for (int i = 0; i < Line.length(); i++) {
            if (Flag > 0) break;
            if ((Line.charAt(i) == '(') || (Line.charAt(i) == '[' || (Line.charAt(i) == '{')))
                s.push(Line.charAt(i));
            if ((Line.charAt(i) == ')') || (Line.charAt(i) == ']' || (Line.charAt(i) == '}'))) {
                if (s.empty() || (s.peek() != rev(Line.charAt(i))))
                    Flag = 1;
                else s.pop();
            }
        }
        if (!s.empty()) Flag = 1;
        if (Flag > 0) System.out.println("Incorrect");
        else System.out.println("Correct");

    }
}
