package LeetCode.Top100;


/**
*   岛屿数量
*   
*/

public class LeetCode200_2{
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                if(grid[i][j]=='1'){
                    helper(grid,i,rows,j,cols);
                    res++;
                }                    
        return res;
    }
    
    public void helper(char[][] grid,int row,int rows,int col,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]=='0')
            return ;
        grid[row][col]='0';
        helper(grid,row+1,rows,col,cols);
        helper(grid,row-1,rows,col,cols);
        helper(grid,row,rows,col+1,cols);
        helper(grid,row,rows,col-1,cols);
        
    }

}