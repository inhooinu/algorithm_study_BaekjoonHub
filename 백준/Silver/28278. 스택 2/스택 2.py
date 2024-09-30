import sys

stack = []
n = int(sys.stdin.readline())

for i in range(n):
	line = sys.stdin.readline()
	if ' ' in line:
		a, b = map(int, line.split())
	else:
		a = int(line)

	if a == 1:
		stack.append(b)

	elif a == 2:
		if len(stack) != 0:
			print(stack.pop())
		else:
			print(-1)

	elif a == 3:
		print(len(stack))

	elif a == 4:
		if len(stack) != 0:
			print(0)
		else:
			print(1)

	elif a == 5:
		if len(stack) != 0:
			print(stack[-1])
		else:
			print(-1)