a, b, c = input().split()
a = int(a)
b = int(b)
c = int(c)

if a == b and a == c:
	# 10,000원+(같은 눈)×1,000원
	reward = 10000 + a * 1000
elif a == b:
	# 1,000원+(같은 눈)×100원
	reward = 1000 + a * 100
elif a == c:
	reward = 1000 + a * 100
elif b == c:
	reward = 1000 + b * 100
else:
	# (그 중 가장 큰 눈)×100원
	m = max(a, b, c)
	reward = m * 100

print(reward)