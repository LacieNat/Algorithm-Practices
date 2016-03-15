import sys
import math

(a,b,n) = [int(x) for x in sys.stdin.readline().split(" ")]

term = 2

while term < n:
    temp = a
    a = b
    b = pow(b, 2) + temp
    term+=1
    
print(b)