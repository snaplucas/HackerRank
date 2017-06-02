package data.structures;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.max;

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

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        return max(height(root.left), height(root.right)) + 1;
    }

    private void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            Node node = new Node();
            node.data = value;
            node.left = null;
            node.right = null;
            root = node;
        } else if (root.data > value) root.left = insert(root.left, value);
        else if (root.data < value) root.right = insert(root.right, value);
        return root;
    }
}

class Node {
    int data;
    Node left;
    Node right;
}
