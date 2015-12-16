'''
Created on Oct 9, 2015

@author: lacie
'''
arr = [ [0, 1, 1], [1,0,0], [1,0,0]   ]
point = [1,1]
newC = 2
oldC = arr[point[0]][ point[1]]
print(arr)
def fill(arr, point, newC, oldC):
    xHeight = len(arr)
    xWidth = len(arr[0])
    if point[0] < 0 or point[0] >= xHeight or point[1] <0 or point[1] >=xWidth:
        return
    
    if arr[point[0]][point[1]] == oldC:
        arr[point[0]][point[1]] = newC
        fill(arr, [point[0]+1, point[1]], newC, oldC)
        fill(arr, [point[0]-1, point[1]], newC, oldC)
        fill(arr, [point[0], point[1]+1], newC, oldC)
        fill(arr, [point[0], point[1]-1], newC, oldC)
        
    else:
        return
    
fill(arr, point, newC, oldC)

print(arr)