public class Percolation {
  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be either be equal to or greater than 1");
    }
  }
  // open site (row, col) if it is not open already
  public void open(int row, int col) {
    if (row <= 0) {
      throw new IllegalArgumentException("row must be either be equal to or greater than 1");
    }

    if (col <= 0) {
      throw new IllegalArgumentException("col must be either be equal to or greater than 1");
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
    return true;
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
  // public     int numberOfOpenSites() {
  //
  // }       // number of open sites
  // public boolean percolates() {
  //
  // }              // does the system percolate?
  //
  // public static void main(String[] args) {
  //
  // }   // test client (optional)
}
