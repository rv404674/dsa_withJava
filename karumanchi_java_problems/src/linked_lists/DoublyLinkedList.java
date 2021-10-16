package linked_lists;

import java.util.Stack;

public class DoublyLinkedList {
    private int length;
    private DLLNode head;
    private DLLNode tail;

    public DoublyLinkedList() {
        head = new DLLNode(Integer.MIN_VALUE, null, null);
        tail = new DLLNode(Integer.MIN_VALUE, null, null);
        length = 0;

        head.setNext(tail);
        tail.setPrevious(head);
    }

    private void insertAtBeginning(DLLNode newNode){
        newNode.setNext(head);
        head.setPrevious(newNode);
        head = newNode;
        length +=1;
    }

    /**
     * Insert at nth Node
     * 0 based postion
     */
    private void insertAtNthPosition(int x, DLLNode newNode){
        if (x > length){
            // insertatEnd
            return;
        }

        DLLNode tmpPtr = head;
        for(int i=1; i<x; i++)
            tmpPtr = tmpPtr.getNext();

        newNode.setNext(tmpPtr.getNext());
        newNode.setPrevious(tmpPtr);

        tmpPtr.getNext().setPrevious(newNode);
        tmpPtr.setNext(newNode);
    }

    private void deleteNodesAtNthPosition(int pos){
        // check for edge case
        DLLNode tempNode = head;
        for(int i=1; i<pos;i++)
            tempNode = tempNode.getNext();

        tempNode.setNext(tempNode.getNext().getNext());
        tempNode.getNext().setPrevious(tempNode);
    }

    /**
     * Note traverse till tail only.
     */
    private void printAllNodes(){
        System.out.println("STARTED PRINTING");
        DLLNode temp = head;
        while(temp.getNext() != tail){
            System.out.print(temp.getData() + "->");
            temp = temp.getNext();
        }

        System.out.println("ENDED PRINTING");
    }

    public static void main(String[] args){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtBeginning(new DLLNode(100));
        doublyLinkedList.insertAtBeginning(new DLLNode(200));
        doublyLinkedList.insertAtBeginning(new DLLNode(300));
        doublyLinkedList.insertAtBeginning(new DLLNode(400));

        // 400->300->1000->200->100
        doublyLinkedList.printAllNodes();
        doublyLinkedList.insertAtNthPosition(2, new DLLNode(1000));
        doublyLinkedList.printAllNodes();

        // delete node at nth pos
        // 400->300->1000->200->100
        doublyLinkedList.deleteNodesAtNthPosition(2);
        doublyLinkedList.printAllNodes();

    }



}
