#include <stdio.h>

int main()
{
    int a[9]={};
    int max=0;
    int index=-1;

    for (int i=0;i<9;i++){
        scanf("%d", &a[i]);
    }
    for (int i=0;i<9;i++){
        if (max<a[i]){
            max=a[i];
            index=i+1;
        }
    }
    printf("%d\n%d", max, index);
}
