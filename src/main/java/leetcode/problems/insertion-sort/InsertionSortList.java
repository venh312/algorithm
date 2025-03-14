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
class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // 빈 리스트거나 요소가 하나면 그대로 반환
        }

        ListNode dummy = new ListNode(0); // 새로운 정렬된 리스트를 위한 더미(dummy) 노드
        ListNode curr = head; // 현재 탐색 중인 노드
        
        while (curr != null) {
            ListNode prev = dummy; // 정렬된 리스트에서 삽입 위치를 찾기 위한 포인터
            ListNode next = curr.next; // 다음 노드 저장 (현재 노드가 이동하므로 미리 저장)

            // 적절한 삽입 위치 찾기 (정렬된 리스트 탐색)
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // 현재 노드를 prev.next 위치에 삽입
            curr.next = prev.next;
            prev.next = curr;

            // 다음 노드로 이동
            curr = next;
        }

        return dummy.next; // 정렬된 리스트의 헤드 반환
    }
}
