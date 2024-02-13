/**
 * Java sorting algorithms
 *
 * @author Louie Brooks
 * Written on: starting 07/02/24
 */

public class Searches {

    public static int linear(int[] data, int searchItem) {

        for (int i = 0; i < data.length; i++) {
            if (data[i] == searchItem) {
                return i;
            }
        }

        // returns if searchItem not in the list
        return -1;
    }

    public static int binary(int[] data, int searchItem) {

        boolean found = false;

        int start = 0;
        int end = data.length - 1;
        while (!found && start <= end) {
            int mid = (start + end) / 2;

            // searchItem found
            if (data[mid] == searchItem) {
                return mid;
            }

            else if (data[mid] < searchItem) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return -1;

    }

    public static void main (String args[]) {



        int[] unSortedTestData = {0,9,1,8,2,7,3,6,4,5};
        int[] sortedTestData = {0,1,2,3,4,5,6,7,8,9};

        int testSearchItem = -2;

        System.out.println(Searches.linear(unSortedTestData, testSearchItem));
        System.out.println(Searches.binary(sortedTestData, testSearchItem));

    }

}
