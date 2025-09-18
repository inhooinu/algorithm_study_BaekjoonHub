# 2*1: 1가지 / f(1)
# 2*2: 2가지 / f(2)
# 2*3: 3가지 / f(2) + f(1) = f(3)
# 2*4: 5가지 = f(3) + f(2) = f(4)
n = int(input())
dp = [1, 2]
if n<=2:
    cnt = dp[n-1]
else:
    for i in range(2, n):
        dp.append(dp[i-1] + dp[i-2])
    cnt = dp[n-1]

print(cnt%10007)