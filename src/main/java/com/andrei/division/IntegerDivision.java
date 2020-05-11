package com.andrei.division;

import java.util.Scanner;

public class IntegerDivision {

    private static Scanner scanner;

    public static void main(String[] args) {
        LongDivision division = new LongDivision();
        Printer printer = new Printer();
        scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            try {
                try {
                    while (loop) {
                        int dividend = askUserForInteger("Введите число которое вы хотите разделить");
                        int divisor = askUserForInteger("Введите число на которое вы хотите разделить");
                        Result calculation = division.calculation(dividend, divisor);
                        String output = printer.printLongDivision(calculation);
                        System.out.println(output);
                    }
                } catch (IllegalStateException e) {
                    loop = false;
                }
            } catch (IllegalStateException | NegativeArraySizeException | ArithmeticException e) {
                System.out.println("Одна из переменых 0");
                loop = true;
            }
        }

    }

    private static int askUserForInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + "(or empty for exit): ");
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new IllegalStateException();
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input is not integer, try again");
            }
        }
    }
}
