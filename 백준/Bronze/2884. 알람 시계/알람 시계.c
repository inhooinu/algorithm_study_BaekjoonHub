#include <stdio.h>

int main()
{
    int H, M;
    scanf("%d %d", &H, &M);
    if (M<45){
        M=60+M-45;
        H=H-1;
        if (H<0){
            H=23;
        }
    }
    else {
        M=M-45;
    }
    printf("%d %d", H, M);
}
