/**
https://leetcode.com/problems/sort-list/description/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

Given the head of a linked list, return the list after sorting it in ascending order.

Input: head = [4,2,1,3]
Output: [1,2,3,4]
 */
class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1. 중간 지점 찾기 (Slow & Fast Pointer)
        ListNode mid = getMiddle(head);
        ListNode secondHalf = mid.next;
        mid.next = null; // 리스트를 둘로 나눔

        // 2. 재귀적으로 정렬
        ListNode left = sortList(head);
        ListNode right = sortList(secondHalf);

        // 3. 정렬된 두 리스트 병합
        return mergeTwoLists(left, right);
    }

    // 중간 노드 찾기 (Slow & Fast Pointer)
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 두 개의 정렬된 리스트를 병합
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
    }
}
