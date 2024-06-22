package linked_list;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;

        ListNode cur=head, nextNode = head, prev = null;
        while(cur != null){
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        return prev;
    }

   //Approach 2 BacktoBackSWE video
   public ListNode reverseLinkedListRecursive(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode reversedList = reverseLinkedListRecursive(head.next);
        // add me to the reversedList
        head.next.next = head;
        head.next = null;

        return reversedList;
   }
}


