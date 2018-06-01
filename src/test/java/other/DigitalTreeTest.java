package other;

import org.junit.Test;

public class DigitalTreeTest {

    @Test
    public void main() {
        PrefixTree prefixTree = new PrefixTree();

        prefixTree.addEntry("co");
        prefixTree.addEntry("eng");
        prefixTree.addEntry("ro");
        prefixTree.addEntry("trad");

        System.out.println("Lookup (engineering): " + prefixTree.lookup("engineering")); //should return true
        System.out.println("Lookup (school): " + prefixTree.lookup("school")); //should return false
    }

    class PrefixTree {
        Node root;

        PrefixTree() {
            this.root = new Node();
        }


        void addEntry(String entry) {
            Node node = root;
            for (int i = 0; i < entry.length(); i++) {
                int index = entry.charAt(i) - 'a';
                if (node.nextNodes[index] == null) {
                    node.nextNodes[index] = new Node(entry.charAt(i));
                }
                node = node.nextNodes[index];
            }
            node.isEnd = true;
        }

        boolean lookup(String key) {
            Node node = searchPrefix(key);
            return node != null && node.isEnd;
        }

        private Node searchPrefix(String entry) {
            Node node = root;
            for (int i = 0; i < entry.length(); i++) {
                char first = entry.charAt(i);
                if (node.nextNodes[first - 'a'] != null) {
                    node = node.nextNodes[first - 'a'];
                } else {
                    if (node.isEnd) return node;
                    return null;
                }
            }
            return node;
        }

    }

    class Node {
        char value;
        Node[] nextNodes = new Node[26];
        boolean isEnd;

        Node(char value) {
            this.value = value;
        }

        Node() {

        }

    }
}


