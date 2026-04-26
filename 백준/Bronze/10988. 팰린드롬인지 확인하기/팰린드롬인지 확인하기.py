word = input()
word_reverse = reversed(word)

word = list(word)
word_reverse = list(word_reverse)

mark = 0
for i in range(len(word)):
	if word[i] != word_reverse[i]:
		mark = 1
		break

if mark == 0:
	print(1)
else:
	print(0)