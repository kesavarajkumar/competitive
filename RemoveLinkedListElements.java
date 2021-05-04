/*
  Question Link - https://leetcode.com/problems/remove-linked-list-elements
  
  Approach 1:
  1. Iterate the list
  2. Find elements with next node of given value
  3. Rearrange the list.
  4. To handle head removal. use dummyNode.
  
  White Paper Code
  public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode pointer = dummyNode;
        while(pointer.next != null) {
            if(pointer.next.val == val) {
                pointer.next = pointer.next.next;
            }
            else {
                pointer = pointer.next;
            }
        }
        return dummyNode.next;
    }
  
  Mistakes
  1. NILL :)
*/

import java.util.*;

class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode pointer = dummyNode;
        while(pointer.next != null) {
            if(pointer.next.val == val) {
                pointer.next = pointer.next.next;
            }
            else {
                pointer = pointer.next;
            }
        }
        return dummyNode.next;
    }
}
