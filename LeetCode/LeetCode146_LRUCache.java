//package LeetCode;
//
//import java.util.HashMap;
//
//public class LeetCode146_LRUCache {
//    public static class DoubleListNode {
//        public DoubleListNode pre;
//        public DoubleListNode next;
//        public int key;
//        public int value;
//
//        public DoubleListNode(int key, int value) {
//            this.key = key;
//            this.value = value;
//            this.pre = this.next = null;
//
//        }
//    }
//
//    private HashMap<Integer,DoubleListNode> mHashMap;
//    private DoubleListNode head;
//    private DoubleListNode tail;
//    private int capacity;
//    private int currentsize;
//
//    public LeetCode146_LRUCache(int capacity) {
//        this.capacity = capacity;
//        this.currentsize = 0;
//        this.mHashMap = new HashMap<>();
//        this.head = this.tail = null;
//    }
//
//    private void removeNodeFromTail(){
//        tail  = tail.pre;
//        if(tail != null){
//            tail.next = null;
//        }
//    }
//
//    private void moveNodeToHead(DoubleListNode node){
//        head.pre = node;
//        node.next = head;
//        node.pre = null;
//        head = node;
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//        if(mHashMap.containsKey(key)){
//            DoubleListNode tNode = mHashMap.get(key);
//            tNode.value = value;
//            if(tNode == tail){
//                if(currentsize > 1){
//                    removeNodeFromTail();
//                    moveNodeToHead(tNode);
//                }
//            }else if(tNode == head){
//                 //头部节点就直接更新值就完了
//            }else {
//                tNode.pre.next = tNode.next;
//                tNode.next.pre = tNode.pre;
//                moveNodeToHead(tNode);
//            }
//
//        }else {
//            DoubleListNode node = new DoubleListNode(key,value);
//            mHashMap.put(key,node);
//            if(currentsize == 0){
//                head = tail = node;
//                currentsize += 1;
//            }else if(currentsize < capacity){ //未满直接头插
//                mHashMap.remove(tail.key); //满了移除尾部
//                removeNodeFromTail();
//                moveNodeToHead(node);
//            }
//        }
//    }
//}
