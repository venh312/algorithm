/*
https://leetcode.com/problems/partition-list/

Given the head of a linked list and a value x,
partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
링크된 목록의 헤드와 값 x가 주어지면
x보다 작은 모든 노드가 x보다 크거나 같은 노드 앞에 오도록 분할합니다.
두 분할 각각에 있는 노드의 원래 상대적 순서를 보존해야 합니다.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
*/
class Partition {
    public ListNode partition(ListNode head, int x) {
        // Create two dummy nodes to manage 'less' and 'greater' lists
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        // Pointers to build the two lists
        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        while(head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                // Append to 'greater' list
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        // End the 'greater' list to avoid cycles
        greater.next = null;

        // Connect the 'less' list to the 'greater' list
        less.next = greaterDummy.next;

        // Return the head of the 'less' list
        return lessDummy.next;
    }
}
