# Python sorting algorithms
# Author: Louie Brooks
# Written on: starting 13/02/24

# imports
import math

# runs bubble sort and returns the sorted list
def bubble(data : list) -> list:
    
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
def merge(data : list, start : int, end : int) -> list:

    if start == end:
    
        singleElement = [0]
        singleElement[0] = data[start]
    
        return singleElement
    
    mid = math.floor((start + end)/2)

    leftArr = merge(data, start, mid)
    rightArr = merge(data, mid + 1, end)

    return merge2Lists(leftArr, rightArr)

# merge the two lists provided in to one ascendling ordered array 
def merge2Lists(arr1 : list, arr2 : list) -> list:
    pointer1 = 0
    pointer2 = 0
    pointerMerged = 0

    mergedArray = [0]*(len(arr1) + len(arr2))

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
def insertion(data : list) -> list:
    for i in range (1, len(data)):
        key = data[i]
        j = i - 1
        while j >= 0 and data[j] > key:
            data[j + 1] = data[j]
            j = j - 1
        data[j+1] = key
    return data

# runs selection sort and returns the sorted list
#
# it segments the right half of the list as the sorted list then gradually swaps the largest elements
# into the smallest positions of the sorted list such that it front fills and sorts the data
def selection(data):
    for last_unsorted in range (len(data)-1, 0, -1):
        largest_index = last_unsorted
        
        # find the largest item in the unsorted list
        for i in range (last_unsorted):
            if data[i] > data[largest_index]:
                largest_index = i
        
        # swap the largest unsorted with the first element in the sorted section
        if largest_index != last_unsorted:
            temp = data[largest_index]
            data[largest_index] = data[last_unsorted]
            data[last_unsorted] = temp
                
    return data
                

# returns the elemetns of an array as a concanated string
def array_to_string(arr):
    message = ""

    for i in arr:
        message += str(i)

    return message
        
# runs the main code
testData = [9,8,7,6,5,4,3,2,1]
print("Bubble Sort: " + array_to_string(bubble(testData)))

# have to redefine the array as the methods currently sort it and treat lists as objects in python
testData = [9,8,7,6,5,4,3,2,1]
print("Merge Sort: " + array_to_string(merge(testData, 0, len(testData) - 1)))

testData = [9,8,7,6,5,4,3,2,1]
print(f"Insertion Sort: {array_to_string(insertion(testData))}")

testData = [9,8,7,6,5,4,3,2,1]
print(f"Selection Sort: {array_to_string(selection(testData))}")