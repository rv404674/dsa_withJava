package linked_lists;

public class Node {
    private int data;
    private Node next;
    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    public int getLength(Node head){
        int length = 0;
        Node curTemp = head;
        while(curTemp != null){
            length++;
            curTemp = curTemp.getNext();
        }
        return length;
    }
}
