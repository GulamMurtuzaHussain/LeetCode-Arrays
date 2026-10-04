class Solution {
    public String[] findWords(String[] words) {
        HashSet<Character> s1 = new HashSet<>();
        HashSet<Character> s2 = new HashSet<>();
        HashSet<Character> s3 = new HashSet<>();

        String S1 = "qwertyuiop";
        String S2 = "asdfghjkl";
        String S3 = "zxcvbnm";

        for (char c : S1.toCharArray()) s1.add(c);
        for (char c : S2.toCharArray()) s2.add(c);
        for (char c : S3.toCharArray()) s3.add(c);

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            boolean same = true;
            HashSet<Character> c = new HashSet<>();
            String temp = words[i].toLowerCase();

            if (s1.contains(temp.charAt(0))) c = s1;
            else if (s2.contains(temp.charAt(0))) c = s2;
            else c = s3;
            
            for (int j = 1; j < temp.length(); j++) {
                if (!c.contains(temp.charAt(j)))
                    same = false;
            }
            
            if (same == true)
                ans.add(words[i]);
        }

        return ans.toArray(new String[0]);
    }
}
