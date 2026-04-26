submit = [0 for x in range(31)]
submit[0] = 1

for i in range(28):
	num = int(input())
	submit[num] = 1

for i in range(31):
	if submit[i] == 0:
		print(i)