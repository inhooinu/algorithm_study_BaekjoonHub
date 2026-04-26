n = int(input())

score = list(map(int, input().split()))
new_score = []

max_score = max(score)
for i in score:
	new_score.append(i/max_score*100)

print(sum(new_score)/len(new_score))