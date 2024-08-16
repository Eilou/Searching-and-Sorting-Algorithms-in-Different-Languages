using System.Globalization;
using System.Net;
using System.Runtime.Versioning;

namespace cSharpSrc;

// runs the different sorting algorithms
public class Sorts
{

    // runs an optimised bubble sort
    public static int[] Bubble(int[] data)
    {
        for (int i = 0; i < data.Length - 1; i++)
        {
            bool swapped = false;

            // optimises it, as on every pass n - 1 - i elements will be sorted
            for (int j = 1; j < data.Length - i - 1; j++)
            {
                if (data[j] > data[j + 1])
                {
                    // used var here as could say it is ambiguous?, I'm still undecided on when best to use
                    var temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                    swapped = true;

                }
            }

            if (!swapped)
                break;
        }
        return data;
    }

    // runs merge sort
    public static int[] Merge(int[] data, int start, int end) // I want to use optional parameters for this, but end relies on data.Length so can't
    {
        // recursively divide in 2 until each list is 1 element long
        if (start == end)
        {
            int[] singleElement = { data[start] };
            return singleElement;
        }

        // split list into 2
        int mid = (start + end) / 2;
        int[] leftArr = Merge(data, start, mid);
        int[] rightArr = Merge(data, mid + 1, end);

        return merge2Lists(leftArr, rightArr);

    }

    // function required for merge sort, takes two arrays and merges them together in order
    // requires each array be sorted first
    public static int[] merge2Lists(int[] arr1, int[] arr2)
    {
        int p1, p2, pMerge;
        p1 = p2 = pMerge = 0;

        int[] arrMerge = new int[arr1.Length + arr2.Length];

        while (p1 < arr1.Length && p2 < arr2.Length)
        {
            if (arr1[p1] < arr2[p2])
            {
                arrMerge[pMerge] = arr1[p1];
                p1++;
                pMerge++;
            }
            else
            {
                arrMerge[pMerge] = arr2[p2];
                p2++;
                pMerge++;
            }
        }

        while (p1 < arr1.Length)
        {
            arrMerge[pMerge] = arr1[p1];
            p1++;
            pMerge++;
        }

        while (p2 < arr2.Length)
        {
            arrMerge[pMerge] = arr2[p2];
            p2++;
            pMerge++;
        }

        return arrMerge;

    }

    // Run insertion sort
    public static int[] Insertion(int[] data)
    {
        for (int i = 1; i < data.Length; i++)
        {
            int key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] > key)
            {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }

        return data;
    }

    // Selection sort
    public static int[] Selection(int[] data)
    {

        // work down from top to bottom to use i as the marker as where to swap the largest to
        for (int i = data.Length - 1; i > 1; i--)
        {
            int positionOfLargest = i;

            // find the largest in sub array data[0..i-1]
            for (int j = i - 1; j > 0; j--)
                if (data[j] > data[positionOfLargest])
                    positionOfLargest = j;

            // use a tuple to swap the values
            (data[positionOfLargest], data[i]) = (data[i], data[positionOfLargest]);
        
        }

        return data;
    }

}