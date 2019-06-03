package LeetCode.Top100;

import java.util.LinkedList;
import java.util.Queue;

/**
*   课程表
*   判断有向图是否无环
*   1、深度优先搜素 DFS
*   2、拓扑排序 BFS
*/

public class LeetCode207{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /* 入度 */
        int[] inDegree = new int[numCourses];
        /* 图 */
        int[][] graph = new int[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
            inDegree[prerequisites[i][0]]++;
        }/* 构建图和入度数组 */
        Queue<Integer> queue = new LinkedList<>();
        /* 入读为0的节点入队 */
        for(int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
      //  int num = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v = 0; v < numCourses; v++){
                if(graph[u][v] != 0){
                    inDegree[v]--;
                    if(inDegree[v] == 0){
                        queue.add(v);
                    }
                }
            }
         //   num++;
        }
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}