import java.util.ArrayList;
import java.util.List;

public class KFinder {

    // Method to find the k-th largest element from an array
    public static int findK(int[] array, int k) {
        if (array.length == 1) return array[0];  // Base case: single element array

        int median = findMedian(array);  // Calculate median

        // Separate array into two parts: >= median and < median
        List<Integer> greaterOrEqual = new ArrayList<>();
        List<Integer> lessThan = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= median) {
                greaterOrEqual.add(array[i]);
            } else {
                lessThan.add(array[i]);
            }
        }

        // Convert lists to arrays using regular loops
        int[] topArray = new int[greaterOrEqual.size()];
        int[] bottomArray = new int[lessThan.size()];

        for (int i = 0; i < greaterOrEqual.size(); i++) {
            topArray[i] = greaterOrEqual.get(i);
        }

        for (int i = 0; i < lessThan.size(); i++) {
            bottomArray[i] = lessThan.get(i);
        }

        // Recursively search in the correct half
        if (k <= topArray.length) {
            // If k-th largest is in the top array
            return findK(topArray, k);
        } else {
            // If k-th largest is in the bottom array, adjust k
            return findK(bottomArray, k - topArray.length);
        }
    }

    // Find median using median of medians method
    private static int findMedian(int[] array) {
        if (array.length <= 5) return selectMedian(array);  

        int numGroups = (int) Math.ceil((double) array.length / 5);
        int[] medians = new int[numGroups];

        for (int i = 0; i < numGroups; i++) {
            int start = i * 5;
            int end = Math.min(start + 5, array.length);
            medians[i] = selectMedian(newArray(array, start, end));
        }
        // recursion to find median medians
        return findMedian(medians);  
    }

    private static int[] newArray(int[] array, int start, int end) {
        int[] subArr = new int[end - start];
        System.arraycopy(array, start, subArr, 0, end - start);
        return subArr;
    }

    // Select median for small arrays (size <= 5)
    private static int selectMedian(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallerCount = 0, equalCount = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] < array[i]) smallerCount++;
                else if (array[j] == array[i]) equalCount++;
            }
            if (smallerCount <= array.length / 2 && smallerCount + equalCount > array.length / 2) {
                return array[i];
            }
        }
        return array[0];  // Fallback to return first element
    }

    public static void main(String[] args) {
        //int[] array = {12, 3, 5, 7, 19, 26, 4, 8, 30};
        int[] array = {12, 45, 3, 67, 23, 88, 55, 14, 72, 39, 56, 27, 92, 33, 10, 76, 48, 82, 19, 66, 91, 38, 5, 29, 74, 58, 15, 84, 50, 8, 71, 40, 63, 21, 99, 1, 24, 36, 87, 30, 62, 13, 70, 80, 17, 46, 75, 60, 22, 4, 93, 44, 31, 18, 25, 97, 68, 9, 42, 65, 77, 28, 100, 2, 69, 59, 11, 81, 43, 53, 16, 57, 34, 35, 94, 78, 52, 86, 32, 37, 72, 47, 83, 49, 61, 88, 90, 95, 14, 96, 79, 54, 7, 26, 41};
        int k = 96;  
        //sort the array with sort method
        java.util.Arrays.sort(array);
        System.out.println("Sorted array: " + java.util.Arrays.toString(array));
        

        int result = findK(array, k);
        System.out.println("The " + k + "rd largest number is: " + result);
    }
}
