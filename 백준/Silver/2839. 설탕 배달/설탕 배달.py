# 5kg, 3kg
# 봉지의 최소 개수
# Nkg을 만들 수 없는 경우 -1
def calculate(N):
    remaining = N
    cnt5 = N//5  # 최대한 많이 가지기
    while remaining:
        remaining = N - cnt5*5
        if remaining%3 == 0:
            cnt3 = remaining//3
            return (cnt5 + cnt3)
        if cnt5 > 0:
            cnt5 -= 1
        else:
            break

    return -1

N = int(input())
print(calculate(N))