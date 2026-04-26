h, m = input().split()
h = int(h)
m = int(m)
time = int(input())

sum = m + time

if sum >= 60:
	h = h + sum//60
	m = sum%60
else:
	m = sum

if h >= 24:
	h = h%24

print(h, m)