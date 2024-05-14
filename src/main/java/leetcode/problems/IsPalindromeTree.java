/**
* Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
*
* Example 1:
* Input: head = [1,2,2,1]
* Output: true
*
* Example 2:
* Input: head = [1,2]
* Output: false
*
* Example 3:
* Input: head = [1,2,3,2,1]
* Output: false
*/
public class IsPalindromeTree {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        int len = stack.size();
        for (int i = 0; i < len / 2; i++) {
            ListNode front = stack.get(i);
            ListNode rear = stack.get(len-(i+1));
            if (front.val != rear.val)
                return false;
        }

        return true;
    }

    /* 공간 생성 하지 않고 해결 하는 방법
        중간 지점 찾기: 두 개의 포인터(slow와 fast)를 사용하여 리스트의 중간 지점을 찾습니다. slow는 한 번에 한 노드씩 이동하고, fast는 한 번에 두 노드씩 이동합니다. 
        fast가 리스트의 끝에 도달하면 slow는 중간 지점에 도달합니다.
        
        리스트 후반부 뒤집기: 중간 지점부터 시작하여 리스트의 후반부를 뒤집습니다. 이를 위해 세 개의 포인터(prev, curr, next)를 사용합니다.
        앞부분과 뒤집힌 뒷부분 비교: 리스트의 앞부분과 뒤집힌 뒷부분을 비교합니다. 만약 값이 다르면 팰린드롬이 아닙니다.
        
        리스트 원래대로 복구: 리스트를 원래 상태로 복구하여 구조를 변경하지 않도록 합니다.
        이 방식으로 O(n) 시간과 O(1) 공간 복잡도로 문제를 해결할 수 있습니다.
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. 중간 지점 찾기 (런너 기법 사용)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 리스트 후반부 뒤집기
        ListNode prev = null, curr = slow, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. 앞부분과 뒤집힌 뒷부분 비교
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        boolean result = true;
        while (result && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                result = false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // 4. 리스트 원래대로 복구
        prev = null;
        curr = slow;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return result;
    }
}
