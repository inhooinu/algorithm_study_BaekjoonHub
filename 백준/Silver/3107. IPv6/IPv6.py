import sys

input = sys.stdin.readline

result = []
IPv6 = input().strip().split(':')

if IPv6[0] == '':
    IPv6.pop(0)
elif IPv6[-1] == '':
    IPv6.pop()

len_IPv6 = len(IPv6)
for i in range(len_IPv6):
    num = IPv6[i]
    if num == '':
        for j in range(8-(len_IPv6-1)):
            result.append('0000')
    else:
        len_num = len(num)
        if len_num < 4:
            num = '0'*(4-len_num) + num
        result.append(num)

print(':'.join(result))