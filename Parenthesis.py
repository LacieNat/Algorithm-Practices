'''
Created on Oct 9, 2015

@author: lacie
'''
from collections import deque

queue = deque([])
list = []
def generateParenthesis(numOfPairs, numOfOpen, numOfClose, queue):
    if numOfOpen == numOfClose  and numOfOpen == numOfPairs:
        st = ""

        while len(queue) is not 0:
            st += queue.popleft()
        list.append(st)
        return
    
    if numOfOpen == numOfClose:
        queue.append("(")
        numOfOpen +=1
    
    if numOfOpen is not numOfPairs:
        queue2 = deque(queue)
        queue3 = deque(queue)
        queue3.append(")")
        queue2.append("(")
        generateParenthesis(numOfPairs, numOfOpen+1, numOfClose, queue2)
        generateParenthesis(numOfPairs, numOfOpen, numOfClose+1, queue3)
    
    else:
        queue2 = queue
        queue2.append(")")
        generateParenthesis(numOfPairs, numOfOpen, numOfClose+1, queue2)
    
generateParenthesis(0, 0, 0, queue)    
print(list)