package HW4;
/**
 * Samantha Bryan
 * I pledge my honor that I have abided by the Stevens Honor System
 */
/**
 * Imports necessary Java libraries
 */

import java.util.Random;
import java.util.Stack;

/**
 * Creates the Treap class extending comparable <E> so that we can compare nodes
 * @param <E>
 */
public class Treap<E extends Comparable<E>> {
    /**
     * Creates a static class Node<E> of type <E>
     * @param <E>
     */
    private static class Node<E>{
        /**
         * Data fields for the class
         */
        public E data; // key for the search
        public int priority; // random heap priority
        public Node <E > left;
        public Node <E > right;

        /**
         * This constructor creates a Node object
         * @param data
         * @param priority
         */
        public Node( E data, int priority){
            if(data == null){
                throw new IllegalArgumentException("Data can not be null");
            }
            this.data = data;
            this.priority = priority;
            this.left = null;
            this.right = null;
        }

        /**
         * This method rotates the treap right starting at the node it was called with
         * and returns the node that becomes the root
         * @return <E>
         */
        Node <E > rotateRight(){
            Node<E> n = this;
            if(this.left == null){
                throw new IllegalStateException("Right rotation is not possible.");
            }
            Node<E> left = this.left;
            Node<E> current = left.right;
            n.left = current;
            left.right = n;
            return left;
        }

        /**
         * This method rotates the treap right starting at the node it was called with
         * and returns the node that becomes the root
         * @return
         */
        Node <E > rotateLeft(){
            Node<E> n = this;
            if (this.right == null) {
                throw new IllegalStateException("Left rotation is not possible.");
            }
            Node<E> right = this.right;
            Node<E> current = right.left;
            n.right = current;
            right.left = n;
            return right;
        }

    }

    /**
     * Data fields for the Treap class
     */
    private Random priorityGenerator;
    private Node <E > root;

    /**
     * Creates a Treap with random priority
     */
    public Treap(){
        Random prior = new Random();
        this.priorityGenerator = prior;
    }

    /**
     * Creates a treap with random priority within a certain range
     * @param seed
     */
    public Treap(long seed){
//        Random prior = new Random(seed);
        this.priorityGenerator = new Random(seed);
    }

    /**
     * Adds a node to the Treap given a key
     * @param key
     * @return true or false
     */
    boolean add(E key){
        int priority = priorityGenerator.nextInt();
        return add(key, priority);
    }

    /**
     * Adds a node based on both its key and priority
     * @param key
     * @param priority
     * @return
     */
    boolean add(E key, int priority) {
        if(find(key)){
            return false;
        }
        Stack<Node<E>> stack = new Stack<Node<E>>();
        if(root == null) {
            Node<E> newroot = new Node<E>(key, priority);
            root = new Node<E>(key, priority);
            stack.push(root);
            return true;
        }
        Node<E> n = new Node<>(key, priority);
        Node<E> current = root;
        while (current != null) {
            stack.push(current);
            if (n.data.compareTo(current.data) == 0) {
                return false;
            }
            else if(n.data.compareTo(current.data) < 0) {
                if(current.left == null){
                    current.left = n;
                    break;
                }
                current = current.left;
            }
            else if(n.data.compareTo(current.data) > 0) {
                if(current.right == null){
                    current.right = n;
                    break;
                }
                current = current.right;
            }
        }
        current = n;
        return reheap(n, stack);
    }

    /**
     * Helper function for the add method that reheaps the node after it was added to the BST
     * @param n
     * @param stack
     * @return boolean
     */
    public boolean reheap(Node<E> n, Stack<Node<E>> stack){
        if(stack.isEmpty()){
            return true;
        }
        Node<E> first = stack.pop();
        if(first.priority > n.priority){
            if(first.right != null && first.right.data == n.data) {
                first.rotateLeft();
            }
            else {
                first.rotateRight();
            }
        }
        else{
            return true;
        }
        return reheap(n, stack);
    }

    /**
     * Deletes a specific node given its key
     * @param key
     * @return boolean
     */
    boolean delete(E key) {
        if(!this.find(key)){
            System.out.println("There does not exist a node with this key");
            return false;
        }
        Node<E> parent = null;
        Node<E> current = this.root;
        while(current != null){
            if(key.compareTo(current.data) < 0){
                parent = current;
                current = current.left;
            }else if (key.compareTo(current.data) > 0){
                parent = current;
                current = current.right;
            }
            else{
                Node<E> child;
                if(current.right == null){
                    child = current.left;
                }
                else{
                    child = current.right;
                }
                if(parent == null){
                    this.root = child;
                }
                else if(parent.left == current){
                    parent.left = child;
                }
                else{
                    parent.right = child;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Tries to find a node given its key and returns true or false depending on if it exists in the Treap
     * @param root
     * @param key
     * @return
     */
    private boolean find(Node<E> root, E key) {
        if (root == null) {
            return false;
        }
        if (key.compareTo(root.data) == 0) {
            return true;
        } else if (key.compareTo(root.data) < 0) {
            return find(root.left, key);
        } else {
            return find(root.right, key);
        }
    }

    /**
     * Tries to find a node given its key and returns true or false based on whether it exists in the treap
     * @param key
     * @return
     */
    public boolean find(E key){
        return find(root, key);
    }

    /**
     * Prints the Treap as a string that is readable to a user
     * @return String
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return "null\n";
        }
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node<E> node = stack.pop();
            sb.append(node.toString()).append("\n");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return sb.toString();
    }
}
