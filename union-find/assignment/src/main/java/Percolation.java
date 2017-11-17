import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private final int size, gridSize, virtualTop, virtualBottom;
  private int openSitesCount;
  private final WeightedQuickUnionUF weightedUnion;
  private final WeightedQuickUnionUF fullness;
  private boolean[] grid;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be either be equal to or greater than 1");
    }
    size = n;
    gridSize = n * n;
    grid = new boolean[gridSize];
    virtualTop = 0;
    openSitesCount = 0;
    virtualBottom = n * n + 1;
    weightedUnion = new WeightedQuickUnionUF(n * n + 2);
    fullness = new WeightedQuickUnionUF(n * n + 1);
  }
  // open site (row, col) if it is not open already
  public void open(int row, int col) {
    validateCoordinates(row, col);

    if (!isOpen(row, col)) {
      int id = flattenCoordinates(row, col);

      if (row == 1) {
        weightedUnion.union(virtualTop, id);
        fullness.union(virtualTop, id);
      }
      if (row == size) {
        weightedUnion.union(virtualBottom, id);
      }
      connectAdjacent(id, row + 1, col);
      connectAdjacent(id, row - 1, col);
      connectAdjacent(id, row, col - 1);
      connectAdjacent(id, row, col + 1);

      grid[id] = true;
      openSitesCount++;
    }
  }
  // is site (row, col) open?
  public boolean isOpen(int row, int col) {
    validateCoordinates(row, col);
    return grid[flattenCoordinates(row, col)];
  }
  // is site (row, col) full?
  public boolean isFull(int row, int col) {
    validateCoordinates(row, col);

    if (isOpen(row, col)) {
      return fullness.connected(virtualTop, flattenCoordinates(row, col));
    }
    return false;
  }

  // number of open sites
  public int numberOfOpenSites() {
    return openSitesCount;
  }

  // does the system percolate?
  public boolean percolates() {
    boolean percolates = weightedUnion.connected(virtualTop, virtualBottom);
    return percolates;
  }

  private int flattenCoordinates(int row, int col) {
    validateCoordinates(row, col);
    return (size * (row - 1)) + (col - 1);
  }

  private void validateCoordinates(int row, int col) throws IllegalArgumentException {
    if (row <= 0 || row > size) {
      throw new IllegalArgumentException("Value must be greater than 0 and less than or equal to the grid size");
    }

    if (col <= 0 || col > size) {
      throw new IllegalArgumentException("Value must be greater than 0 and less than or equal to the grid size");
    }
  }

  private void connectAdjacent(int id, int i, int j) {
    try {
      if (isOpen(i, j)) {
        int neighbouringIndex = flattenCoordinates(i, j);
        weightedUnion.union(neighbouringIndex, id);
        fullness.union(neighbouringIndex, id);
      }
    } catch (IndexOutOfBoundsException e) {
        // don't connect field with field outside grid
    } catch (IllegalArgumentException e) {
        // don't connect field with field outside grid
    }
  }
}
