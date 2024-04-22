package leetcode.problems;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 
Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
*/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
                return false; // 노드가 하나도 없거나, 노드가 하나만 있는 경우에는 순환이 없다고 판단합니다.
            }

            ListNode slow = head; // 거북이 포인터
            ListNode fast = head.next; // 토끼 포인터

            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false; // 만약 토끼 포인터가 리스트의 끝에 도달하면 순환이 없다고 판단합니다.
                }
                slow = slow.next; // 거북이는 한 칸씩 이동합니다.
                fast = fast.next.next; // 토끼는 두 칸씩 이동합니다.
            }

            return true; // 만약 거북이와 토끼가 만나면 순환이 있다고 판단합니다.
    }
}
