package Java.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Odd {

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();
            scanner.close();

            Random random = new Random();

            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int number = random.nextInt(91) + 10; 
                numbers.add(number);
            }

            System.out.println("Исходный массив: " + numbers);

            List<Integer> oddNumbers = new ArrayList<>();
            for (int number : numbers) {
                if (number % 2 != 0) {
                    oddNumbers.add(number);
                }
            }

            System.out.println("Массив без четных чисел: " + oddNumbers);
        }
    }
}
