package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static String line = "";
    private static Stack<String> stack = new Stack<>();
    private static Scanner scanner = new Scanner(System.in);

    static void append(String string) {
        stack.push(line);
        line = line + string;
    }

    static void print(int index) {
        System.out.println(line.charAt(index - 1));
    }

    static void delete(int numOfElement) {
        stack.push(line);
        line = line.substring(0, line.length() - numOfElement);

    }

    static void undo() {
        line = stack.pop();
    }

    static void choice(int choice) {
        switch (choice) {
            case 1:
                String line = scanner.nextLine();
                append(line);
                break;
            case 2:
                int numOfElement = scanner.nextInt();
                delete(numOfElement);
                break;
            case 3:
                int index = scanner.nextInt();
                print(index);
                break;
            case 4:
                undo();
                break;
        }
    }

    public static void main(String[] args) {
        int numOfQuery = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfQuery; i++) {
            int choice = scanner.nextInt();
            choice(choice);
        }
    }
}
