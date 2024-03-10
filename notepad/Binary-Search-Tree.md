### 이진 검색 트리(Binary Search Tree)
이진 검색 트리(Binary Search Tree)는 각 노드가 최대 두 개의 자식 노드를 가지며, 왼쪽 자식 노드는 현재 노드보다 작은 값을, 오른쪽 자식 노드는 현재 노드보다 큰 값을 가지는 트리 구조입니다. Java로 이진 검색 트리를 구현하려면 먼저 노드 클래스를 만들고, 그 다음에 이 클래스를 사용하여 트리를 구성할 수 있습니다.

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
