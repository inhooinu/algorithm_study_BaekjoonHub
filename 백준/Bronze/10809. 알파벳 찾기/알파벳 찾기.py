s = input()

char = 'a'
for i in range(26):
	print(s.find(chr(ord(char) + i)), end=" ")