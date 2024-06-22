package linked_list;

import java.util.HashMap;
import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    // approach1
    // hashtable approach
    // O(N), O(N)
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head)) {
                // cycle
                return true;
            } else {
                hashSet.add(head);
            }
            head = head.next;
        }

        return false;
    }

    // approach2
    // fast ptr, slow ptr approach
    // simple, if there is a cycle, the two pointers will meet at one point.
    public boolean hasCycle2(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr)
                return true;
        }

        return false;
    }
}
