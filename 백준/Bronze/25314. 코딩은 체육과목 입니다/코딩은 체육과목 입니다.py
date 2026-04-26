n = int(input())

long = n//4
result = ''
for i in range(long):
	result = result + 'long '

print(result + 'int')