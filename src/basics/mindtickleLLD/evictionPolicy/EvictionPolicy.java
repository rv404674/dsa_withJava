package basics.mindtickleLLD.evictionPolicy;

public interface EvictionPolicy {
    void accessElement(String key);
    String evictElement();
}
