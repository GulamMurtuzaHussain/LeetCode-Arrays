// int maxArea(int* height, int heightSize) {
//     int max=0,distance=0,Height=0;
//     int one=0,two=heightSize-1;

//     while(one<two){ 
//     distance = two-one;
//      if(height[one]<height[two]){ 
//         Height=height[one];
//      }
//      else{
//         Height=height[two];
//      }
//      if((distance * Height)>max){
//         max = distance * Height;
//      }
//      if(height[one]<height[two]){
//         one++;
//      }
//      else{
//         two--;
//      }
//     }
//     printf("%d ",max);
//     return max;
// }


class Solution {
    public int maxArea(int[] height) {
        
        // Lesson Learned!!
        //     Don't Jump To Conclusions Saying That I Can't Solve It,
        //     For Eg, This Problem, The Solution Was Very Easy, 
        //     I Could Have Done It, But Because Of My Immediate Judgment,
        //     I Have Never Understood This Problem Made Me Believe,
        //     I Actually Couldn't Solve It, When In Reality,
        //     I Could Have, It Gave It Some Time.

        int left = 0, right = height.length-1;

        int max = 0;
        while(left < right){
            int area = right - left;
            int h = Math.min(height[left],height[right]);
            int temp = area * h;
            max = (temp > max) ? temp : max;

            if(height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}
