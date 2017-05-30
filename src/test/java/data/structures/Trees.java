package data.structures;

import org.junit.Before;
import org.junit.Test;

public class Trees {

    private Node node;

    @Before
    public void setUp() {
        node = new Node();
    }

    @Test
    public void preOrderTree() {
        preOrder(node);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

class Node {
    int data;
    Node left;
    Node right;
}
