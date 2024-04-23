package leetcode.problems;

/**
Given the heads of two singly linked-lists headA and headB,
return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:

The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program.
If you correctly return the intersected node, then your solution will be accepted.

Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
There are 2 nodes before the intersected node in A;
There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B
(2nd node in A and 3rd node in B) are different node references.
In other words, they point to two different locations in memory,
while the nodes with value 8 in A and B (3rd node in A and 4th node in B)
point to the same location in memory.

교차 노드의 값은 8입니다(두 목록이 교차하는 경우 0이 아니어야 함).
A의 머리에서 보면 [4,1,8,4,5]로 읽힙니다. B의 머리에서 보면 [5,6,1,8,4,5]로 읽힙니다.
A의 교차 노드 전에 2개의 노드가 있고, B의 교차 노드 전에 3개의 노드가 있습니다.
- A와 B에서 값이 1인 노드는 서로 다른 노드 참조이므로 교차된 노드의 값은 1이 아닙니다.
즉, 메모리에서 서로 다른 두 위치를 가리키지만, A와 B에서 값이 8인 노드는 메모리에서 같은 위치를 가리킵니다.

* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) {
*         val = x;
*         next = null;
*     }
* }
*/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Boolean> hMap = new HashMap<>();
        while (headA != null) {
            hMap.put(headA, true);
            headA = headA.next;
        }

        while (headB != null) {
            if (hMap.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
