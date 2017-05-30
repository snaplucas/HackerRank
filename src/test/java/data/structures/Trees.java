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

    void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}

class Node {
    int data;
    Node left;
    Node right;
}
