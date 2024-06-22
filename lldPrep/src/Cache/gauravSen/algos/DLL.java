package Cache.gauravSen.algos;

// DoublyLinkedList
public class DLL {
    DLLNode head = new DLLNode("","");
    DLLNode tail = new DLLNode("","");

    public DLL() {
        head.next = tail;
        tail.prev = head;
    }

    public void detachNode(DLLNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    // add node just after the head
    public void addNode(DLLNode node){
        node.next = this.head.next;
        head.next.prev = node;

        node.prev = this.head;
        head.next = node;
    }

    public DLLNode evictNode(){
        if(head.next == tail){
            // empty
            System.out.println("DLL is empty");
            return null;
        }

        return tail.prev;
    }
}
