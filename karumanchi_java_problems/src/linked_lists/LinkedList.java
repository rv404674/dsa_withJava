package linked_lists;

public class LinkedList {
    Node head;
    private int length = 0;

    public LinkedList() {
        length = 0;
    }

    /**
     * NOTE: synchronized is used to make the function thread safe.
     * First thread that hits the method first, will access the lock over it.
     */
    private synchronized Node getHead() {
        return head;
    }

    // insert node at the beginning
    private synchronized void insertAtBeginning(Node node) {
        node.setNext(head);
        head = node;
        length++;
    }

    // insert node at the end of list
    private synchronized void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(node);
        }
        length++;
    }

    // insert at nth position = 0 based index.
    // 3 -> 5 -> 10 -> 12
    // data = 2, pos = 2
    // O/P = 3 -> 5 -> 2 -> 10 -> 12
    private synchronized void insertAtNthPosition(int data, int x){
        if (x < 0 || x > length) {
            System.out.println("Invalid Input");
            return;
        }

        if (x==0){
            insertAtBeginning(new Node(data));
            return;
        }

        Node newNode = new Node(data);
        newNode.setNext(null);

        // traverse the list till x-1
        int temp = 1;
        Node tempNode = head;
        while (temp < x) {
            temp++;
            tempNode = tempNode.getNext();
        }
        newNode.setNext(tempNode.getNext());
        tempNode.setNext(newNode);

        length ++;
    }

    // traverse the whole list
    public void traverse(){
        System.out.println("Traversal started");
        Node temp  = head;
        while(temp!=null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println("Traversal ended");
    }

    public static void main(String args[]){
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(10);
        Node firstNode = new Node(20);

        linkedList.head.setNext(firstNode);

        System.out.println("Original List");
        linkedList.traverse();

        System.out.println("After insertion in the beginning List");
        linkedList.insertAtBeginning(new Node(1000));
        linkedList.traverse();

        System.out.println("After insertion in the end List");
        linkedList.insertAtEnd(new Node(1500));
        linkedList.traverse();

        System.out.println("After insertion in the nth List");
        linkedList.insertAtNthPosition(-100, 2);
        linkedList.traverse();


        linkedList.insertAtNthPosition(-200, 0);
        linkedList.traverse();



    }

}
