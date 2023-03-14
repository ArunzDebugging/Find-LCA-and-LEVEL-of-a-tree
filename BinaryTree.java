class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    Node findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    Node findLCA(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        if (node.data == n1 || node.data == n2) {
            return node;
        }

        Node leftLCA = findLCA(node.left, n1, n2);
        Node rightLCA = findLCA(node.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    int getLevel(Node node, int data, int level) {
        if (node == null)
            return 0;

        if (node.data == data)
            return level;

        int downlevel = getLevel(node.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;

        downlevel = getLevel(node.right, data, level + 1);
        return downlevel;
    }
}

