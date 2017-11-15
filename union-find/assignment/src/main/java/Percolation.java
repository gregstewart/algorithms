import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private int gridSize, virtualTop, virtualBottom;
  private boolean[] grid;
  private WeightedQuickUnionUF weightedUnion;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be either be equal to or greater than 1");
    }
    gridSize = n;
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

    if(!isOpen(row, col)) {
      if(gridSize == 1) {
        weightedUnion.union(virtualBottom, flattenCoordinates(row, col));
      }
      grid[flattenCoordinates(row, col)] = true;
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
    return true;
  }

  private int flattenCoordinates(int row, int col) {
    return (gridSize * (row - 1)) + (col - 1);
  }

  // public     int numberOfOpenSites() {
  //
  // }       // number of open sites

  // does the system percolate?
  public boolean percolates() {
    return weightedUnion.connected(virtualTop, virtualBottom);
  }

  //
  // public static void main(String[] args) {
  //
  // }   // test client (optional)
}
