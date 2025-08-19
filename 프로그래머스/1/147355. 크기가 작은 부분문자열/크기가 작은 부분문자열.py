def solution(t, p):
    answer = 0
    
    l = len(p)
    for i in range(len(t)-l+1):
        num = t[i:i+l]
        if num <= p:
            answer += 1
    
    return answer