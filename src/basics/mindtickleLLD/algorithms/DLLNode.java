package basics.mindtickleLLD.algorithms;

public class DLLNode {
    String  key;
    DLLNode prev;
    DLLNode next;

    public DLLNode(String element) {
        this.key = element;
    }

    public String getKey() {
        return key;
    }
}
