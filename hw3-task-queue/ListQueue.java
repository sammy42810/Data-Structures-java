//Samantha Bryan
//I pledge my honor that I have abided by the Stevens Honor System

package HW3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListQueue<E> {
    //Necessary inner class to create nodes in the list
    public class Node<E> {
        private E data; //Stores the data value of a Node
        private Node<E> next; //Stores the next node in the sequence
        private int priority; //Stores the priority of a node which determines placement in the sequence
        private final int LOW_PRIORITY = Integer.MAX_VALUE; //Necessary final value for the LOW_PRIORITY

        //Attaches a given data to a node
        Node(E dataItem) {
            data = dataItem;
            priority = LOW_PRIORITY;
        }

        //Attaches given data and priority to a node
        Node(E dataItem, int priority) {
            data = dataItem;
            this.priority = priority;
        }

        //Attaches given data, next, and priority to a node
        Node(E dataItem, Node ref, int priority) {
            data = dataItem;
            next = ref;
            this.priority = priority;
        }

        //Returns the data
        public E getData() {
            return data;
        }

        //Returns the next node
        public Node<E> getNext() {
            return next;
        }

        //Returns the priority
        public int getPriority() {
            return priority;
        }
    }

    //Defines the iterator used in later code
    private class Iter implements Iterator<E> {
        private Node<E> next = front; //Sets the next value to the front

        //Determines if the node has a subsequent value in the sequence
        public boolean hasNext() {
            return next != null;
        }

        //Throws an error if the next value is null
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("ERROR: Next element is null");
            }
            E data = (E) next.data;
            next = next.next;
            return data;
        }

        /**
         * //Throws an error for unsupported values
         public void remove() {
         throw new UnsupportedOperationException("Operation not supported!");
         }
         */
    }

    private Node<E> front;
    private int size;

    //Initializes a Node as null, sets up the queue
    public ListQueue() {
        front = null;
        size = 0;
    }

    //Initializes a Node queue with a given value
    public ListQueue(Node<E> first) {
        front = first;
        size = 1;
    }

    //Returns the front value of a queue
    public Node<E> getFront() {
        return front;
    }

    //Changes the front value of a queue to a given value
    public void setFront(Node<E> front) {
        this.front = front;
    }

    //Returns the size of a queue
    public int getSize() {
        return size;
    }

    //Returns the front value of a queue but does not remove it
    public E peek() {
        if (front == null) {
            return null;
        }
        return front.getData();
    }

    //Inputs a new Node with given data into a queue according to given priority
    public boolean offer(E item, int priority) {
        if (item == null) {
            throw new NullPointerException("ERROR: Value is null.");
        }
        if (front == null || priority < front.priority) {
            front = new Node(item, front, priority);
            size++;
            return true;
        }
        Node current = front;
        while (current.next != null && priority >= current.next.priority && current.next.priority >= 0) {
            current = current.getNext();
        }
        Node prev = current;
        prev.next = new Node(item, current.next, priority);
        size++;
        return true;
    }

    //Adds a node to the end of the queue with the given data
    public boolean addRear(E item) {
        if (item == null) {
            throw new NullPointerException("ERROR: Value is null!");
        }
        Node<E> n = new Node<>(item, 0);
        if (front == null) {
            front = n;
        } else {
            Node<E> current = front;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.next = n;
        }
        size++;
        return true;
    }

    //Returns and removes the front Node in a queue
    public E poll() {
        if (front.data == null) {
            throw new NullPointerException("ERROR, Value is null!");
        }
        Node<E> temp = front;
        front = front.getNext();
        size--;
        return temp.data;
    }

    //Removes the given Node from a queue if applicable
    public boolean remove(Node<E> toBeRemoved) {
        if (front == null) {
            return false;
        }
        if (front == toBeRemoved) {
            front = front.next;
            size--;
            return true;
        }
        Node<E> current = front;
        while (current.getNext() != null) {
            if (current.getNext() == toBeRemoved) {
                current.next = toBeRemoved.getNext();
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Introduces a new iterator value
    public Iterator<E> iterator() {
        return new Iter();
    }
}
