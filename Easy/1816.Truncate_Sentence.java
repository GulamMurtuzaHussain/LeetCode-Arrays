class Solution {
    public String truncateSentence(String s, int k) {
        String str = new String();
        int word = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' ') word++;
            if(word == k) break;
            str += s.charAt(i);
        }
        return str;
    }
}
