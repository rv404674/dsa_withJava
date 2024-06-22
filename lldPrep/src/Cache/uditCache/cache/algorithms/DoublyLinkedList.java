package Cache.uditCache.cache.algorithms;

public class DoublyLinkedList<E> {
    // this is same as the standard LRU implementiona of LC
    // newest just after head

    DoubleLinkedListNode<E> head;
    DoubleLinkedListNode<E> tail;

    public DoublyLinkedList() {
        head = new DoubleLinkedListNode<E>(null);
        tail = new DoubleLinkedListNode<E>(null);

        head.next = tail;
        tail.prev = head;
    }

    public void deleteNode(DoubleLinkedListNode<E> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addNode(DoubleLinkedListNode<E> node){
        // add after the head
        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;
    }

    public DoubleLinkedListNode<E> getNodeToBeEvicted() {
        if(isEmpty())
            return null;
        DoubleLinkedListNode<E> temp = tail.prev;
        return temp;
    }

    boolean isEmpty(){
        return head.next == tail;
    }


}
