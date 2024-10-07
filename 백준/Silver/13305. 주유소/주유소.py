n = int(input())
road = list(map(int, input().split()))
price = list(map(int, input().split()))

result = 0

min_price = price[0]
result += road[0]*min_price

for i in range(1, n-1):
    if min_price > price[i]:
        min_price = price[i]
    
    result += road[i]*min_price

print(result)