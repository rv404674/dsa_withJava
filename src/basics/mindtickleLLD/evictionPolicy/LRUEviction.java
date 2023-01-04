package basics.mindtickleLLD.evictionPolicy;

import basics.mindtickleLLD.algorithms.DLL;
import basics.mindtickleLLD.algorithms.DLLNode;

import java.util.HashMap;

public class LRUEviction implements EvictionPolicy{
    HashMap<String, DLLNode> hashMap;
    DLL dll;

    public LRUEviction() {
        hashMap = new HashMap<>();
        dll = new DLL();
    }

    @Override
    public void accessElement(String key) {
        if(!hashMap.containsKey(key)){
            // first time visist
            DLLNode node2 = new DLLNode(key);
            dll.addNode(node2);
            hashMap.put(key, node2);
        } else {
            // already seen node.
            DLLNode node = hashMap.get(key);
            dll.removeNode(node);
            dll.addNode(node);
        }
    }

    @Override
    public String evictElement() {
        DLLNode node = dll.evictNode();
        System.out.println("Node Evicted, Key: " + node.getKey());
        hashMap.remove(node.getKey());
        return node.getKey();
    }
}
