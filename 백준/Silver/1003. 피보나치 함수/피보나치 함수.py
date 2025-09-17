# def fibo(N):
#     if N==0:
#         return 0
#     elif N==1:
#         return 1
#     else:
#         return fibo(N-1) + fibo(N-2)

# 0: 1, 0
# 1: 0, 1
# 2: 1, 1
# 3: 1, 2
# 4: 2, 3
T = int(input())
for _ in range(T):
    N = int(input())
    dp = [(1, 0), (0, 1)]

    if N==0:
        print(dp[0][0], dp[0][1])
    elif N==1:
        print(dp[1][0], dp[1][1])
    else:
        for i in range(2, N+1):
            dp.append((dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1]))
        print(dp[N][0], dp[N][1])