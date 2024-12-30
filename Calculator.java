import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException {

        System.out.println("***WELCOME TO THE CMD CALCULATOR***");

        Scanner input = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputOne = 0;
        int inputTwo = 0;
        BigInteger count = new BigInteger("1");
        int nums;
        final double pi = Math.PI;
        double radius;

        String choice;
        String operator;
        String circleOfChoice;

        boolean keep = true;

        while (keep) {
            System.out.print("----------Enter the action to be performed----------");
            System.out.println("\n1. Enter two numbers");
            System.out.println("2. Perform an arithmetic operation");
            System.out.println("3. Factorial of a number");
            System.out.println("4. Perform Geometric Calculations on a Circle");
            System.out.println("5. Exit");
            System.out.print("Enter your option : ");
            choice = reader.readLine();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Enter first digit : ");
                        inputOne = input.nextInt();
                        System.out.print("Enter second digit : ");
                        inputTwo = input.nextInt();
                    }
                    case "2" -> {
                        if(inputOne == 0 || inputTwo == 0){
                            throw new ArithmeticException("Numerator or denominator cannot be zero");
                        }
                        System.out.println("+," + " -," + " *," + " /," + " %" );
                        System.out.print("Enter an operator from the given options : " );

                        operator = reader.readLine();
                        switch (operator) {
                            case "+" -> System.out.println("Sum = " + (inputOne + inputTwo));
                            case "-" -> System.out.println("Subtract = " + (inputOne - inputTwo));
                            case "*" -> System.out.println("Product = " + (inputOne * inputTwo));
                            case "/" -> System.out.println("Division = " + (inputOne / inputTwo));
                            case "%" -> System.out.println("Remainder = " + (inputOne % inputTwo));
                        }
                    }
                    case "3" -> {
                        System.out.print("Enter the number whose Factorial you want to calculate : ");
                        nums = input.nextInt();
                        for(int i = nums; i>0; i--){
                            count = count.multiply(BigInteger.valueOf(i));
                        }
                        System.out.println(count);
                        count = new BigInteger("1");
                    }
                    case "4" -> {
                        System.out.print("Enter the radius => ");
                        radius = input.nextDouble();

                        System.out.println("Select which formula of circle you want to apply : ");
                        System.out.println("1. Circumference of a circle");
                        System.out.println("2. Area of a circle");
                        System.out.println("3. Volume of a sphere");
                        System.out.println("4. Surface Area of a sphere");
                        System.out.print("Enter : ");

                        circleOfChoice = reader.readLine();

                        switch (circleOfChoice){
                            case "1" -> System.out.println("Circumference : " + 2.0 * pi * radius);
                            case "2" -> System.out.println("Area : " + pi * (radius * radius));
                            case "3" -> System.out.println("Volume : " + (4.0/3.0) * (pi) *(radius * radius * radius));
                            case "4" -> System.out.println("Surface Area : " + 4.0 * pi * (radius * radius));
                        }
                    }
                    case "5" -> keep = false;
                }
            } catch (ArithmeticException e){
                System.out.println(e.getMessage());
                System.out.println("Re-Enter the numbers");
            }
        }
    }
}
