package com.solt.jdc;


	import java.util.Scanner;
	import java.lang.Math;

	public class AdvancedCalculator {
	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("\n!!!Welcome to the Advanced Calculator!!!");
	        
	        while (true) {
	            System.out.print("\nEnter first number (or 'exit' to quit): ");
	            String input = scanner.nextLine();
	            if (input.equalsIgnoreCase("exit")) {
	                break;
	            }
	            
	            double num1;
	            try {
	                num1 = Double.parseDouble(input);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid number. Please try again.");
	                continue;
	            }
	            
	            System.out.print("Enter the type of operation you want to perform (+, -, *, /, sqrt, ^, sin, cos, tan): ");
	            String operator = scanner.nextLine();
	            
	            double num2 = 0;
	            if (!operator.equals("sqrt") && !operator.equals("sin") && !operator.equals("cos") && !operator.equals("tan")) {
	                System.out.print("Enter second number: ");
	                input = scanner.nextLine();
	                try {
	                    num2 = Double.parseDouble(input);
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid number. Please try again.");
	                    continue;
	                }
	            }
	            
	            double result = calculate(num1, num2, operator);
	            
	            if (Double.isNaN(result)) {
	                System.out.println("Error: Invalid operator or division by zero.");
	            } else {
	                System.out.println("Result: " + result);
	            }
	        }
	        
	        System.out.println("Goodbye!");
	        scanner.close();
	    }
	    
	    public static double calculate(double a, double b, String operator) {
	        double result;
	        switch (operator) {
	            case "+":
	                result = a + b;
	                break;
	            case "-":
	                result = a - b;
	                break;
	            case "*":
	                result = a * b;
	                break;
	            case "/":
	                if (b == 0) {
	                    result = Double.NaN; // Indicates division by zero error
	                    break;
	                }
	                result = a / b;
	                break;
	            case "sqrt":
	                if (a < 0) {
	                    result = Double.NaN; // Indicates invalid square root
	                    break;
	                }
	                result = Math.sqrt(a);
	                break;
	            case "^":
	                result = Math.pow(a, b);
	                break;
	            case "sin":
	                result = Math.sin(Math.toRadians(a));
	                break;
	            case "cos":
	                result = Math.cos(Math.toRadians(a));
	                break;
	            case "tan":
	                result = Math.tan(Math.toRadians(a));
	                break;
	            default:
	                result = Double.NaN; // Indicates invalid operator
	        }
	        return result;
	    }

	}



