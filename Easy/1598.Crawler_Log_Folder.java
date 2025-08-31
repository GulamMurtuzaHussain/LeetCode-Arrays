class Solution {
    public int minOperations(String[] logs) {
        int operations = 0;

        for(int i=0;i<logs.length;i++){
            if(logs[i].equals("./")) continue;
            else if(logs[i].equals("../") && operations>0) operations--;
            else if(!logs[i].equals("../")) operations++;
        }

        return operations++;
    }
}
