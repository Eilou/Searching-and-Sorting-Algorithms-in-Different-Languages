package src;

/**
 * Java sorting algorithms
 *
 * @author Louie Brooks
 * Written on: starting 07/02/24
 */

public class Searches {

    /**
     * Performs linear search
     *
     * @param data The data to be searched through
     * @param searchItem The item to be searched for
     * @return If found, the index of the searchItem, if not, -1
     */
    public static int linear(int[] data, int searchItem) {

        for (int i = 0; i < data.length; i++) {
            if (data[i] == searchItem) {
                return i;
            }
        }

        // returns if searchItem not in the list
        return -1;
    }

    /**
     * Performs binary search on data provided
     *
     * @param data The data to be searched through
     * @param searchItem The item to be searched for
     * @return If found, returns the index of the item, if not, returns -1
     */
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

            else if (data[mid] > searchItem) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return -1;

    }

    /**
     * Test case for different search algorithms listed above
     *
     * @param args Input from the standard input (not required for this)
     */
    public static void main (String args[]) {

        int[] unSortedTestData = {0,9,1,8,2,7,3,6,4,5};
        int[] sortedTestData = {0,1,2,3,4,5,6,7,8,9};

        int testSearchItem = -2;
        int testSearchItem2 = 5;

        System.out.println("Linear search for items: -2, 5");
        System.out.println(Searches.linear(unSortedTestData, testSearchItem));
        System.out.println(Searches.linear(unSortedTestData, testSearchItem2));

        System.out.println("Binary search for items: -2, 5");
        System.out.println(Searches.binary(sortedTestData, testSearchItem));
        System.out.println(Searches.binary(sortedTestData, testSearchItem2));

    }

}
