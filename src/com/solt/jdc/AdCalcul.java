package com.solt.jdc;
import java.util.Scanner;

public class AdCalcul {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("!!!Welcome to the Advanced Calculator!!!");

        while (true) {
            System.out.print("Enter first number (or 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Validate first number input
            if (!isValidDouble(input)) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            double firstNumber = Double.parseDouble(input);

            System.out.print("Enter the type of operation you want to perform (+, -, *, /, sqrt, ^, sin, cos, tan): ");
            String operation = scanner.nextLine();

            double secondNumber = 0;
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan")) {
                System.out.print("Enter second number: ");
                String secondInput = scanner.nextLine();

                // Validate second number input
                if (!isValidDouble(secondInput)) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }

                secondNumber = Double.parseDouble(secondInput);
            }

            double result = 0;
            boolean validOperation = true;

            try {
                switch (operation) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                    case "sqrt":
                        result = Math.sqrt(firstNumber);
                        break;
                    case "^":
                        result = Math.pow(firstNumber, secondNumber);
                        break;
                    case "sin":
                        result = Math.sin(Math.toRadians(firstNumber));
                        break;
                    case "cos":
                        result = Math.cos(Math.toRadians(firstNumber));
                        break;
                    case "tan":
                        result = Math.tan(Math.toRadians(firstNumber));
                        break;
                    default:
                        System.out.println("Invalid operator.");
                        validOperation = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                validOperation = false;
            }

            if (validOperation) {
                System.out.printf("Result: %.2f%n", result);
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }

    // Method to check if a string can be converted to a double
    public static boolean isValidDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
