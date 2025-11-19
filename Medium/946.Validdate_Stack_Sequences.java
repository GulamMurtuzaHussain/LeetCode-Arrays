// class Solution {
//     public boolean validateStackSequences(int[] pushed, int[] popped) {
//         boolean flag = true;

//         int[] stack = new int[pushed.length];
//         int pop = 0,top = -1;
//         for(int i=0;i<pushed.length;i++){
//             stack[++top] = pushed[i];
//             if(stack[top]==popped[pop]){
//                 for(int j=top,k=pop;j>=0 && k<popped.length;j--,k++){
//                     if(popped[k] != stack[j]){
//                         flag = false;
//                         break;
//                     }
//                     else{
//                         flag = true;
//                         top--; pop++;
//                     }
//                 }
//             }
//         }
//         return flag;
//     }
// }
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int top = -1, j = 0;

        for (int x : pushed) {
            stack[++top] = x; // push onto the stack
            while (top >= 0 && stack[top] == popped[j]) {
                top--; // pop from stack
                j++;   // move in popped[]
            }
        }
        return top == -1;
    }
}
