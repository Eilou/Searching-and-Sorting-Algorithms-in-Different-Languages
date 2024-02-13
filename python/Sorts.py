# Python sorting algorithms
# Author: Louie Brooks
# Written on: starting 13/02/24

# imports
import math

# runs bubble sort and returns the sorted list
def bubble(data):
    
    for i in range(0, len(data) - 1):
        
        swapped = False

        for j in range(1, len(data) - i):

            if data[j] < data[j-1]:
                temp = data[j]
                data[j] = data[j-1]
                data[j-1] = temp
                swapped = True
        
        if not(bool(swapped)):
            break

    return data

# runs merge sort and returns the sorted list
def merge(data, start, end):
    if start == end:
        singleElement = data[start]
        return singleElement
    
    mid = math.floor((start + end)/2)

    leftArr = merge(data, start, mid)
    rightArr = merge(data, mid + 1, end)

    return merge2Lists(leftArr, rightArr)

# merge the two lists provided in to one ascendling ordered array 
def merge2Lists(arr1, arr2):
    pointer1 = 0
    pointer2 = 0
    pointerMerged = 0

    mergedArray = []

    print("test")

    while pointer1 < len(arr1) and pointer2 < len(arr2):
        
        if arr1[pointer1] > arr2[pointer2]:
            mergedArray[pointerMerged] = arr2[pointer2]
            pointer2 += 1
            pointerMerged += 1

        else:
            mergedArray[pointerMerged] = arr1[pointer1]
            pointer1 += 1
            pointerMerged += 1

    while pointer1 < len(arr1):
        mergedArray[pointerMerged] = arr1[pointer1]
        pointer1 += 1
        pointerMerged += 1

    while pointer2 < len(arr2):
        mergedArray[pointerMerged] = arr2[pointer2]
        pointer2 += 1
        pointerMerged += 1

    return mergedArray 

# runs insertion sort and returns the sorted list
def insertion(data):
    print()

# runs selection sort and returns the sorted list
def selection(data):
    print

# returns the elemetns of an array as a concanated string
def arrayToString(arr):
    message = ""

    for i in arr:
        message += str(i)

    return message
        
# runs the main code
def main():
    testData = [9,8,7,6,5,4,3,2,1]
    
    print("Bubble Sort: " + arrayToString(bubble(testData)))
    print("Merge Sort: " + arrayToString(merge(testData, 0, len(testData) - 1)))

main()