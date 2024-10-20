# 해설참고
import sys
from itertools import combinations

input = sys.stdin.readline

n = int(input())
cost = []
location = []
min_cost = 3000

for _ in range(n):
    cost.append(list(map(int, input().split())))

for i in range(1, n-1):
    for j in range(1, n-1):
        location.append((i, j))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for combination in combinations(location, 3):
    visited = []
    total_cost = 0
    valid = True

    for x, y in combination:
        if (x, y) in visited:
            valid = False
            break

        temp_cost = cost[x][y]
        visited.append((x, y))

        for idx in range(4):
            ax = x + dx[idx]
            ay = y + dy[idx]

            if (ax, ay) in visited:
                valid = False
                break

            temp_cost += cost[ax][ay]
            visited.append((ax, ay))

        if not valid:
            break
        
        total_cost += temp_cost

    if valid:
        min_cost = min(min_cost, total_cost)

print(min_cost)