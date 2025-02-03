/**
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
 */
class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head; // 노드가 없거나 하나뿐이면 그대로 반환

        ListNode odd = head; // 홀수 노드 시작점
        ListNode even = head.next; // 짝수 노드 시작점
        ListNode evenHead = even; // 짝수 노드의 첫 번째 노드를 저장 (나중에 연결)

        while (even != null && even.next != null) {
            odd.next = even.next; // 홀수 노드 연결
            odd = odd.next; // 다음 홀수 노드로 이동
            even.next = odd.next; // 짝수 노드 연결
            even = even.next; // 다음 짝수 노드로 이동
        }

        odd.next = evenHead; // 홀수 리스트의 마지막 노드를 짝수 리스트의 첫 번째 노드와 연결

        return head;
    }
}
