import math

def find_prime(M, N):
    result = []
    for num in range(M, N+1):
        if num == 1:
            continue
        for i in range(2, int(math.sqrt(num))+1):
            if num%i == 0:
                break
        else:
            result.append(num)

    return result

M, N = map(int, input().split())
prime_numbers = find_prime(M, N)
for n in prime_numbers:
    print(n)