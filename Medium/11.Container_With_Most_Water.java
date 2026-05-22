int maxArea(int* height, int heightSize) {
    int max=0,distance=0,Height=0;
    int one=0,two=heightSize-1;

    while(one<two){
    distance = two-one;
     if(height[one]<height[two]){
        Height=height[one];
     }
     else{
        Height=height[two];
     }
     if((distance * Height)>max){
        max = distance * Height;
     }
     if(height[one]<height[two]){
        one++;
     }
     else{
        two--;
     }
    }
    printf("%d ",max);
    return max;
}
