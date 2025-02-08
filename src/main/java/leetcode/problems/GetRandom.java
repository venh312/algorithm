/**
https://leetcode.com/problems/linked-list-random-node/description/

Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:

Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.
 

Example 1:
Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
*/
class GetRandom {
    private List<Integer> list;
    private Random rand;
    private int size;
    
    public GetRandom(ListNode head) {
        this.list = new ArrayList<>();
        this.rand = new Random();
        this.size = 0;
        while (head != null) {
            list.add(head.val);
            head = head.next;
            size++;
        }
    }
    
    public int getRandom() {
        /*
        내부적으로 의사 난수 생성기(PRNG)를 사용하여 균등하게 분포된 정수를 반환 */
        int randomIndex = rand.nextInt(size); // 0부터 list.size()-1 사이의 임의의 인덱스 선택
        return list.get(randomIndex);
    }
}
