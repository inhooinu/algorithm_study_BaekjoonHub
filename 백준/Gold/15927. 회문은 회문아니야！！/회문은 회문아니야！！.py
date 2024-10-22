import sys

input = sys.stdin.readline

input_str = input().strip()

if len(set(list(input_str))) == 1:
    print(-1)

elif input_str == input_str[::-1]:  # palindrome인 경우
    print(len(input_str)-1)

else:
    print(len(input_str))