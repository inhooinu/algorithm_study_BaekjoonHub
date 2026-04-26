n, m = map(int, input().split())

basket = [i for i in range(1, n+1)]

for x in range(m):
	i, j, k = map(int, input().split())
	begin, end, mid = i-1, j, k-1

	temp1 = basket[mid:end]
	temp2 = basket[begin:mid]
	temp = temp1 + temp2
	basket[begin:end] = temp

for i in basket:
	print(i, end=' ')