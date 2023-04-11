package Java.hw2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class BubbleSort {
    public int[] sort(int[] arr) {

        try {
            FileWriter writer = new FileWriter("bubble_sort_log.txt");

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }

                String result = "После " + (i+1) + " итерации(й): " + Arrays.toString(arr);
                System.out.println(result);
                writer.write(result);
                writer.write(System.lineSeparator());
            }

            writer.close();
        } catch(IOException ex) {
            System.out.println("Ошибка при записи в файл.");
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        scanner.close();

        if(size < 0) {
            System.out.println("Некорректный размер массива.");
            return;
        }

        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (int) Math.round(Math.random() * 100);
        }

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));

        BubbleSort sorter = new BubbleSort();
        int[] sortedArr = sorter.sort(arr);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(sortedArr));
    }
}