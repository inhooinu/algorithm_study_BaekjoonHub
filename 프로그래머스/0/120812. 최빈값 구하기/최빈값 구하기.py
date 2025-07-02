def solution(array):
    count = [0]*1000  # 인덱스 번호에 해당하는 숫자의 빈도를 저장하기 위한 리스트
    for num in array:
        count[num] += 1
    
    answer = count.index(max(count))
    frequency = count[answer]

    # 최빈값이 여러 개인 경우 -1 반환
    for i in range(answer+1, len(count)):
        if count[i] == frequency:
            return -1
    
    return answer