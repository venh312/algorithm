/**
https://leetcode.com/problems/add-two-numbers-ii/description/

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

Example 2:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

Example 3:
Input: l1 = [0], l2 = [0]
Output: [0]
*/
class AddTwoNumbers2 {
    // 연결 리스트를 뒤집는 메서드
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 두 리스트를 뒤집기
        l1 = reverse(l1);
        l2 = reverse(l2);

        // 더한 값을 저장할 더미 헤드
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // 두 리스트를 더함
        while (l1 != null || l2 != null || carry != 0) {
            // l1과 l2의 값 가져오기 (null일 경우 0으로 처리)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // 합을 계산하고 carry 처리
            int sum = x + y + carry;
            carry = sum / 10;

            // 결과 리스트에 새로운 노드 추가
            current.next = new ListNode(sum % 10);
            current = current.next;

            // l1, l2를 각각 다음 노드로 이동
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 결과를 다시 뒤집어서 반환
        return reverse(dummyHead.next);
    }

}
