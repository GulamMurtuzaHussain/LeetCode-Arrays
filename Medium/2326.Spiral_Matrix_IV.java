/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int left = 0, right = n - 1, down = m - 1, up = 1;

        int[][] ans = new int[m][n];
        for(int[] row : ans){
            Arrays.fill(row,-1);
        }



        int i = 0, j = 0;
        while (head != null) {
            while (j <= right && head != null) {
                ans[i][j++] = head.val;
                // System.out.println("(" + i + "," + (j-1) + ")" + ans[i][j-1]);
                head = head.next;
            }
            right--;
            j--; i++;

            while (i <= down && head != null) {
                ans[i++][j] = head.val;
                // System.out.println("(" + (i-1) + "," + (j) + ")" + ans[i-1][j]);
                head = head.next;
            }
            down--;
            i--;j--;

            while (j >= left && head != null) {
                // System.out.println("(" + i + "," + j + ")" + ans[i][j]);
                ans[i][j--] = head.val;
                // System.out.println("(" + i + "," + (j+1) + ")" + ans[i][j+1]);
                head = head.next;
            }
            left++;
            j++;i--;

            while (i >= up && head != null) {
                // System.out.println("(" + i + "," + j + ")" + ans[i][j]);
                ans[i--][j] = head.val;
                // System.out.println("(" + (i+1) + "," + (j) + ")" + ans[i+1][j]);
                head = head.next;
            }
            up++;
            i++;j++;
        }


        // for(int[] row: ans){
        //     for(int cell : row){
        //         if(cell == -2)
        //     }
        // }
        return ans;
    }
}
