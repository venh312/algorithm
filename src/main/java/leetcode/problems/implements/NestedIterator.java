/*
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

Implement the NestedIterator class:

NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
int next() Returns the next integer in the nested list.
boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
Your code will be tested with the following pseudocode:

initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to the end of res
return res
If res matches the expected flattened list, then your code will be judged as correct.

Example 1:
Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
*/
public class NestedIterator implements Iterator<Integer> {
    private Queue<Integer> q;
    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList();
        makeFlattenList(nestedList);
    }

    private void makeFlattenList(List<NestedInteger> nestedList) {
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                q.offer(item.getInteger());  
            } else {
                makeFlattenList(item.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
}
