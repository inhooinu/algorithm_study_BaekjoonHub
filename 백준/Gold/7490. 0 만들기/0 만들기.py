from itertools import product

test = int(input())
signs = ['+', '-', '']

for _ in range(test):
    n = int(input())
    sign_product = product(signs, repeat=n-1)
    nums = [i for i in range(1, n+1)]

    results = []
    for s in sign_product:
        temp = ""
        result = ""
        for i in range(len(s)):
            temp += str(nums[i])
            temp += s[i]

            result += str(nums[i])
            if (s[i]==''):
                result += ' '
            else:
                result += s[i]
        
        temp += str(nums[-1])
        result += str(nums[-1])
        if (eval(temp)==0):
            # print(result)
            results.append(result)
    
    results.sort()
    for r in results:
        print(r)
    print()