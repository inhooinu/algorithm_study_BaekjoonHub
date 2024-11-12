import sys
input = sys.stdin.readline

n, m = map(int, input().split())
a = []
b = []

for _ in range(n):
    temp = list(map(int, input().split()))
    a.append(temp)

for _ in range(n):
    temp = list(map(int, input().split()))
    b.append(temp)

for i in range(n):
    for j in range(m):
        print(a[i][j] + b[i][j], end=" ")
    print()
