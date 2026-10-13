class Solution {
    public boolean isValidSudoku(char[][] board) {
       HashMap<Character, Integer> freq = new HashMap<>();
       HashSet<Character> row_set = new HashSet<>();
       HashSet<Character> col_set = new HashSet<>();
        // System.out.println(board[0][2]);
       for(int row=0;row<9;row+=3){
           for(int col=0;col<9;col+=3){
                // System.out.println(board[row][col]);
               for(int j=row;j<row+3;j++){
                for(int k=col;k<col+3;k++){
                    //    System.out.print(board[j][k] + " ");
                    freq.put(board[j][k], freq.getOrDefault(board[j][k],0)+1);
                }
                for(char key : freq.keySet()){
                    // System.out.println(key + " : " + freq.get(key));
                    if(key == '.' ) continue;
                    if( freq.get(key) > 1) return false;
                }
                System.out.println();
               }
                // System.out.println("CLEAR");
                freq.clear();
           }
       }

       for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if((board[i][j] != '.') && row_set.contains(board[i][j])) return false;
            if((board[j][i] != '.') && col_set.contains(board[j][i])) return false;
            row_set.add((board[i][j]));
            col_set.add((board[j][i]));
        }
        row_set.clear();
        col_set.clear();
       }

       return true;
    }
}
