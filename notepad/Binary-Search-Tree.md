이진 검색 트리(Binary Search Tree, BST)는 각 노드가 최대 두 개의 자식을 가지며, 다음의 성질을 만족하는 이진 트리입니다:

1. 노드의 왼쪽 서브트리에 있는 모든 노드의 값은 해당 노드의 값보다 작습니다.
2. 노드의 오른쪽 서브트리에 있는 모든 노드의 값은 해당 노드의 값보다 큽니다.
3. 왼쪽 서브트리와 오른쪽 서브트리도 모두 이진 검색 트리여야 합니다.
BST의 이러한 성질은 검색, 삽입 및 삭제 연산에 유용하게 사용됩니다.

BST의 주요 연산은 다음과 같습니다:

- 삽입(Insertion): 새로운 값을 가진 노드를 적절한 위치에 삽입하여 BST의 성질을 유지합니다.
- 삭제(Deletion): 특정 값을 가진 노드를 삭제하고, BST의 성질을 유지합니다.
- 검색(Search): 특정 값을 가진 노드를 검색합니다.
- 최솟값(Minimum) 및 최댓값(Maximum) 검색: BST에서 가장 작은 값을 가진 노드와 가장 큰 값을 가진 노드를 검색합니다.
- 전위 순회(Pre-order traversal), 중위 순회(In-order traversal), 후위 순회(Post-order traversal) 등의 순회 방법을 사용하여 BST의 모든 노드를 방문합니다.

BST의 장점은 검색, 삽입, 삭제 연산의 평균 시간 복잡도가 `O(log n)`이며, 최악의 경우에도 O(n)이 되지 않는다는 것입니다. 하지만 트리가 균형을 잃어 편향되게 구성될 경우 최악의 경우 시간 복잡도는 O(n)이 될 수 있습니다. 이러한 문제를 해결하기 위해 여러 종류의 `균형 잡힌 트리(Balanced Binary Search Tree)`가 있습니다. 대표적으로 AVL 트리, 레드-블랙 트리, B-트리 등이 있습니다.

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertRecursive(root.right, val);
        }

        return root;
    }

    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (val == root.val) {
            return true;
        } else if (val < root.val) {
            return searchRecursive(root.left, val);
        } else {
            return searchRecursive(root.right, val);
        }
    }

    // 기타 삭제(delete), 최소값(minimum), 최대값(maximum), 중위순회(in-order traversal) 등의 기능도 추가할 수 있습니다.
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        
        System.out.println("Search 4: " + bst.search(4)); // true
        System.out.println("Search 6: " + bst.search(6)); // false
    }
}
```
