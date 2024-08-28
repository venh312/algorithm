/**
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 가상의 헤드 노드를 생성하여 결과 리스트를 관리합니다.
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0; // 올림수를 저장하는 변수

        // 두 리스트와 carry가 모두 0일 때까지 반복
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // 이전 단계에서 올림수를 합산합니다.

            // l1이 null이 아니면 해당 값 추가
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // l2가 null이 아니면 해당 값 추가
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 현재 자리의 값과 올림수 계산
            carry = sum / 10; // 올림수 계산
            int digit = sum % 10; // 현재 자리의 값 계산

            // 현재 자리의 값을 새로운 노드로 추가
            current.next = new ListNode(digit);
            current = current.next;
        }

        return dummyHead.next; // 가상의 헤드 노드를 제외한 결과 리스트 반환
    }
}
