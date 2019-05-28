package LeetCode.Top100;

/**
 *    单词搜索
 */
public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        if (board == null || rows < 1 || cols < 1 || word == null){
            return false;
        }
        boolean[] isVisited = new boolean[rows*cols];
        for (boolean v : isVisited){
            v = false;
        }
        int pathLength = 0;
        for (int row=0; row < rows; row++){
            for (int col=0; col < cols; col++){
                if (hashPathCore(board,rows,cols,row,col,word,pathLength,isVisited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean hashPathCore(char[][] board, int rows, int cols, int row, int col, String word, int pathLength, boolean[] isVisited){
        if (row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row * cols + col] == true
                || word.charAt(pathLength) != board[row][col])
            return false;
        if (pathLength == word.length()-1){
            return true;
        }
        boolean hasPath = false;
        isVisited[row * cols + col] = true;
        hasPath = hashPathCore(board, rows, cols, row - 1, col, word, pathLength + 1, isVisited)
                || hashPathCore(board, rows, cols, row + 1, col, word, pathLength + 1, isVisited)
                || hashPathCore(board, rows, cols, row, col - 1, word, pathLength + 1, isVisited)
                || hashPathCore(board, rows, cols, row, col + 1, word, pathLength + 1, isVisited);
        if (!hasPath) {
            isVisited[row * cols + col] = false;
        }
        return hasPath;
    }
}
