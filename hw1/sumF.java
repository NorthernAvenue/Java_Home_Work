// Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

package Java.hw1;

import java.util.Scanner;

public class sumF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int n = scanner.nextInt();
        scanner.close();

        int triangleNumber = 0;
        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            triangleNumber += i;
            factorial *= i;
        }

        System.out.println("n-ое треугольное число: " + triangleNumber);
        System.out.println("n! = " + factorial);
    }

}
