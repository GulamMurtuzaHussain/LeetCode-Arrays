int max_column(int** grid, int gridSize,int column){

    int max=0;
    for(int i=0;i<gridSize;i++){
        if(grid[i][column]>max) max = grid[i][column];
    }
    return max;
}

int max_rows(int** grid,int gridColSize,int row){

    int max=0;
    for(int i=0;i<gridColSize;i++){
        if(grid[row][i]>max) max = grid[row][i];
    }
    return max;
}

int min(int a,int b){
    if(a<b) return a;
    return b;
}
/*
How Does It Work?
Find the skyline limits

The West-East skyline is determined by the tallest building in each row.
The North-South skyline is determined by the tallest building in each column.
Increase building heights carefully

Each building at grid[r][c] can only grow up to the minimum of its row max and column max.
This ensures that the skyline does not change.
*/

int maxIncreaseKeepingSkyline(int** grid, int gridSize, int* gridColSize) {
    int sum=0;
    for(int i=0;i<gridSize;i++){
        for(int j=0;j<gridColSize[i];j++){
            int max_in_row = max_rows(grid,gridColSize[i],i);
            int max_in_column = max_column(grid,gridSize,j);
            int Min = min(max_in_row,max_in_column);
            int previous =Min - grid[i][j];
            sum += previous;
        }
    }
    return sum;
}

/*
✅ What Is a Skyline in This Problem?

Imagine you’re looking at a city made of buildings, all arranged in a square grid (like blocks on a map). Each building has a certain height.
A skyline is what you see when you look at the city from a distance in a particular direction:
From the North (top of the grid): You see the tallest building in each column.
From the South (bottom of the grid): Same as from the North — it's still the tallest building in each column.
From the West (left side of the grid): You see the tallest building in each row.
From the East (right side of the grid): Again, tallest building in each row.
So, the skyline is basically:
One array for row-wise max heights (West-East view)
One array for column-wise max heights (North-South view)

-------

🧠 What Is the Problem Asking?

You’re allowed to increase the height of any building, but you must not change the skyline from any direction.

-------

So you must:

Keep the row max values the same (to preserve West/East views)
Keep the column max values the same (to preserve North/South views)

-------

💡 Goal:

Maximize the total increase in building heights across the city, without violating any of the skyline constraints.

-------

🔎 Example:
Let’s say you have:

grid = [
  [3, 0, 8, 4],
  [2, 4, 5, 7],
  [9, 2, 6, 3],
  [0, 3, 1, 0]
]

Row maxes (West/East view): [8, 7, 9, 3]
Column maxes (North/South view): [9, 4, 8, 7]

So at any cell (r, c), the building height can go up to min(row_max[r], col_max[c]) without breaking skyline rules.

For example, at (0, 1) which is 0:
Row max = 8
Column max = 4

So, we can increase it up to min(8, 4) = 4
The increase is 4 - 0 = 4

Do this for all cells, sum the increases — that’s your answer.

*/
