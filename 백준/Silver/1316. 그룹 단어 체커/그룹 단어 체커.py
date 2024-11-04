import sys
input = sys.stdin.readline

def is_group(word):
    temp = []
    for w in word:
        if w not in temp:
            temp.append(w)
        elif temp[-1] == w:
            pass
        else:
            return False
    return True

n = int(input())
count = 0
for _ in range(n):
    word = input().strip()
    if is_group(word):
        count += 1
print(count)