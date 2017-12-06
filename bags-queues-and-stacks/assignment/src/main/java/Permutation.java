import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
  public static void main(String[] args) {
    final int k = Integer.parseInt(args[0]);
    RandomizedQueue<String> queue = new RandomizedQueue<String>();

    while (!StdIn.isEmpty()) {
      queue.enqueue(StdIn.readString());
    }

    for (int i = 1; i <= k; i++) {
      StdOut.println(queue.dequeue());
    }
  }
}
