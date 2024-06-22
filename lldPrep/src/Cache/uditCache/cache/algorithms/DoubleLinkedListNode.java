package Cache.uditCache.cache.algorithms;

public class DoubleLinkedListNode<E> {
    E element;

    DoubleLinkedListNode<E> prev;
    DoubleLinkedListNode<E> next;

    public DoubleLinkedListNode(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public E getElement() {
        return element;
    }
}
