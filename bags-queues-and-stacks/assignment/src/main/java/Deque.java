import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
  private Node first, last;
  private int size;

  // construct an empty deque
  public Deque() {
    first = null;
    last = null;
    size = 0;
  }

  // is the deque empty?
  public boolean isEmpty() {
    return first == null;
  }

  // return the number of items on the deque
  public int size() {
    return size;
  }

  // add the item to the front
  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Argument can't be null");
    }

    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;

    if (size == 0) {
      last = first;
    } else {
      oldFirst.previous = first;
    }

    size++;
  }

  // add the item to the end
  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Argument can't be null");
    }

    Node oldLast = last;
    last = new Node();
    last.item = item;
    if (size == 0) {
      first = last;
    } else {
      oldLast.next = last;
    }
    last.previous = oldLast;

    size++;
  }

  // remove and return the item from the front
  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("No more items");
    }
    Item item = first.item;
    first = first.next;

    if (first != null) {
      first.previous = null;
    }

    if (size == 1) {
      last = null;
    }

    size--;
    return item;
  }

  // remove and return the item from the end
  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("No more items");
    }

    Item item = last.item;
    last = last.previous;

    if (last != null) {
      last.next = null;
    }

    if (size == 1) {
      first = null;
    }
    size--;
    return item;
  }

  // return an iterator over items in order from front to end
  public Iterator<Item> iterator() {
    return new DequeIterator();
  }

  // Using a LinkedList for this solution because of the performance requirement
  // for constant worst case time
  private class Node {
    private Item item;
    private Node next;
    private Node previous;
  }

  private class DequeIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      throw new UnsupportedOperationException("Not implemented");
    }

    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("No more items");
      }
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}
