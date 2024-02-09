public class Sorts {

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

    public static int[] merge (int[] data){

        return data;
    }

    public static int[] insertion (int[] data){

        return data;
    }

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

    public static String printArrContents(int[] arr) {

        String message = "";

        for (int i = 0; i < arr.length; i++) {
            message += arr[i];
        }

        return message;
    }

    public static void main (String[] args) {

        int[] testData = {9,8,7,6,5,4,3,2,1};

        System.out.println(Sorts.printArrContents(Sorts.bubble(testData)));
//        System.out.println(Sorts.merge(testData));
//        System.out.println(Sorts.insertion(testData));
//        System.out.println(Sorts.printArrContents(Sorts.selection(testData)));

    }
}
