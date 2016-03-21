'''
Created on Oct 8, 2015

@author: lacie
'''
import math
#Python is passed by object-reference
#finding number of paths for the robot over a x times y grid ( question states n*n which just makes total num of paths 2**n )
def findNumOfPaths(x, y):
    return math.factorial(x+y-2) / (math.factorial(x-1) * math.factorial(y-1)) 


def findAllPathsHelper(unavailablePaths, currSquare, x, y, list):
    if currSquare[0] == x and currSquare[1] == y:
        return list
    
    if currSquare[0] == x:
        return findAllPathsHelper(unavailablePaths, (currSquare[0], currSquare[1]+1), x, y, list + [(currSquare[0], currSquare[1]+1)])
    
    if currSquare[1] == y:
        return findAllPathsHelper(unavailablePaths, (currSquare[0] + 1, currSquare[1]), x, y, list + [(currSquare[0]+1, currSquare[1])])
    
    if currSquare in unavailablePaths:
        return list[0:-1]
    
    return (findAllPathsHelper(unavailablePaths, (currSquare[0] + 1, currSquare[1]), x, y, list + [(currSquare[0]+1, currSquare[1])]) + 
            findAllPathsHelper(unavailablePaths, (currSquare[0], currSquare[1]+1), x, y, list + [(currSquare[0], currSquare[1]+1)]))
    
    
def findAllPaths(unavailablePaths, x, y):
    list = findAllPathsHelper(unavailablePaths, (1,1), x, y, [])
    totalNumOfSteps = (x-1) + (y-1)
    allPaths = []
    
    #xrange is lazy evaluation
    #values are stored and created only when asked
    for i in range(len(list)/totalNumOfSteps):
        list2 = []
        for j in range(totalNumOfSteps):
            list2.append(list[i*totalNumOfSteps + j])
        
        allPaths.append(list2)
    
    return allPaths

print(findAllPaths([(1,2)], 2, 3))