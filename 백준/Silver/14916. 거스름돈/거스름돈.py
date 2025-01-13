n = int(input())

coin5 = 0
coin2 = 0

while (n>=2):
    if (n>8):
        n -= 5
        coin5 +=1
    elif (n%2==0):
        n -= 2
        coin2 += 1
    elif (n>=5):
        n -= 5
        coin5 += 1
    else:
        break

if (n!=0):
    print(-1)
else:
    print(coin5+coin2)