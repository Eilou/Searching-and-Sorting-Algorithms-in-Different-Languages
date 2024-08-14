# performs linear search
def linear(data : list, searchItem : int):
    for i in range (len(data)):
        if data[i] == searchItem:
            return i
        
unsorted_test_data = [0,9,1,8,2,7,3,6,4,5]
print(f'Linear Search for item 2: {linear(unsorted_test_data, 2)}')