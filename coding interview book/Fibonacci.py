'''
Created on Oct 8, 2015

@author: lacie
'''

def fibonacci(n):
    if n == 1:
        return 0
    
    if n == 2:
        return 1
    
    if n < 1:
        return None
    
    return fibonacci(n-1) + fibonacci(n-2)


print(fibonacci(8))
