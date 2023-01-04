package basics.mindtickleLLD.storage;

public interface Storage {
    void put(String key, String value);
    String get(String key);
    void remove(String key);
}
