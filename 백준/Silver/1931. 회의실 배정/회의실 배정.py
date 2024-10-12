import sys

input = sys.stdin.readline

table = []

n = int(input())
for _ in range(n):
    time = list(map(int, input().split()))
    table.append(time)

table.sort(key=lambda x: (x[1], x[0]))

count = 0

end = table[0][1]
count += 1

# 다음 회의의 시작하는 시간 >= 현재 회의의 끝나는 시간 --> count++
for i in range(1, len(table)):
    if table[i][0] >= end:
        count += 1
        end = table[i][1]

print(count)