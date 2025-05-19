class Solution {
    public int mostWordsFound(String[] sentences) {
        int max_count = 0;
        for(int i=0;i<sentences.length;i++){
            int count = 1;
            for(int j=0;j<sentences[i].length();j++){
                if(sentences[i].charAt(j) == ' ') count++;
            }
            if(count > max_count) max_count = count;
        }
        return max_count;
    }
}

/*
class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;

        for (String sentence : sentences) {
            // Split the sentence by spaces and count the words
            int wordCount = sentence.split(" ").length;

            if (wordCount > maxWords) {
                maxWords = wordCount;
            }
        }

        return maxWords;
    }
}
*/
