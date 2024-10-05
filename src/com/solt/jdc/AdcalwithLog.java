package com.solt.jdc;
import java.util.Scanner;

public class AdcalwithLog {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("\n!!!Welcome to the Advanced Calculator!!!");

	        while (true) {
	            System.out.print("\nEnter first number (or 'exit' to quit): ");
	            String input = scanner.nextLine();

	            if (input.equalsIgnoreCase("exit")) {
	                break;
	            }

	            if (!isValidDouble(input)) {
	                System.out.println("Invalid input. Please enter a valid number.");
	                continue;
	            }

	            double num1 = Double.parseDouble(input);

	            System.out.print("Enter the type of operation you want to perform (+, -, *, /, sqrt, ^, sin, cos, tan, log): ");
	            String operation = scanner.nextLine().trim().toLowerCase();

	            double num2 = 0;
	            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && 
	                !operation.equalsIgnoreCase("tan") && !operation.equalsIgnoreCase("log")) {
	                System.out.print("Enter second number: ");
	                String secondInput = scanner.nextLine();

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
	                                result = Double.POSITIVE_INFINITY;
	                            } else if (num1 < 0) {
	                                result = Double.NEGATIVE_INFINITY;
	                            } else {
	                                result = Double.NaN;
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
	                    case "log":
	                        if (num1 <= 0) {
	                            System.out.println("Logarithm of a non-positive number is undefined.");
	                            validOperation = false;
	                        } else {
	                            System.out.print("Do you want to specify a base for the logarithm? (y/n): ");
	                            String baseResponse = scanner.nextLine().trim().toLowerCase();
	                            if (baseResponse.equals("y")) {
	                                System.out.print("Enter the base: ");
	                                String baseInput = scanner.nextLine();
	                                if (!isValidDouble(baseInput)) {
	                                    System.out.println("Invalid input. Please enter a valid base.");
	                                    validOperation = false;
	                                } else {
	                                    double base = Double.parseDouble(baseInput);
	                                    if (base <= 0 || base == 1) {
	                                        System.out.println("Invalid base. Base must be greater than 0 and not equal to 1.");
	                                        validOperation = false;
	                                    } else {
	                                        result = Math.log(num1) / Math.log(base);
	                                    }
	                                }
	                            } else {
	                                result = Math.log(num1);
	                            }
	                        }
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

	    public static boolean isValidDouble(String str) {
	        try {
	            Double.parseDouble(str);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
	}


