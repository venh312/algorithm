package leetcode.problems;

/*
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
*/
class MiddleNode {
    public ListNode middleNode(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int mid = list.size() / 2;
        ListNode midNode = new ListNode();
        ListNode nextNode = midNode;
        for (int i = mid; i < list.size(); i++) {
            nextNode.next = new ListNode(list.get(i));
            nextNode = nextNode.next;
        }

        return midNode.next;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
    
        // fast 포인터가 리스트의 끝에 도달할 때까지 slow 포인터는 한 걸음씩 이동하고, fast 포인터는 두 걸음씩 이동합니다.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        // slow 포인터가 중간 노드를 가리킵니다.
        return slow;
    }
}
