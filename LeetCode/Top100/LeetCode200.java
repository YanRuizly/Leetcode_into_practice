package LeetCode.Top100;


/**
*   岛屿数量
*   
*/

public class LeetCode200{
    public int numIslands(char[][] arr) {
        if(arr.length==0)
            return 0;
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int ans = 0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                /* 陆地1 */
                if(arr[i][j] - '0' != 0){
                    if(dfs(arr,i,j,visited)){
                        ans+=1;
                    }
                }
            }
        } 
        return ans;
    }

    private boolean  dfs(char[][] arr,int i,int j,boolean[][] visited){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j] - '0' == 0){
            return true;
        }
        if(visited[i][j]){
            return false;
        }
        boolean ret = false;
        visited[i][j] = true;
        ret = dfs(arr, i, j-1, visited) || 
                dfs(arr, i, j+1, visited) || 
                dfs(arr, i-1, j, visited) || 
                dfs(arr, i+1, j, visited);
        return ret;
    }
    
    class Solution {
        public int numIslands(char[][] arr) {
            if(arr.length==0)return 0;
            boolean[][] visited = new boolean[arr.length][arr[0].length];
            int ans=0;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr[0].length;j++)
                {
                    if(arr[i][j]-'0'!=0){
                    if(cal(arr,i,j,visited))ans+=1;}
                }
            }
            
            return ans;
        }
        
        boolean cal(char[][] arr,int i,int j,boolean[][] visited)
        {
            if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]-'0'==0)return true;
            if(visited[i][j])return false;
            boolean ret = false;
            visited[i][j]=true;
            boolean ret1 = cal(arr,i,j-1,visited);
            boolean ret2 = cal(arr,i,j+1,visited);
            boolean ret3 = cal(arr,i-1,j,visited);
            boolean ret4 = cal(arr,i+1,j,visited);
            ret = (ret1 || ret2 || ret3 || ret4);        
            
            return ret;        
        }
    }
}