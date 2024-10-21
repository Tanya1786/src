public class Sorting {
  public class SortingAlgorithms {

    // Insertion Sort without using key
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            // Directly insert arr[i] in its correct position
            while (j >= 0 && arr[j] > arr[i]) {
                arr[j + 1] = arr[j]; // Move elements
                j--;
            }
            arr[j + 1] = arr[i]; // Place arr[i] in its correct position
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Recursive Insertion Sort without using key
    public static void recursiveInsertionSort(int[] arr, int n) {
        // Base case
        if (n <= 1) {
            return;
        }

        // Sort the first n-1 elements
        recursiveInsertionSort(arr, n - 1);

        // Insert the last element at its correct position
        int last = arr[n - 1]; // Store the last element temporarily
        int j = n - 2;

        // Move elements greater than last to one position ahead
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j]; // Move elements
            j--;
        }
        arr[j + 1] = last; // Place the last element in its correct position
    }

    // Shell Sort
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i]; // Temporarily store the element
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap]; // Move elements
                }
                arr[j] = temp; // Place the temporarily stored element in its correct position
            }
        }
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] array1 = {64, 25, 12, 22, 11};
        int[] array2 = array1.clone();
        int[] array3 = array1.clone();
        int[] array4 = array1.clone();
        int[] array5 = array1.clone();

        System.out.println("Original Array:");
        printArray(array1);

        insertionSort(array1);
        System.out.println("Insertion Sort:");
        printArray(array1);

        selectionSort(array2);
        System.out.println("Selection Sort:");
        printArray(array2);

        bubbleSort(array3);
        System.out.println("Bubble Sort:");
        printArray(array3);

        recursiveInsertionSort(array4, array4.length);
        System.out.println("Recursive Insertion Sort:");
        printArray(array4);

        shellSort(array5);
        System.out.println("Shell Sort:");
        printArray(array5);
    }
}

}
