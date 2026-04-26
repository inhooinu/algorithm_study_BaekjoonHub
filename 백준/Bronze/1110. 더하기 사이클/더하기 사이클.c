#include <stdio.h>

int main()
{
    int n, plus, new, cnt = 1;
    scanf("%d", &n);

    plus = n/10 + n%10;
    new = (n%10)*10 + (plus%10);
    while (new!=n){
        plus = new/10 + new%10;
        new = (new%10)*10 + (plus%10);
        cnt++;
    }
    printf("%d", cnt);
}
