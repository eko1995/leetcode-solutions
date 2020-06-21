package leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * 146. LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 */
public class LRUCache {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int size;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
        {
            return -1;
        }
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
        {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addNode(node);
            return;
        }
        Node node = new Node();
        node.key = key;
        node.val = value;
        if (map.size() == size)
        {
            remove(tail.prev);
            add(node);
        }
        else{
            add(node);
        }
    }

    public void remove(Node node)
    {
        map.remove(node.key);
        removeNode(node);
    }

    public void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public void add(Node node)
    {
        map.put(node.key, node);
        addNode(node);
    }

    public void addNode(Node node)
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public class Node {
        public int val;
        public int key;
        public Node next;
        public Node prev;
    }
}
