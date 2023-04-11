package Java.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MinMaxAverage {

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < 10; i++) {
      list.add(random.nextInt(100));
    }

    int min = Collections.min(list);
    int max = Collections.max(list);
    double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();

    System.out.println("List: " + list);
    System.out.println("Min: " + min);
    System.out.println("Max: " + max);
    System.out.println("Average: " + average);
  }
}

