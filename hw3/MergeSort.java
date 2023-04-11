package Java.hw3;
import java.util.Arrays;
public class MergeSort {

    public static void main(String[] args) {
      int[] arr = {52, 21, 93, 31, 72, 65, 12, 84, 49};
      mergeSort(arr);
      System.out.println(Arrays.toString(arr));
    }
  
    public static void mergeSort(int[] arr) {
      if (arr.length < 2) {
        return;
      }
      int mid = arr.length / 2;
      int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
      int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
      mergeSort(leftArr);
      mergeSort(rightArr);
      merge(leftArr, rightArr, arr);
    }
  
    public static void merge(int[] leftArr, int[] rightArr, int[] arr) {
      int leftIndex = 0;
      int rightIndex = 0;
      int arrIndex = 0;
      while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
        if (leftArr[leftIndex] <= rightArr[rightIndex]) {
          arr[arrIndex] = leftArr[leftIndex];
          leftIndex++;
        } else {
          arr[arrIndex] = rightArr[rightIndex];
          rightIndex++;
        }
        arrIndex++;
      }
      while (leftIndex < leftArr.length) {
        arr[arrIndex] = leftArr[leftIndex];
        leftIndex++;
        arrIndex++;
      }
      while (rightIndex < rightArr.length) {
        arr[arrIndex] = rightArr[rightIndex];
        rightIndex++;
        arrIndex++;
      }
    }
  }
  
    
