package javaSrc;

/**
 * Java sorting algorithms
 *
 * @author Louie Brooks
 * Written on: starting 07/02/24
 */


public class Sorts {

    /**
     * Runs bubble sort on array of integers
     *
     * @param data Unsorted integer array
     * @return Ascending sorted array
     */
    public static int[] bubble(int[] data) {

        // inter-pass loops
        for (int i = 0; i < data.length - 1; i++) {

            boolean swapped = false;

            // intra-pass loops
            for (int j = 1; j < data.length - i; j++) {

                // swap if needed
                if (data[j] < data[j - 1]) {

                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }

        }

        return data;
    }

    /**
     * Runs merge sort on integer array
     *
     * @param data  Unsorted integer array
     * @param start First position of the array
     * @param end Last position of the array
     * @return Ascending sorted array
     */
    public static int[] merge(int[] data, int start, int end) {

        // recursively partition until each list is 1 element long
        if (start == end) {
            int[] singleElement = new int[1];
            singleElement[0] = data[start];
            return singleElement;
        }

        // split list into 2
        int mid = (int) Math.floor((start + end) / 2.0);
        int[] leftArr = merge(data, start, mid);
        int[] rightArr = merge(data, mid + 1, end);

        return merge2Lists(leftArr, rightArr);

    }

    /**
     * Merges two sorted lists into one sorted list
     *
     * @param arr1 Ascending sorted array
     * @param arr2 Ascending sorted array
     * @return Combined ascending sorted list with elements from both parameters
     */
    public static int[] merge2Lists(int[] arr1, int[] arr2) {

        int pointer1 = 0;
        int pointer2 = 0;
        int pointerMerged = 0;

        int[] mergedArray = new int[arr1.length + arr2.length];

        while (pointer1 < arr1.length && pointer2 < arr2.length) {

            if (arr1[pointer1] > arr2[pointer2]) {
                mergedArray[pointerMerged] = arr2[pointer2];
                pointer2++;
                pointerMerged++;
            } else {
                mergedArray[pointerMerged] = arr1[pointer1];
                pointer1++;
                pointerMerged++;
            }
        }

        while (pointer1 < arr1.length) {
            mergedArray[pointerMerged] = arr1[pointer1];
            pointer1++;
            pointerMerged++;
        }

        while (pointer2 < arr2.length) {
            mergedArray[pointerMerged] = arr2[pointer2];
            pointer2++;
            pointerMerged++;
        }

        return mergedArray;

    }

    /**
     * Runs insertion sort on integer array
     *
     * @param data Unsorted integer array
     * @return Ascending sorted array
     */
    public static int[] insertion(int[] data) {

        for (int j = 1; j < data.length; j++) {
            int key = data[j];
            int i = j - 1;
            while (i >= 0 && data[i] > key) {
                data[i + 1] = data[i];
                i = i - 1;
            }
            data[i + 1] = key;
        }

        return data;
    }

    /**
     * Runs selection sort on integer array
     *
     * @param data Unsorted integer array
     * @return Ascending sorted array
     */
    public static int[] selection(int[] data) {

        for (int lastUnsorted = data.length - 1; lastUnsorted > 0; lastUnsorted--) {

            int positionOfLargest = lastUnsorted;

            for (int i = 0; i < lastUnsorted; i++) {

                if (data[i] > data[positionOfLargest]) {
                    positionOfLargest = i;
                }

            }

            if (positionOfLargest != lastUnsorted) {
                int temp = data[positionOfLargest];
                data[positionOfLargest] = data[lastUnsorted];
                data[lastUnsorted] = temp;
            }

        }

        return data;
    }

    /**
     * Outputs the elements of an array as a string
     *
     * @param arr An array
     * @return Elements of array as a string
     */
    public static String arrayToString(int[] arr) {

        String message = "";

        for (int i : arr) {
            message += i;
        }

        return message;
    }

    /**
     * Test case for different sorting algorithms
     *
     * @param args Arguments to be passed by the input stream
     */
    public static void main(String[] args) {

        int[] testData = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.print("Bubble Sort: ");
        System.out.println(Sorts.arrayToString(Sorts.bubble(testData)));
        System.out.print("Merge Sort: ");
        System.out.println(Sorts.arrayToString(Sorts.merge(testData, 0, testData.length - 1)));
        System.out.print("Insertion Sort: ");
        System.out.println(Sorts.arrayToString(Sorts.insertion(testData)));
        System.out.print("Selection Sort: ");
        System.out.println(Sorts.arrayToString(Sorts.selection(testData)));

    }
}
