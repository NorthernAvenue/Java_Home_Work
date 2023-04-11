package Java.hw2;

import java.util.Scanner;
import java.util.logging.*;

public class Log {
    private static final Logger LOGGER = Logger.getLogger(Log.class.getName());

    public static void main(String[] args) {
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("calculator.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);

            Scanner scanner = new Scanner(System.in);

            LOGGER.info("Калькулятор запущен");

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
                        LOGGER.severe("Ошибка: попытка деления на ноль");
                        System.out.println("Деление на ноль невозможно!");
                        return; // завершаем выполнение программы
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Операция не распознана!");
                    LOGGER.warning("Неизвестная операция: " + operator);
                    return;
            }

            LOGGER.info("Операция: " + num1 + " " + operator + " " + num2 + " = " + result);
            System.out.println("Результат: " + result);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Ошибка при запуске калькулятора", e);
        } finally {
            if (fileHandler != null) {
                fileHandler.close();
            }
        }
    }
}

