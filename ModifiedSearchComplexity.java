import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchComplexity {

    // Linear Search Method modified
    public static int linearSearch(int[] array, int target) {
        int iterations = 0; // Counter for iterations
        for (int i = 0; i < array.length; i++) {
            iterations++; // Increment iterations for each comparison
            if (array[i] == target) {
                System.out.println("Linear search iterations: " + iterations);
                return i;  // Returns index of found element
            }
        }
        // If the loop completes without finding the target
        System.out.println("Linear search iterations: " + iterations);
        return -1;  // Target not found
    }


    // Recursive Binary Search Method
    public static int recursiveBinarySearch(int[] array, int target) {
        return recursiveBinarySearch(array, target, 0, array.length - 1);
    }

    private static int recursiveBinarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid;
        }

        if (target < array[mid]) {
            return recursiveBinarySearch(array, target, left, mid - 1);
        } else {
            return recursiveBinarySearch(array, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter number of elements in array:");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Number of elements must be positive.");
                return;
            }

            int[] array = new int[n];

            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            System.out.println("Enter target number to search:");
            int target = scanner.nextInt();

            // Linear Search
            long startTimeLinear = System.currentTimeMillis();
            int linearResult = linearSearch(array, target);
            long endTimeLinear = System.currentTimeMillis();
            long executionTimeLinear = endTimeLinear - startTimeLinear;
            System.out.println((linearResult == -1) ? "Target not found by linear search." :
                    "Target found by linear search at index: " + linearResult);
            System.out.println("Linear search execution time: " + executionTimeLinear + " milliseconds");

            // Binary Search (Array must be sorted)
            Arrays.sort(array);
            long startTimeBinary = System.currentTimeMillis();
            int binaryResult = binarySearch(array, target);
            long endTimeBinary = System.currentTimeMillis();
            long executionTimeBinary = endTimeBinary - startTimeBinary;
            System.out.println((binaryResult == -1) ? "Target not found by binary search." :
                    "Target found by binary search at index: " + binaryResult);
            System.out.println("Binary search execution time: " + executionTimeBinary + " milliseconds");

            // Recursive Binary Search (Array must be sorted)
            long startTimeRecursive = System.currentTimeMillis();
            int recursiveBinaryResult = recursiveBinarySearch(array, target);
            long endTimeRecursive = System.currentTimeMillis();
            long executionTimeRecursive = endTimeRecursive - startTimeRecursive;
            System.out.println((recursiveBinaryResult == -1) ? "Target not found by recursive binary search." :
                    "Target found by recursive binary search at index: " + recursiveBinaryResult);
            System.out.println("Recursive binary search execution time: " + executionTimeRecursive + " milliseconds");

        } catch (InputMismatchException e) {
            System.out.println("Input error: Please enter integers only.");
        } finally {
            scanner.close();
        }
    }
}
