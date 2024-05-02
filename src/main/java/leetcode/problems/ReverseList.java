package leetcode.problems;
/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
*/
public class ReverseList {
  public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode cur = head;
      
      while(cur != null) {
          ListNode nextNode = cur.next;
          cur.next = prev;
          prev = cur;
          cur = nextNode;
      }
      
      return prev;
  }
}
