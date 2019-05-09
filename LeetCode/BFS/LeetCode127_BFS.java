package LeetCode.BFS;

import java.util.*;

public class LeetCode127_BFS {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int curr = 1;
        int next = 0;
        int layer = 1;
        while (!queue.isEmpty()){
            String current = queue.poll();
            curr--;
            for (int i=0;i<wordList.size();i++){
                if(visited[i])
                    continue;
                //没有标记过
                String dic = wordList.get(i);
                if(canChange(current,dic)){
                    if(dic.equals(endWord))
                        return layer+1;  //要加上最后一层
                    queue.add(dic);
                    next++;
                    visited[i] = true;
                }
            }
            if(curr == 0){
                layer++;
                curr = next;
                next = 0;
            }
        }
        return 0;
    }

    //是否可以转换的辅助函数
    public static boolean canChange(String x,String y) {
        int diff = 0;
        for (int i=0;i<x.length();i++){
            if (x.charAt(i) != y.charAt(i))
                diff++;
        }
        return diff==1;
    }

    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] words =  {"hot","dot","dog","lot","log","cog"};
        String[] words2 = {"hot","dot","dog","lot","log"};
        wordList = Arrays.asList(words);
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
}
