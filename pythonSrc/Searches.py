# performs linear search
def linear(data : list, searchItem : int) -> int:
    for i in range (len(data)):
        if data[i] == searchItem:
            return i
    return -1

# performs binary search
def binary(data : list, searchItem : int) -> int:
    # note data here must be a sorted list
    start = 0
    end = len(data) - 1
    found = False
    while found == False and start <= end:
        mid = round(start + end / 2)
        if data[mid] == searchItem:
            found = True
        elif data[mid] > searchItem:
            end = mid - 1
        else:
            start = mid + 1
            
    if found:
        return mid
    else: 
        return -1
    
unsorted_test_data = [0,9,1,8,2,7,3,6,4,5]
print(f'Linear Search for item 2: {linear(unsorted_test_data, 2)}')

sorted_test_data = [0,1,2,3,4,5,6,7,8,9]
print(f'Binary Search for item 2: {binary(sorted_test_data, 2)}')