# 정수 배열 A
# 정수 배열 B, 재배열 불가
# S의 값을 가장 작게 만들기 위해 A의 수 재배열 하기
# S의 최솟값은?
N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

# 가장 큰 수와 가장 작은 수가 매칭이 되게
B_with_index = []
for i, num in enumerate(B):
    B_with_index.append((i, num))

B_with_index = sorted(B_with_index, key=lambda x: x[1], reverse=True)
# print(B_with_index)

A.sort()
result = 0
for i in range(len(A)):
    B_index = B_with_index[i][0]
    result += A[i]*B[B_index]

print(result)