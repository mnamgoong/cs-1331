//I worked on the homework assignment alone, using only course materials.
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * Represents a linked list
 * @author Michelle Namgoong
 * @version 1.0
 * @param <T> generic type T
 */
public class LinkedList<T> {

    private Node<T> head;
    private int size;

    /**
     * Creates a default LinkedList with initial capacity 0
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds another Node at the specified index in the LinkedList
     * @param data the data of the new Node
     * @param index the index of the new Node
     */
    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The index is out of bounds.");
        }
        if (isEmpty()) {
            head = new Node<T>(data, null);
            size = 1;
        } else if (index == 0) {
            head = new Node<T>(data, head);
            size++;
        } else {
            int currentIndex = 0;
            Node<T> current = head;
            while (currentIndex < index - 1) {
                current = current.getNext();
                currentIndex++;
            }
            Node<T> newNode = new Node<>(data, current.getNext());
            current.setNext(newNode);
            size++;
        }
    }

    /**
     * Removes the Node at the index that is specified
     * @param index the index of the removed Node
     * @return the data of the removed Node
     */
    public T removeFromIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("The index is out of bounds.");
        }
        T removedData;
        Node<T> current = head;
        Node<T> previous = current;
        int currentIndex = 0;
        if (isEmpty()) {
            removedData = null;
        } else if (head.getNext() == null) {
            removedData = head.getData();
            head = null;
            size--;
        } else {
            while (currentIndex < index && current.getNext().getNext() != null) {
                previous = current;
                current = current.getNext();
                currentIndex++;
            }
            if (index == 0) {
                removedData = current.getData();
                previous.setData(current.getNext().getData());
                current.setNext(current.getNext().getNext());
            } else if (index == size - 1) {
                removedData = current.getNext().getData();
                current.setNext(null);
            } else {
                removedData = current.getData();
                current.setData(current.getNext().getData());
                current.setNext(current.getNext().getNext());
            }
            size--;
        }
        return removedData;
    }

    /**
     * Clears out the entire LinkedList
     */
    public void clear() {
        if (size == 0) {
            throw new NoSuchElementException("The LinkedList is already clear.");
        }
        head = null;
        size = 0;
    }

    /**
     * Finds the data at the specified index in the LinkedList
     * @param index the specified index
     * @return the data at the specified index
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("The index is out of bounds.");
        }
        if (isEmpty()) {
            return null;
        } else if (head.getNext() == null) {
            return head.getData();
        } else {
            Node<T> current = head;
            int currentIndex = 0;
            while (currentIndex < index && current.getNext() != null) {
                current = current.getNext();
                currentIndex++;
            }
            return current.getData();
        }
    }

    /**
     * Returns whether or not the LinkedList is currently empty
     * @return boolean that represents if the LinkedList is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Converts the LinkedList to an ArrayList
     * @return an ArrayList version of the LinkedList
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> output = new ArrayList<T>();
        Node<T> current = head;
        int index = 0;
        while (current != null && index < size) {
            output.add(current.getData());
            current = current.getNext();
            index++;
        }
        return output;
    }

    /**
     * Returns a new LinkedList that stores elements of the type String
     * following a similar idea to the FizzBuzz coding problem
     * @return a LinkedList that follows a similar idea to FizzBuzz
     */
    public LinkedList<String> fizzBuzzLinkedList() {
        LinkedList<String> fizzBuzz = new LinkedList<>();
        Node<T> current = head;
        int index = 1;
        while (current != null) {
            if (index % 3 == 0 && index % 5 == 0) {
                fizzBuzz.addAtIndex("FizzBuzz", index - 1);
            } else if (index % 3 == 0) {
                fizzBuzz.addAtIndex("Fizz", index - 1);
            } else if (index % 5 == 0) {
                fizzBuzz.addAtIndex("Buzz", index - 1);
            } else {
                fizzBuzz.addAtIndex(index + ": " + current.getData().toString(), index - 1);
            }
            current = current.getNext();
            index++;
        }
        return fizzBuzz;
    }

}
