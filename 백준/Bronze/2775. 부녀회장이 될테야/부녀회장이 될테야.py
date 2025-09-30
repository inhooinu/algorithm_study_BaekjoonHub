# 0층 [1, 2, 3, 4, 5, ...]
# 1층 [1, 1+2, 1+2+3, ...] 1+2+...+n
# 2층 [1, 1+1+2, 1+1+2+1+2+3, ...]
# f(k, n) = f(k-1, 1) + f(k-1, 2) + ... + f(k-1, n)
T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())

    people = []
    people.append([i for i in range(1, n+1)])
    for _ in range(1, k+1):
        people.append([0]*n)
    
    for i in range(1, k+1):  # 층
        for j in range(n):  # 호수
            for l in range(j+1):
                people[i][j] += people[i-1][l]

    print(people[-1][-1])