import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean isRunning = true;
        double rollingSum = 0.0;

        Scanner userInput = new Scanner(System.in);
        System.out.println("This is a simple calculator");

        System.out.print("Enter the first number: ");
        rollingSum = getValidNumber(userInput);

        while (isRunning) {
            System.out.print("Current total: " + rollingSum);
            System.out.println();
            System.out.print("Please enter an operator (+, -, *, /) or N to stop: ");
            String operator = userInput.next();
            while (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/") && !operator.equalsIgnoreCase("N")) {
                System.out.println("Invalid operator!");
                System.out.print("Please enter an operator (+, -, *, /) or N to stop: ");
                operator = userInput.next();
            }
            if (operator.equalsIgnoreCase("N")) {
                isRunning = false;
                continue;
            }
            System.out.print("Enter a number: ");
            double number = getValidNumber(userInput);
            double previousValue = rollingSum;
            switch (operator) {
                case "+" -> rollingSum += number;
                case "-" -> rollingSum -= number;
                case "*" -> rollingSum *= number;
                case "/" -> {
                    if (number != 0) {
                        rollingSum /= number;
                    } else {
                        System.out.println("Cannot divide by zero!");
                    }
                }
            }
            System.out.println(previousValue + " " + operator + " " + number + " = " + rollingSum);
        }
        System.out.println("Final total: " + rollingSum);
    }

    public static double getValidNumber(Scanner input) {
        while(true) {
            if (input.hasNextDouble()) {
                return input.nextDouble();
            } else {
                System.out.println("Invalid number! Please enter a valid number: ");
                input.next();
            }
        }
    }
}