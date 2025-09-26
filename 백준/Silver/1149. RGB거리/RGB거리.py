# 모든 집을 칠하는 비용의 최솟값
# 이웃한 집의 색은 서로 달라야 함
# i번째 집을 R로 칠한 경우 dp[i][R] = cost[i][R] + min(dp[i-1][G], dp[i-1][B])
# i번째 집을 G로 칠한 경우 dp[i][G] = cost[i][G] + min(dp[i-1][R], dp[i-1][B])
# i번째 집을 B로 칠한 경우 dp[i][B] = cost[i][B] + min(dp[i-1][R], dp[i-1][G])

N = int(input())
cost = []
for _ in range(N):
    c = list(map(int, input().split()))
    cost.append(c)

dp = []
dp.append(cost[0])
for i in range(1, N):
    cost_R = cost[i][0] + min(dp[i-1][1], dp[i-1][2])
    cost_G = cost[i][1] + min(dp[i-1][0], dp[i-1][2])
    cost_B = cost[i][2] + min(dp[i-1][0], dp[i-1][1])
    dp.append([cost_R, cost_G, cost_B])

print(min(dp[-1]))