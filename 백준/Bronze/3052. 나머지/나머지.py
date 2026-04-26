remainder = []

for i in range(10):
	num = int(input())
	remainder.append(num%42)

print(len(set(remainder)))