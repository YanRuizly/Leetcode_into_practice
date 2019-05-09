package LeetCode.BFS;


import java.util.*;

public class LeetCode127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();//少不了队列
        queue.add(beginWord);
        boolean[] marked = new boolean[wordList.size()+1];//少不了标记
        int layer = 1;//注意返回的是层数+1.所以这里直接放1了
        while(!queue.isEmpty()) {//固定的层数记录形式
            layer++;
            int size = queue.size();
            while (size-->0) {
                String cur = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if(marked[i])continue;
                    String dic = wordList.get(i);
                    if(canChange(dic, cur)) {
                        if(dic.equals(endWord))return layer;
                        queue.add(dic);
                        marked[i] = true;
                    }
                }
            }
        }

        return 0;
    }
    //是否可以转换的辅助函数
    public static boolean canChange(String s,String t) {
        int len = s.length();
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i))diff++;
        }
        return diff==1;
    }


    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] words =  {"hot","dot","dog","lot","log","cog"};
        wordList = Arrays.asList(words);
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
}
