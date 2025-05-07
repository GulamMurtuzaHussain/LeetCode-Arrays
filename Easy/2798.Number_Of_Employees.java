class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int no_emp = 0;
        for(int num: hours){
            if(num >= target) no_emp++;
        }
        return no_emp;
    }
}
