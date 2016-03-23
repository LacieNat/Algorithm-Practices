import sys

def rotateArr(arr, k):
    n = len(arr)
    l = [None]*n
    
    for i in xrange(n):
        l[(i+k)%n] = arr[i]
        
    return l

nkq = sys.stdin.readline().split(" ")
arr = sys.stdin.readline().split(" ")
arr = map(int, arr)
nkq = map(int, nkq)
arr = rotateArr(arr, nkq[1])

for i in xrange(nkq[2]):
    q = int(sys.stdin.readline())
    print arr[q]
    