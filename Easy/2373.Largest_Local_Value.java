class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[(grid.length)-2][(grid.length)-2];
        int row_st = 0 , column_st = 0;
        int row_end = 3 , column_end = 3;
        int max = 0;
        
        for(int i=0;i<ans.length;i++){
            column_st = 0 ; column_end = 3;
            for(int j=0;j<ans.length;j++){
                max = 0;
                for(int r=row_st;r<row_end;r++){
                    for(int c=column_st;c<column_end;c++){
                        if(grid[r][c] > max) max = grid[r][c];
                    }
                }
                ans[i][j] = max;
                column_st++; column_end++;
            }
            row_st++; row_end++;
        }






        return ans;
    }
}
