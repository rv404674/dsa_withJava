package HashMap;

import java.util.HashMap;

/**
 * Requirements - n<3k
 * TC, SC - O(1), O(n)
 * NOTE: HashMap + Doubly LInkedin List
 * Concept - https://www.youtube.com/watch?v=xDEuM5qa0zg&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=78
 * Java Code - https://www.youtube.com/watch?v=Xc4sICC8m4M
 */
class Node {
    Node next, prev;
    int key, val;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    int capacity;
    HashMap<Integer, Node> hashMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            remove(node);
            add(node);

            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        // if the key is already present
        if(hashMap.containsKey(key))
            remove(hashMap.get(key));
        // cache is full
        else if (hashMap.size() == capacity)
            remove(tail.prev);

        add(new Node(key, value));
    }

    // Insert just after head
    public void add(Node node){
        hashMap.put(node.key, node);
        Node headNext = head.next;
        // first fix head side
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    // remove the node
    public void remove(Node node) {
        hashMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}