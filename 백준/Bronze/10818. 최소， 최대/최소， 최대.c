#include <stdio.h>

int main()
{
    int min=1000000, max=-1000000;
    int n, num;
    scanf("%d", &n);
    for (int i=0;i<n;i++){
        scanf ("%d", &num);
        if (num<min) min=num;
        if (num>max) max=num;
    }
    printf("%d %d", min, max);
}
