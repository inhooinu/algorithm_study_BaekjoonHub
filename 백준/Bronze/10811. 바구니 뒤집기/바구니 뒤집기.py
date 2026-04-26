n, m = map(int, input().split())

basket = [i for i in range(n+1)]

for k in range(m):
	i, j = map(int, input().split())
	temp = basket[i:j+1]
	temp.reverse()
	basket[i:j+1] = temp

for i in range(1, n+1):
	print(basket[i], end=' ')