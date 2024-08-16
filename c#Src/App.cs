// no need to put in a namespace then class because it is a top level file
// hence no need to specify in the .csproj file where the entry point is
using cSharpSrc; // treated like importing a package in java
using System;

// think of like a def function in python, c# does also have lambda ones
string ArrayToString<T>(T[] toPrint)
{
    string message = "";
    foreach (T item in toPrint)
    {
        message = string.Concat(message, $"{item}, ");
    }
    // message.Length is a property 
    return message.Substring(0, message.Length  - 2);
}

int[] unSortedTestData = { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
int[] sortedTestData = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

int testSearchItem = -2;
int testSearchItem2 = 5;

Console.WriteLine($"Linear search for item {testSearchItem}: {Searches.Linear(unSortedTestData, testSearchItem)}");
Console.WriteLine($"Linear search for item {testSearchItem2}: {Searches.Linear(unSortedTestData, testSearchItem2)}");

Console.WriteLine();

Console.WriteLine($"Binary search for item {testSearchItem}: {Searches.Binary(sortedTestData, testSearchItem)}");
Console.WriteLine($"Binary search for item {testSearchItem2}: {Searches.Binary(sortedTestData, testSearchItem2)}");

Console.WriteLine();

Console.WriteLine($"Bubble sort result: {ArrayToString(Sorts.Bubble(unSortedTestData))}");

unSortedTestData = new int[] { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 }; // could use [ ... ] but its only available in C#12 so trying to avoid
Console.WriteLine($"Merge sort result: {ArrayToString(Sorts.Merge(unSortedTestData, 0, unSortedTestData.Length - 1))}");

unSortedTestData = new int[] { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
Console.WriteLine($"Insertion sort result: {ArrayToString(Sorts.Insertion(unSortedTestData))}");

unSortedTestData = new int[] { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
Console.WriteLine($"Selection sort result: {ArrayToString(Sorts.Selection(unSortedTestData))}");