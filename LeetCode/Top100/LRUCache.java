package LeetCode.Top100;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode146
 * @author YANRUI
 */
public class LRUCache {
    private DNode head; // Most recent accessed
    private DNode tail; // Least recent accessed
    private Map<Integer, DNode> map;
    private int cap;
    private int size;

    public LRUCache(int capacity) {
        head = new DNode(-1, -1);
        tail = new DNode(-1, -1);
        head.next = tail;
        tail.pre = head;

        map = new HashMap<>();
        cap = capacity;
        size = 0;
    }

    // Pre: node must not be part of list
    private void addToHead(DNode node) {
        node.next = head.next;
        head.next = node;
        node.pre = head;
        node.next.pre = node;
    }

    // Pre: node must be part of list
    private void moveToHead(DNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
        addToHead(node);
    }

    private DNode removeTail() {
        DNode node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        node.pre = null;
        node.next = null;
        return node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DNode node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        DNode node = new DNode(key, value);
        addToHead(node);
        map.put(key, node);

        size++;
        if (size > cap) {
            node = removeTail();
            map.remove(node.key);
            size--;
        }
    }

    private class DNode {
        int value;
        int key;
        DNode pre;
        DNode next;

        DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}

