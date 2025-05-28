class Solution {
    public int consists(String allowed, String word){
        int contains = 0;
        for(int i=0;i<word.length();i++){
            int flag = 0;
            for(int j=0;j<allowed.length();j++){
                if(word.charAt(i) == allowed.charAt(j) ){
                    flag++; break;
                }
            }
            if(flag == 1) contains++;
        }
        if(contains == word.length()) return 1;
        else return 0;
    }
    public int countConsistentStrings(String allowed, String[] words) {
        int consistent = 0;
        for(int i=0;i<words.length;i++){
            if(consists(allowed, words[i])==1) consistent++;
        }
        return consistent;
    }
}
 
/*
class Solution {
    // This function checks if a word only contains allowed characters
    public boolean isConsistent(String allowed, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // check if current character is in allowed
            if (allowed.indexOf(ch) == -1) {
                // character not found in allowed, so it's not consistent
                return false;
            }
        }
        return true; // all characters were allowed
    }

    // Main function to count consistent strings
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isConsistent(allowed, words[i])) {
                count++;
            }
        }
        return count;
    }
}
*/
