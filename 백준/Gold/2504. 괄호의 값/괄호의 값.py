# 해설참고
user = input()
stack = []

temp = 1
result = 0

for i in range(len(user)):
	if user[i] == '(':
		stack.append('(')
		temp *= 2
	elif user[i] == '[':
		stack.append('[')
		temp *= 3

	elif user[i] == ')':
		if not stack or stack[-1] != '(':
			result = 0
			break
		if user[i-1] == '(':
			result += temp
		stack.pop()
		temp //= 2
	elif user[i] == ']':
		if not stack or stack[-1] != '[':
			result = 0
			break
		if user[i-1] == '[':
			result += temp
		stack.pop()
		temp //=3

	# print(stack)
	# print('temp: ', temp, ', result: ', result)

if len(stack) != 0:
	result = 0

print(result)