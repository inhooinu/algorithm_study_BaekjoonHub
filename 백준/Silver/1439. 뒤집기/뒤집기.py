def find_count_to_turn_out_to_all_zero_or_all_one(string):
    # 같은 숫자 덩어리로 나눈다
    # i번째 숫자와 i+1번째 숫자가 다른 경우 i까지 한 덩어리로 분리한다
    # 나누어진 덩어리 중 적은 부분의 개수를 구한다
    zero = []
    one = []
    index_s = 0
    index_e = len(string)
    for i in range(len(string)-1):
        num = string[i]
        if num != string[i+1]:
            index_e = i+1
            if num == '0':
                zero.append(string[index_s:index_e])
            else:
                one.append(string[index_s:index_e])
            index_s = i+1

    if index_e < len(string):
        if string[-1] == '0':
            zero.append(string[index_s:])
        else:
            one.append(string[index_s:])

    return min(len(zero), len(one))

string = input()
result = find_count_to_turn_out_to_all_zero_or_all_one(string)
print(result)