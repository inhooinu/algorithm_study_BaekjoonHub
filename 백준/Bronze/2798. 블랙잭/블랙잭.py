import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))
# print(n, m, nums)

result = -1
for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            temp = nums[i] + nums[j] + nums[k]
            if temp <= m and result < temp:
                result = temp

print(result)