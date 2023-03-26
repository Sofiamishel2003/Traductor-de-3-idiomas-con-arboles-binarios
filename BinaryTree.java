import java.util.ArrayList;

public class BinaryTree {
    
    private static class Node {
        String key;
        ArrayList<String> values;
        Node left;
        Node right;
        Node(String key, ArrayList<String> values) {
            this.key = key;
            this.values = values;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    public void insert(String key, ArrayList<String> values) {
        root = insertHelper(root, key, values);
    }
    private Node insertHelper(Node node, String key, ArrayList<String> values) {
        if (node == null) {
            return new Node(key, values);
        } else if (node.key.equals(key)) {
            node.values.addAll(values);
        } else if (key.compareTo(node.key) < 0) {
            node.left = insertHelper(node.left, key, values);
        } else {
            node.right = insertHelper(node.right, key, values);
        }
        return node;
    }

    public ArrayList<String> search(String key) {
        Node node = searchHelper(root, key);
        return node == null ? null : node.values;
    }

    private Node searchHelper(Node node, String key) {
        if (node == null) {
            return null;
        } else if (node.key.equals(key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return searchHelper(node.left, key);
        } else {
            return searchHelper(node.right, key);
        }
    }
    public boolean containsKey(String key) {
        return searchHelper(root, key) != null;
    }
   
    public void printInorder() {
        printInorderHelper(root);
    }
    private void printInorderHelper(Node node) {
        if (node != null) {
            printInorderHelper(node.left);
            System.out.println(node.key + ": " + node.values);
            printInorderHelper(node.right);
        }
    }
}
//Recursos de idea y sintaxis del arbol binario provenientes de chatgpt