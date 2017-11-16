import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private int size, gridSize, virtualTop, virtualBottom;
  private boolean[] grid;
  private WeightedQuickUnionUF weightedUnion;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be either be equal to or greater than 1");
    }
    size = n;
    gridSize = n * n;
    grid = new boolean[gridSize];
    virtualTop = 0;
    virtualBottom = n * n + 1;
    weightedUnion = new WeightedQuickUnionUF(n * n + 2);
  }
  // open site (row, col) if it is not open already
  public void open(int row, int col) {
    if (row <= 0) {
      throw new IllegalArgumentException("row must be either be equal to or greater than 1");
    }

    if (col <= 0) {
      throw new IllegalArgumentException("col must be either be equal to or greater than 1");
    }

    if (!isOpen(row, col)) {
      int id = flattenCoordinates(row, col);

      if (row == 1) {
        weightedUnion.union(virtualTop, id);
      }
      if (row == size) {
        weightedUnion.union(virtualBottom, id);
      }
      connectAdjacent(id, row + 1, col);
      connectAdjacent(id, row - 1, col);
      connectAdjacent(id, row, col - 1);
      connectAdjacent(id, row, col + 1);

      grid[id] = true;
    }
  }
  // is site (row, col) open?
  public boolean isOpen(int row, int col) {
    if (row <= 0) {
      throw new IllegalArgumentException("row must be either be equal to or greater than 1");
    }

    if (col <= 0) {
      throw new IllegalArgumentException("col must be either be equal to or greater than 1");
    }
    return grid[flattenCoordinates(row, col)];
  }
  // is site (row, col) full?
  public boolean isFull(int row, int col) {
    if (row <= 0) {
      throw new IllegalArgumentException("row must be either be equal to or greater than 1");
    }

    if (col <= 0) {
      throw new IllegalArgumentException("col must be either be equal to or greater than 1");
    }

    if (isOpen(row, col)) {
      return weightedUnion.connected(virtualTop, flattenCoordinates(row, col));
    }
    return false;
  }

  // number of open sites
  public int numberOfOpenSites() {
    int count = 0;

    for (boolean item : grid) {
      if (item) {
        count++;
      }
    }
    return count;
  }

  // does the system percolate?
  public boolean percolates() {
    boolean percolates = weightedUnion.connected(virtualTop, virtualBottom);
    return percolates;
  }

  private int flattenCoordinates(int row, int col) {
    if (row < 0 || row > gridSize || col < 0 || col > gridSize) {
      throw new IndexOutOfBoundsException("Illegal parameter value: " + row + "," + col);
    }
    return (size * (row - 1)) + (col - 1);
  }

  private void connectAdjacent(int id, int i, int j) {
    try {
      if (isOpen(i, j)) {
        int neighbouringIndex = flattenCoordinates(i, j);
        weightedUnion.union(id, neighbouringIndex);
      }
    } catch (IndexOutOfBoundsException e) {
        // don't connect field with field outside grid
    } catch (IllegalArgumentException e) {
        // don't connect field with field outside grid
    }
  }
}
