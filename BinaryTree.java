import java.util.ArrayList;

/**
 * A binary tree that can store a key and an ArrayList as its value.
 */
public class BinaryTree {
    /**
     * Node class representing a node in the binary tree.
     */
    private static class Node {
        String key;
        ArrayList<String> values;
        Node left;
        Node right;

        /**
         * Constructor for a node with a given key and an ArrayList of String.
         */
        Node(String key, ArrayList<String> values) {
            this.key = key;
            this.values = values;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    /**
     * Inserts a key-value pair into the binary tree.
     * If the key already exists, adds the values to the existing ArrayList.
     * @param key the key to insert
     * @param values the ArrayList of integers to insert
     */
    public void insert(String key, ArrayList<String> values) {
        root = insertHelper(root, key, values);
    }

    /**
     * Recursive helper method for inserting a key-value pair into the binary tree.
     * @param node the current node being examined
     * @param key the key to insert
     * @param values the ArrayList of integers to insert
     * @return the updated node
     */
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

    /**
     * Searches for a key in the binary tree and returns its associated ArrayList of integers.
     * If the key is not found, returns null.
     * @param key the key to search for
     * @return the ArrayList of integers associated with the key, or null if the key is not found
     */
    public ArrayList<String> search(String key) {
        Node node = searchHelper(root, key);
        return node == null ? null : node.values;
    }

    /**
     * Recursive helper method for searching for a key in the binary tree.
     * @param node the current node being examined
     * @param key the key to search for
     * @return the node containing the key, or null if the key is not found
     */
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
    /**
     * Checks if a key exists in the binary tree.
     * @param key the key to search for
     * @return true if the key exists in the binary tree, false otherwise
     */
    public boolean containsKey(String key) {
        return searchHelper(root, key) != null;
    }
    /**
 * Prints the binary tree in inorder traversal order.
 */
    public void printInorder() {
        printInorderHelper(root);
    }

    /**
     * Recursive helper method for printing the binary tree in inorder traversal order.
     * @param node the current node being examined
     */
    private void printInorderHelper(Node node) {
        if (node != null) {
            printInorderHelper(node.left);
            System.out.println(node.key + ": " + node.values);
            printInorderHelper(node.right);
        }
    }
}
