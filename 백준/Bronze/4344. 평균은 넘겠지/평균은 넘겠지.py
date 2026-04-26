c = int(input())

case = []
for i in range(c):
	n_score = list(map(int, input().split()))
	case.append(n_score)

for i in case:
	n = i[0]

	sum = 0
	for j in range(1, n+1):
		sum += i[j]
	mean = sum/n

	count = 0
	for j in range(1, n+1):
		if i[j] > mean:
			count += 1

	ratio = count/n
	print("%.3f%%" %(ratio*100))