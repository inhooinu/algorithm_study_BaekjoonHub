import sys
from itertools import permutations

input = sys.stdin.readline

n, m = map(int, input().split())

for i in permutations([x for x in range(1, n+1)], m):
    for j in i:
        print(j, end=' ')
    print()