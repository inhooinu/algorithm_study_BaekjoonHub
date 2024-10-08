# 해설참고
import sys
import heapq

input = sys.stdin.readline

q = []

n = int(input())
for _ in range(n):
    s, t = map(int, input().split())
    q.append([s, t])

q.sort()

classroom = []
heapq.heappush(classroom, q[0][1])

for i in range(1, n):
    if q[i][0] < classroom[0]:  # q[i][0]: 다음 수업이 시작하는 시간 / classroom[0]: 현재 수업이 끝나는 시간
        heapq.heappush(classroom, q[i][1])  # 새로운 강의실 사용
    
    else:  # 현재 수업에 이어서 수업 가능
        # 새로운 수업으로 시간을 변경하기 위해 pop후 새 시간 push
        heapq.heappop(classroom)
        heapq.heappush(classroom, q[i][1])

print(len(classroom))