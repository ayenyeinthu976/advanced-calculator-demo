package com.solt.jdc;

import java.util.Scanner;

public class AdvancedCalculatorDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // Yes, Java's double type can handle numeric values with leading zeros (eg.09 or 009 as 9.0)
        
       // Multi-character operations (sqrt, sin, cos, tan) 
        //single-character operators like +, -, *, or /
        
        System.out.println("\n!!!Welcome to the Advanced Calculator!!!");

        while (true) {
            System.out.print("\nEnter first number (or 'exit' to quit): ");
            String input = scanner.nextLine();// why is nextLine() is used because (eg. 'exit' or multi-character operator)

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Validate first number input
            
           // isValidDouble() is not a method in the Double class in Java. The Double class provides methods like isNaN(), isInfinite(), parseDouble(), valueOf(), and more, but it does not include an isValidDouble() method.
            
            //To check if a string can be converted to a double without throwing a NumberFormatException.
            //To avoid runtime errors and provide user-friendly feedback when invalid input is given.
            //If the parsing succeeds, Double.parseDouble(str) will not throw an exception, and the method returns true.
           // If the parsing fails and throws a NumberFormatException, the method catches the exception and returns false.
            
            //The isValidDouble method is not part of any standard Java class. Instead, it is a custom method that you can define within any class you create.
            
           // isValidDouble method contains the Double.parseDouble method to check if a string can be converted to a double.
           
            if (!isValidDouble(input)) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }
            
            //double num1 variable is not initialized with a default value because it is always set by user input before it is used
            //The value of num2 is only required for certain operations (i.e., not for sqrt, sin, cos, or tan operations). For these operations, num2 is not used at all
          double num1 = Double.parseDouble(input);

            System.out.print("Enter the type of operation you want to perform (+, -, *, /, sqrt, ^, sin, cos, tan): ");
            
         // why is nextLine() is used because (eg. 'exit' or multi-character operator).Thus operation is String type.
            
            String operation = scanner.nextLine().trim().toLowerCase();

            double num2 = 0;
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan")) {
                System.out.print("Enter second number: ");
                String secondInput = scanner.nextLine();
                
                
//                 Prompt the user for input
//                System.out.print("Enter a string: ");
//                String input = sc.nextLine();
//                
//                 Get the first character
//                char firstChar = input.charAt(0);
                

                // Validate second number input
                if (!isValidDouble(secondInput)) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }

                num2 = Double.parseDouble(secondInput);
            }

            double result = 0;
            boolean validOperation = true;

            try {
                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            if (num1 > 0) {
                                result = Double.POSITIVE_INFINITY; // Represents +Infinity
                            } else if (num1 < 0) {
                                result = Double.NEGATIVE_INFINITY; // Represents -Infinity
                            } else {
                            	
                            	//In Java, the result of dividing 0 by 0 depends on the data type you are using:

                            	//1. Integer Division
                            	//For integer division (using int, long, short, byte), dividing 0 by 0 will throw an ArithmeticException because division by zero is undefined in integer arithmetic.
                            	//2. Floating-Point Division
                            	//For floating-point division (using float or double), dividing 0.0 by 0.0 results in NaN (Not-a-Number). In floating-point arithmetic, NaN is used to represent an undefined or unrepresentable value, such as the result of 0.0 / 0.0.
                            	
                                result = Double.NaN; // Not a Number (0 / 0 case)
                            }
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    case "sqrt":
                        result = Math.sqrt(num1);
                        break;
                    case "^":
                        result = Math.pow(num1, num2);
                        break;
                    case "sin":
                        result = Math.sin(Math.toRadians(num1));
                        break;
                    case "cos":
                        result = Math.cos(Math.toRadians(num1));
                        break;
                    case "tan":
                        result = Math.tan(Math.toRadians(num1));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        validOperation = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                validOperation = false;
            }

            if (validOperation) {
                if (Double.isNaN(result)) {
                    System.out.println("Result: It's not a number");
                } else if (Double.isInfinite(result)) {
                    if (result > 0) {
                        System.out.println("Result: Infinity");
                    } else {
                        System.out.println("Result: -Infinity");
                    }
                } else {
                    System.out.printf("Result: %.2f%n", result);
                }
            }
        }

        scanner.close();
        System.out.print("\nHave a nice day! Goodbye!");
    }

    // Method to check if a string can be converted to a double
    //why used static keyword: No Need for an Instance
    //Convenience: By making the method static, you can call it directly from the main method or any other static context without needing to create an instance of the class. This is convenient for utility methods that are general-purpose and don’t depend on object state.


    public static boolean isValidDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
