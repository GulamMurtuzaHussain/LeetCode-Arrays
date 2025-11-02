class Solution {
    public String findDifferentBinaryString(String[] nums) {
        if (nums.length == 1 && nums[0].equals("0"))
            return "1";
        HashSet<String> unique = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            unique.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            String temp = new StringBuilder(nums[i]).reverse().toString();
            if (!unique.contains(temp))
                return temp;
        }
        char[] temp = new char[nums.length];
        Arrays.fill(temp, '0');
        String ans = new String(temp);

        if (!unique.contains(ans))
            return ans;
        else if (unique.contains(ans)) {
            Arrays.fill(temp, '1');
            ans = new String(temp);
        }
        if (unique.contains(ans)) {
            StringBuilder tempo = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                tempo.append(nums[i].charAt(0)); // or i
            }
            ans = new String(tempo);
        }
        return ans;
    }
}
