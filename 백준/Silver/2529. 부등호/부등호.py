# 해설참고
import sys
from itertools import permutations

input = sys.stdin.readline

k = int(input())
sign = input().split()
num = [x for x in range(10)]
result = []

for p in permutations(num, k+1):
    for i in range(len(sign)):
        if sign[i] == '<':
            if p[i] > p[i+1]: break
        else:
            if p[i] < p[i+1]: break
    else:
        result.append(p)

result.sort()
print(''.join(map(str, result[-1])))
print(''.join(map(str, result[0])))