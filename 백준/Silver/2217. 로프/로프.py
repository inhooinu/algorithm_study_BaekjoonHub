# 로프를 이용하여 들어올릴 수 있는 물체의 최대 중량 구하기
# k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때 각 로프에는 w/k만큼의 중량이 걸림
# 10 15 -> 20
N = int(input())
ropes = []
for _ in range(N):
    rope = int(input())
    ropes.append(rope)

ropes = sorted(ropes, reverse=True)

w = []
for i in range(N):
    w.append(ropes[i]*(i+1))

print(max(w))