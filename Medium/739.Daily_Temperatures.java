class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        int[] stack = new int[temperatures.length];
        int top = -1;

        for(int i=0;i<temperatures.length;i++){
            while(top != -1 && temperatures[i] > temperatures[stack[top]]){
                int index = stack[top--];
                answer[index] = i - index;
            }
            stack[++top] = i;
        }
        return answer;
    }
}

// TC = O(n)
// SC = O(n)
