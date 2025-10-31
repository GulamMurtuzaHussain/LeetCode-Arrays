class CustomStack {

        int[] stack;
        int top = 0, MaxSize =0 ;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        MaxSize = maxSize;
    }
    
    public void push(int x) {
        if(top >= MaxSize) return ;
        else{
            stack[top] = x;
            top++;
        }
    }
    
    public int pop() {
        if(top <= 0 ) return -1;
        else{
            top--;
            return stack[top];
        }
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k && i<top;i++){
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
