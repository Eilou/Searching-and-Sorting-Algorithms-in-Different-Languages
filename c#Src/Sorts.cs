using System.Runtime.Versioning;

namespace cSharpSrc;

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
                if (data[j] > data[j+1])
                {
                    // used var here as could say it is ambiguous?, I'm still undecided on when best to use
                    var temp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = temp;
                    swapped = true;
                    
                }
            }

            if (!swapped)
                break;
        }
        return data;
    }

}