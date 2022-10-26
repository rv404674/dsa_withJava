package linkedList;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public class reverseALinkedList {
        // NOTE: easy explanation https://www.youtube.com/watch?v=iRtLEoL-r-g&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=28
        // PRoblem - https://leetcode.com/problems/reverse-linked-list/
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            ListNode next;

            while(cur!=null){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            return prev;
        }

        }
    }
