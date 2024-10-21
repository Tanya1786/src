package EfficiencyOfAlgorithms;

public class BinarySearch {
    //Binary search algorithm
    public static void binarySearch(int[] array, int value, int low, int high) {
        int result = binarySearchRecursive(array, value, low, high); 
        if (result != -1) {
            System.out.println(value + " found at index " + result);
        } else {
            System.out.println(value + " not found");
        }
    }
    //Recursive method for binary search
    private static int binarySearchRecursive(int[] array, int value, int low, int high) {
        if (low > high) {
            return -1; 
        }
        int mid = (low + high) / 2;
        if (array[mid] == value) {
            return mid; 
        } else if (array[mid] > value) {
            return binarySearchRecursive(array, value, low, mid - 1); 
        } else {
            return binarySearchRecursive(array, value, mid + 1, high); 
        }
    }

    //test 
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10, 9, 14, 15, 18, 23};
        int value = 14;
        binarySearch(array, value, 0, array.length - 1);  
        value = 7;
        binarySearch(array, value, 0, array.length - 1);  
    }
}
