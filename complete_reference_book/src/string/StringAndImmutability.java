package string;

public class StringAndImmutability {
    /**
     * NOTE:
     * Immutable: The internal state remains constant, after it has been entirely created.
     * String are Immutable in Java
     * String name = "Baeldung
     * NOTE: Since immutable objects doesn't change we can share them safely among threads.
     * Cache, Synchronization, Performance and stuff.
     *
     * NOTE:
     * String Pool - Special Memory Region instead Java's Heap.
     * where Strings are stored by JVM. (sort of a cache).
     *
     * String s1 = "Hello";
     * String s2 = "Hello";
     * In this case only one "Hello" will be created in String Pool and the second s2 will reference the first one.
     * NOTE: this is called Interning.
     * https://www.baeldung.com/java-string-immutable
     */
}
