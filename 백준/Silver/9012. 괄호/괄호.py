import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
	testcase = input()
	stack = []
	isVPS = True

	for i in range(len(testcase)):
		if testcase[i] == '(':
			stack.append(testcase[i])
		elif testcase[i] == ')':
			if len(stack) == 0 or stack[-1] != '(':
				isVPS = False
				break
			else:
				stack.pop()

	if len(stack) == 0 and isVPS:
		print('YES')
	else:
		print('NO')