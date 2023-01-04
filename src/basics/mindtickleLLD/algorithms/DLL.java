package basics.mindtickleLLD.algorithms;

public class DLL {
    DLLNode head;
    DLLNode tail;

    public DLL() {
        head = new DLLNode("");
        tail = new DLLNode("");
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode node){
        // fix node
        node.next = head.next;
        node.prev = head;

        // fix head
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DLLNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public DLLNode evictNode(){
        DLLNode node = tail.prev;
        removeNode(tail.prev);
        return node;
    }

}
