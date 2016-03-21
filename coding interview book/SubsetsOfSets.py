'''
Created on Oct 8, 2015

A Recursive Assignment

Things to note while using recursion:
Recursive algorithms can be very space inefficient. Each recursive call adds a new layer to the stack,
which means that if your algorithm has O(n) recursive calls then it uses O(n) memory

@author: lacie
'''

def getAllSubsets(s):
    listOfSet = tuple(s)
    getAllSubsetsHelper(listOfSet, set())
  
ss = []  

def getAllSubsetsHelper(list, s):
    #print(s)
    #print(list)
        
    if len(list)==0:
        ss.append(s)
        return
    
    s1 = set(s)
    s2 = set(s)
    
    s1.add((list[0]))
    getAllSubsetsHelper(list[1:], s2) 
    getAllSubsetsHelper(list[1:], s1)
    
getAllSubsets(set([1,2,3,4]))
print(ss)

