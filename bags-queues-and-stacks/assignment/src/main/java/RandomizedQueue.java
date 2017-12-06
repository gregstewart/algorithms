import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
  private Item[] items;
  private int size;

  // construct an empty randomized queue
  public RandomizedQueue() {
    size = 0;
    items = (Item[]) new Object[1];
  }

  // // is the randomized queue empty?
  public boolean isEmpty() {
    return size == 0;
  }

  // return the number of items on the randomized queue
  public int size() {
    return size;
  }

  // add the item
  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Argument can't be null");
    }

    if (size == items.length) {
      resize(2 * size);
    }

    items[size++] = item;
  }

  // remove and return a random item
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("No more items");
    }

    Item item = items[randomIndex()];
    size--;

    if (size > 0 && size < items.length / 4) {
      resize(items.length / 2);
    }

    return item;
  }

  // return a random item (but do not remove it)
  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException("No more items");
    }

    return items[randomIndex()];
  }

  // return an independent iterator over items in random order
  public Iterator<Item> iterator() {
    return new RandomDequeIterator();
  }

  private class RandomDequeIterator implements Iterator<Item> {
    private int index;

    public RandomDequeIterator() {
      int[] indexOrder = new int[size];
      index = 0;

      for (int i = 0; i < indexOrder.length; i++) {
        indexOrder[i] = i;
      }

      StdRandom.shuffle(indexOrder);
    }

    public boolean hasNext() {
      return index < size;
    }

    public void remove() {
      throw new UnsupportedOperationException("Not implemented");
    }

    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("No more items");
      }

      return items[index++];
    }
  }

  private void resize(int capacity) {
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < size; i++)
      copy[i] = items[i];
    items = copy;
  }

  private int randomIndex() {
    return StdRandom.uniform(size);
  }
}
