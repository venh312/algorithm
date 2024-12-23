/*
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.

Input: head = [-10, -3, 0, 5, 9]
Output: [0, -3, 9, -10, null, 5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 */
class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null; // 기본 케이스: 리스트가 비어 있으면 null 반환
        }
        if (head.next == null) {
            return new TreeNode(head.val); // 리스트에 노드가 하나만 있으면 해당 값을 트리 노드로 반환
        }

        // 1단계: 중간 노드를 찾기 위해 slow와 fast 포인터 사용
        ListNode prev = null; // slow의 이전 노드를 추적
        ListNode slow = head; // 중간 노드를 찾기 위한 느린 포인터
        ListNode fast = head; // 끝까지 이동하는 빠른 포인터

        while (fast != null && fast.next != null) {
            prev = slow;       // slow의 이전 노드 갱신
            slow = slow.next;  // slow는 한 칸 이동
            fast = fast.next.next; // fast는 두 칸 이동
        }

        // 2단계: 중간 노드를 기준으로 리스트를 분할
        if (prev != null) {
            prev.next = null; // 중간 노드 이전의 리스트를 끊어줌
        }

        // 3단계: 중간 값으로 새로운 트리 노드 생성
        TreeNode root = new TreeNode(slow.val);

        // 4단계: 재귀적으로 왼쪽과 오른쪽 서브트리를 생성
        root.left = sortedListToBST(head); // 왼쪽 절반 리스트로 서브트리 생성
        root.right = sortedListToBST(slow.next); // 오른쪽 절반 리스트로 서브트리 생성

        return root; // 생성된 트리 반환
    }
}






