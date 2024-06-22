package Cache.uditCache.cache.eviction;

import Cache.uditCache.cache.algorithms.DoubleLinkedListNode;
import Cache.uditCache.cache.algorithms.DoublyLinkedList;

import java.util.HashMap;

public class LruEviction<Key> implements EvictionPolicy<Key>{

    // Hashmap + DLL
    // NOTE: value is fetched from the storage, so we need to just worry about key.
    private DoublyLinkedList<Key> doublyLinkedList;
    private HashMap<Key, DoubleLinkedListNode<Key>> hashMap;

    public LruEviction() {
        this.doublyLinkedList = new DoublyLinkedList<Key>();
        this.hashMap = new HashMap<>();
    }

    /**
     * NOTE: access key will acess the key. Key will always be present.
     * NOTE: newest at the front.
     * STEPS
     * 1. remove the key from the DLL
     * 2. add it to the current hashmap
     * 3. add it to just after the head node.
     * @param key
     */
    @Override
    public void accessKey(Key key) {
        DoubleLinkedListNode<Key> node = new DoubleLinkedListNode<>(key);
        if(hashMap.containsKey(key)) {
            doublyLinkedList.deleteNode(hashMap.get(key));
        }

        doublyLinkedList.addNode(node);
        hashMap.put(key, node);
    }

    @Override
    public Key evictKey() {
        DoubleLinkedListNode<Key> evictedNode = doublyLinkedList.getNodeToBeEvicted();
        doublyLinkedList.deleteNode(evictedNode);
        hashMap.remove(evictedNode.getElement());

        return evictedNode.getElement();
    }
}
