from collections import deque

user_input = input()
user_split = list(user_input)

elements = deque()
temp = ''
for i in range(len(user_split)):
    if (user_split[i]!='+' and user_split[i]!='-'):
        temp += user_split[i]
    else:
        elements.append(int(temp))  # 숫자 넣기
        elements.append(user_split[i])  # 연산자 넣기
        temp = ''
elements.append(int(temp))  # 마지막 숫자 넣기
# print(elements)

sub = deque()  # '-' 기준으로 계산 후 중간 결과 값 저장
temp = ''
for e in elements:
    if (e != '-'):
        temp += str(e)
    else:
        sub.append(eval(temp))
        temp = ''
sub.append(eval(temp))
# print(sub)

result = sub.popleft()
for n in sub:
    result -= n
print(result)