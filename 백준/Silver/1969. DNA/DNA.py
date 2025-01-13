def hamming_dist(s, t):
    s = list(s)
    t = list(t)

    cnt = 0
    for i in range(len(s)):
        if (s[i]!=t[i]):
            cnt += 1

    return cnt

# 입력 받기
n, m = map(int, input().split())
dna_list = []
for _ in range(n):
    dna = input()
    dna_list.append(dna)

dna_s = ''

# 위치 별 가장 많이 나온 알파벳 찾기
for j in range(m):
    cnt_alpha = [0 for _ in range(26)]
    for i in range(n):
        character = dna_list[i][j]
        cnt_alpha[ord(character)-65] += 1
    # print(chr(cnt_alpha.index(max(cnt_alpha)) + 65))
    dna_s += chr(cnt_alpha.index(max(cnt_alpha)) + 65)

sum_h_dist = 0

# Hamming Distance의 합 구하기
for dna in dna_list:
    sum_h_dist += hamming_dist(dna_s, dna)

print(dna_s)
print(sum_h_dist)