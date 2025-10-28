class Solution {
    public int isEquals(int[] target, List<Integer> stack){
        if(stack.size() <= target.length){
        for(int i=0;i<stack.size();i++){
            if(stack.get(i) != target[i]) return 0;
        }
        }
        if(stack.size() != target.length) return -1;
        return 1;
    }
    public List<String> buildArray(int[] target, int n) {  
        List<Integer> stack = new ArrayList<>();
        List<String> operations = new ArrayList<>();
        int top = 0 ;

        for(int i=1;i<=n;i++){
            if(top == 0){
                stack.add(i); top++;
                operations.add("Push");
            }
            else if(isEquals(target,stack) == 0){
                stack.remove(stack.size() - 1);
                operations.add("Pop");
                stack.add(i); top++;
                operations.add("Push");
            }
            else{
                stack.add(i); top++;
                operations.add("Push");                
            }
            if(stack.size() == target.length && isEquals(target,stack)==1) break;
        }
        return operations;
    }
}

/*  GPT

public List<String> buildArray(int[] target, int n) {
    List<String> operations = new ArrayList<>();
    int j = 0;
    for (int i = 1; i <= n && j < target.length; i++) {
        operations.add("Push");
        if (i != target[j]) {
            operations.add("Pop");
        } else {
            j++;
        }
    }
    return operations;
}
*/
