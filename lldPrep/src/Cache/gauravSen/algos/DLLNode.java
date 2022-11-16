package Cache.gauravSen.algos;

public class DLLNode {
    String key, value;
    DLLNode prev, next;

    public DLLNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
