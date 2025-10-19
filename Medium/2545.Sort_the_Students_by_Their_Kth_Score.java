class Solution {
    public void swap(int[][] score,int i,int j){
        int temp = 0;
        for(int k=0;k<score[i].length;k++){
            temp = score[i][k];
            score[i][k] = score[j][k];
            score[j][k] = temp;
        }
    }
    public int[][] sortTheStudents(int[][] score, int k) {
        for(int i=0;i<score.length;i++){
            for(int j=i+1;j<score.length;j++){
                if(score[i][k] < score[j][k]){
                    swap(score,i,j);
                }
            }
        }
        return score;
    }
}

/*
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[k], a[k]); // Sort in descending order
            }
        });
        return score;
    }
}
*/
