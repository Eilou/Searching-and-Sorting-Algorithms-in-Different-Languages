# Python sorting algorithms
# Author: Louie Brooks
# Written on: starting 13/02/24

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
def merge(data):
    print()

def merge2Lists(data):
    print()

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
    print(arrayToString(bubble(testData)))

main()