import sys
# Enter your code here. Read input from STDIN. Print output to STDOUT
n = int(sys.stdin.readline())

def findPivot(s):
    for i in xrange(len(s)-1, 0, -1):
        if s[i-1]<s[i]:
            return i-1
        
    return -1

def swap(s, i, j):
    s = list(s)
    s[i],s[j] = s[j],s[i]
    return ''.join(s)
    
def nextLargest(s, pivot):
    for i in xrange(len(s)-1, pivot, -1):
        if s[i]>s[pivot]:
            return i
        
    return -1

def inverse(s, start):
    i = start
    j = len(s)-1
    
    if s[j] == '\n':
        j = len(s)-2
    
    while i<j:
        s = swap(s, i, j)
        i+=1
        j-=1
        
    sys.stdout.write(s)
    
def nextPerm(s):
    pivot = findPivot(s)
    #print "---" + s
    if pivot == -1:
        sys.stdout.write("no answer\n")
        return
    
    nx = nextLargest(s, pivot)
    s = swap(s, nx, pivot)
    #print "---" + s
    inverse(s, pivot+1) 
    
for i in xrange(n):
    s = sys.stdin.readline()
    nextPerm(s)