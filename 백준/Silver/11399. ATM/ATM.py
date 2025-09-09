N = int(input())
P = list(map(int, input().split()))

time = 0
# 가장 시간이 적게 걸리는 사람이 먼저
P.sort()
for i in range(len(P)):
    time += sum(P[:i+1])

print(time)