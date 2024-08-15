// written by Louie Brooks on 15.08.24

namespace cSharpSrc;

public class Searches {

    // runs linear search on the data
    public static int Linear(int[] data, int searchItem)
    {
        for (int i = 0; i < data.Length; i++)
        {
            if (data[i] == searchItem)
                return i;
        }
        return -1;
    }

    // runs binary search on the data
    public static int Binary(int[] data, int searchItem)
    {
        int start = 0;
        int end = data.Length - 1;
        while (start <= end)
        {
            // for exact values like when dealing with money, use Decimal, else use float/double as they can express
            // very large or preceise values that decimal cannot
            int mid = (int) Math.Round((double) (start + end)/2);
            if (data[mid] == searchItem)
                return mid;
            else if (data[mid] > searchItem)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        return -1;
    }

}