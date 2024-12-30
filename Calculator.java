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
        String choice;
        String operator;
        boolean keep = true;

        while (keep) {
            System.out.print("----------Enter the action to be performed----------");
            System.out.println("\n1. Enter two numbers");
            System.out.println("2. Perform an arithmetic operation");
            System.out.println("3. Factorial of a number");
            System.out.println("4. Exit");
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
                    case "4" -> keep = false;
                }
            } catch (ArithmeticException e){
                System.out.println(e.getMessage());
                System.out.println("Re-Enter the numbers");
            }

        }
    }
}
