# 해설참고
import sys
input = sys.stdin.readline

testcase = int(input())
for i in range(testcase):
	n, m = map(int, input().split())
	arr = list(map(int, input().split()))

	result = 0
	paper_queue = list(enumerate(arr))
	while True:
		if paper_queue[0][1] == max(paper_queue, key=lambda x: x[1])[1]:
			if paper_queue[0][0] == m:
				result += 1
				print(result)
				break
			else:
				result += 1
				paper_queue.pop(0)
		else:
			temp = paper_queue.pop(0)
			paper_queue.append(temp)
		# print(paper_queue)