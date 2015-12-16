'''
Created on Oct 9, 2015

@author: lacie
'''
class curr(enumerate):
    quarter = 25
    dime = 10
    nickel = 5
    penny = 1
    
def find(n, denom):

    next_denom = 0
    if denom == curr.quarter:
        next_denom = curr.dime
    elif denom == curr.dime:
        next_denom = curr.nickel
    elif denom == curr.nickel:
        next_denom = curr.penny
    elif denom == curr.penny:
        return 1
        
    i=0
    ways = 0
    while(i*denom<=n):
        ways +=find(n-i*denom, next_denom)
        i += 1
    
    return ways

print(find(25, 25))   
    