word = list(input().upper())

count = {}
for i in word:
	if i in count:
		count[i] += 1
	else:
		count[i] = 1

count = sorted(count.items(), key=lambda x: x[1], reverse=True)
count = list(count)

if len(count) >= 2:
	if count[0][1] == count[1][1]:
		print('?')
	else: print(count[0][0])
else: print(count[0][0])