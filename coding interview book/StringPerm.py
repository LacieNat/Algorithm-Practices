'''
Created on Oct 8, 2015
This assignment assumes that all char in string are unique
@author: lacie
'''
allPermutation = []

'''
if curr2 is not assigned to curr, the method will not work
string is an immutable object
if changed, a new string will be established
takes O(n!) time, since there are n! permutations
'''
def getAllPerm(str, curr):
    if len(str) == 0:
        allPermutation.append(curr)
        return
    for i in range(len(str)):
        char = str[i]
        str2 = str.replace(str[i], "")
        curr2 = curr
        curr2 += char
        getAllPerm(str2, curr2)
        
getAllPerm("abcde", "")
print(allPermutation)