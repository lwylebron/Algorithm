package ClassicAlgorithm;

import java.util.HashMap;
import java.util.Map;

class LRU{

    private ListNode head;
    private ListNode tail;
    int capacity;
    Map<Integer, ListNode> cache ;

    private class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = next = null;
        }
    }

    //给定容量，初始化过程
    public LRU(int capacity) {
        cache = new HashMap<>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            ListNode node = cache.get(key);
            remove(node);
            addToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (cache.size() >= capacity) {
                ListNode toRemove = tail.prev;
                remove(toRemove);  //移除链表中的节点
                cache.remove(toRemove.key);  //移除在map中的值
            }
            ListNode newNode = new ListNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
        } else {
            ListNode node = cache.get(key);
            node.val = value;
            remove(node);
            addToHead(node);
        }
    }

    private void addToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = node.next = null;
    }


}
