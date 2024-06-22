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

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// Double linked list + Hashmap
// NOTE: newest after head
// oldest will be the tail Node
class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    int capacity;
    HashMap<Integer, Node> hashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        // if the key already exists
        if (hashMap.containsKey(key))
            removeNode(hashMap.get(key));
        else if (hashMap.size() == this.capacity)
            // hasmap is full. delete the oldes i.e last node
            removeNode(this.tail.prev);

        addNode(new Node(key, value));
    }

    // add it to the hashmap
    // add it after Head.
    void addNode(Node node) {
        hashMap.put(node.key, node);
        // add after the head
        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;

    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        hashMap.remove(node.key);
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