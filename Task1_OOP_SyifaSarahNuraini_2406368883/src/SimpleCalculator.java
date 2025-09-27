import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double sum, product, difference, quotient;
        boolean valid = true;

        sum = num1 + num2;
        System.out.println("sum = "+sum);

        difference = num1 - num2;
        System.out.println("difference = "+difference);

        product = num1 * num2;
        System.out.println("product = "+product);

        if (num2 != 0) {
            quotient = num1 / num2;
            System.out.println("quotient = "+quotient);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
            valid = false;
        }

        if (valid) {
            System.out.println("Calculation complete.");
        }
        scanner.close();
    }
}