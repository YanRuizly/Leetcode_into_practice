package LeetCode.Top100;

import java.util.HashSet;

/**
*   实现Trie（前缀树）
*/

public class LeetCode208{
    class Trie {
        HashSet<String> trieSet;
        /** Initialize your data structure here. */
        public Trie() {
            trieSet = new HashSet<>();
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            trieSet.add(word);
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (trieSet.contains(word)){
                return true;
            }else {
                return false;
            }
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            for (String string : trieSet){
                if (string.startsWith(prefix)){
                    return true;
                }
            }
            return false;
        }
    }
}