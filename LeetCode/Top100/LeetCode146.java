package LeetCode.Top100;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存机制
 */
public class LeetCode146 {
    static class LRUCache {
        class Node{
            Node pre;
            Node next;
            int key;
            int val;
            public Node(int key,int value){
                this.key = key;
                this.val = value;
            }
            Node withNewValue(int value) {
                this.val = value;
                return this;
            }
        }
        private int capacity;
        private Node head;
        private Node tail;
        private Map<Integer,Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head = null;
            tail = null;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null){
                return -1;
            }
            /* 更新到头部 */
            movaNodeToHead(node);
            return node.val;
        }

        public void movaNodeToHead(Node node){
            if (node == head){
                return;
            }

            if (node == tail){
                truncateTailByOne();
            }else { /* 处于中间位置的节点 */
                /*  改变其节点的指向 */
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            setNodeAsHead(node);
        }

        private void setNodeAsHead(Node node){
            if (head == null){
                head = tail = node;
            }else {
                node.pre = null;
                node.next = head;

                head.pre = node;
                head = node;
            }
        }

        private void truncateTailByOne(){
            tail = tail.pre;
            tail.next = null;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                movaNodeToHead(map.get(key).withNewValue(value));
            }else {
                if (map.size() == capacity) {
                    evictLeastRecentlyUsed();
                }
                setNodeAsHead(new Node(key,value));
            }
            map.put(key,head);
        }

        private void evictLeastRecentlyUsed(){
            map.remove(tail.key);

            if (capacity == 1){
                head = tail = null;
            }else {
                truncateTailByOne();
            }
        }
    }

    public static void main(String[] args){

    }
}
