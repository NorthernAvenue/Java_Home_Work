package Java.hw4;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = 0;
        double num2 = 0;
        String operator = "+";
        boolean cancelOperation = false;

        while (true) {
            if (cancelOperation) {
                System.out.println("Введите новую операцию (+, -, *, /): ");
                operator = scanner.next();
            } else {
                System.out.println("Введите первое число: ");
                num1 = scanner.nextDouble();
                System.out.println("Введите второе число: ");
                num2 = scanner.nextDouble();
                System.out.println("Введите операцию (+, -, *, /): ");
                operator = scanner.next();
            }

            double result = 0;
            switch (operator) {
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
                        System.out.println("Деление на ноль невозможно!");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Операция не распознана!");
                    continue;
            }

            System.out.println("Результат: " + result);
            System.out.println("Хотите отменить последнюю операцию? (y/n): ");
            String cancel = scanner.next();

            if (cancel.equalsIgnoreCase("y")) {
                cancelOperation = true;
            } else {
                cancelOperation = false;
                System.out.println("Программа завершена");
                break;
            }
            scanner.close();
        }
    }
}
