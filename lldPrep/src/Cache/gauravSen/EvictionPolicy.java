package Cache.gauravSen;

import Cache.gauravSen.algos.DLL;
import Cache.gauravSen.algos.DLLNode;

import java.util.HashMap;

// in java LinkedList is a doubly linkedList
// LRU implementation
// newest after the head

public class EvictionPolicy {
    private DLL dll;

    // NOTE: a hashmap is used so that you can directly geet the node. else you have to travel the whole list
    private HashMap<String, DLLNode> mapper;

    public EvictionPolicy() {
        this.dll = new DLL();
        mapper = new HashMap<String, DLLNode>();
    }

    // when a node is accessed
    // assume the key is present already.
    // NOTE: dont worry aboyt removing from HM as storage is taking care of it.
    public void accessKey(String key){
        dll.detachNode(mapper.get(key));
        // add node after the head
        dll.addNode(mapper.get(key));
    }

    public String evictKey(){
        // evict the last key
        DLLNode node = dll.evictNode();
        dll.detachNode(node);
        return node.getKey();
    }
}
