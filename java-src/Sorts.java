/**
 * Java sorting algorithms
 * @author Louie Brooks
 * Written on: starting 07/02/24
 */

public class Sorts {

    /**
     * Runs bubble sort on array of integers
     * @param data
     * @return Ascending sorted array
     */
    public static int[] bubble (int[] data){

        // inter-pass loops
        for (int i = 0; i < data.length - 1; i++) {

            boolean swapped = false;

            // intra-pass loops
            for (int j = 1; j <= data.length - 1 - i; j++) {

                // swap if needed
                if (data[j] < data[j-1]) {

                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
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
     * @param data
     * @return Ascending sorted array
     */
    public static int[] merge (int[] data){


        if (data.length > 1) {
            // partition left
            System.out.println(printArrContents(data));
            int[] leftArray = new int[(int) Math.floor(data.length / 2.0)];
            System.arraycopy(data, 0, leftArray, 0, leftArray.length);
            merge(leftArray);
            // partition right
            int[] rightArray = new int[(int) Math.ceil(data.length / 2.0)];
            System.arraycopy(data, (int) Math.ceil(data.length / 2.0), rightArray, 0, rightArray.length-1);
            merge(leftArray);
        }




        return data;
    }

    /**
     * Runs insertion sort on integer array
     * @param data
     * @return Ascending sorted array
     */
    public static int[] insertion (int[] data){

        for (int j = 1; j < data.length; j++) {
            int key = data[j];
            int i = j - 1;
            while (i >= 0 && data[i] > key) {
                data[i+1] = data[i];
                i = i - 1;
            }
            data[i+1] = key;
        }

        return data;
    }

    /**
     * Runs selection sort on integer array
     * @param data
     * @return Ascending sorted array
     */
    public static int[] selection (int[] data){

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
     * @param arr
     * @return Elements of array as a string
     */
    public static String printArrContents(int[] arr) {

        String message = "";

        for (int i = 0; i < arr.length; i++) {
            message += arr[i];
        }

        return message;
    }

    /**
     * Test case for differnet sorting algorithms
     * @param args
     */
    public static void main (String[] args) {

        int[] testData = {9,8,7,6,5,4,3,2,1};

        System.out.print("Bubble Sort: ");
        System.out.println(Sorts.printArrContents(Sorts.bubble(testData)));
        System.out.print("Merge Sort: ");
        System.out.println(Sorts.merge(testData));
        System.out.print("Insertion Sort: ");
        System.out.println(Sorts.printArrContents(Sorts.insertion(testData)));
        System.out.print("Selection Sort: ");
        System.out.println(Sorts.printArrContents(Sorts.selection(testData)));

    }
}
