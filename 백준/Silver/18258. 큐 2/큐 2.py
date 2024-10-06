import sys
from collections import deque

input = sys.stdin.readline
queue = deque()

n = int(input().strip())
for _ in range(n):
    line = input().strip()
    if ' ' in line:
        a, b = line.split()
        b = int(b)
    else:
        a = line
    
    if a == 'push':
        queue.append(b)
    
    elif a == 'pop':
        if not queue:
            print(-1)
        else:
            print(queue.popleft())
    
    elif a == 'size':
        print(len(queue))
    
    elif a == 'empty':
        if not queue:
            print(1)
        else:
            print(0)
    
    elif a == 'front':
        if not queue:
            print(-1)
        else:
            print(queue[0])
    
    elif a == 'back':
        if not queue:
            print(-1)
        else:
            print(queue[-1])