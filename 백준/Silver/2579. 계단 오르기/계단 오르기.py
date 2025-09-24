# 점수의 최댓값 구하기
# 연속 세 개 불가

# 두 칸 전 계단을 밟고 올라오는 경우
# 한 칸 전 계단 + 세 칸 전 계단을 밟고 올라오는 경우
# f(i) = max(f(i-2)+score(i), f(i-3)+score(i-1)+score(i))

n = int(input())
scores = []
max_scores = [0]*n

for _ in range(n):
    score = int(input())
    scores.append(score)

if n==1:
    print(scores[0])
elif n==2:
    print(scores[0]+scores[1])
else:
    max_scores[0] = scores[0]
    max_scores[1] = scores[0] + scores[1]
    max_scores[2] = max(scores[0]+scores[2], scores[1]+scores[2])
    for i in range(3, n):
        max_scores[i] = max(max_scores[i-2]+scores[i], max_scores[i-3]+scores[i-1]+scores[i])
    
    print(max_scores[-1])