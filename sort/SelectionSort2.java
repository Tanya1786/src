import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        try {
            int[] values = {84, 69, 76, 86, 94, 91};
            selectionSort(values);
            System.out.println("Sorted array: " + Arrays.toString(values));
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Step " + (i + 1) + ":");
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                System.out.println("Comparing " + arr[minIndex] + " and " + arr[j]);
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                System.out.println("Swapped: " + Arrays.toString(arr));
            }
        }
    }
}
public class SelectionSort2 {

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }



    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        selectionSort(myArray);

        System.out.println( Arrays.toString(myArray) );

    }
}