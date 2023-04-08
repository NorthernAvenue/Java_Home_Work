// Реализовать простой калькулятор

package Java.hw1;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();

        System.out.print("Введите операцию (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        scanner.close();

        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Деление на ноль невозможно!");
                    return; // завершаем выполнение программы
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана!");
                return;
        }
        System.out.println("Результат: " + result);
    }
}

