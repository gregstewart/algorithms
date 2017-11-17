import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
  private final double mean;
  private final double stdDev;
  private final double lowConfidence;
  private final double highConfidence;


  // perform trials independent experiments on an n-by-n grid
  public PercolationStats(int gridSize, int trials) {
    if (gridSize <= 0) {
      throw new IllegalArgumentException("grid size must be either be equal to or greater than 1");
    }

    if (trials <= 0) {
      throw new IllegalArgumentException("trials must be either be equal to or greater than 1");
    }

    double[] threshold = new double[trials];

    for (int i = 0; i < trials; i++) {
      Percolation percolation = new Percolation(gridSize);

      int runs = 0;
      while (!percolation.percolates()) {
        int row, column;

        do {
          column = StdRandom.uniform(gridSize) + 1;
          row = StdRandom.uniform(gridSize) + 1;
        } while (percolation.isOpen(row, column));

        percolation.open(row, column);
        runs++;
      }

      threshold[i] = runs / (double) (gridSize * gridSize);
    }

    mean = StdStats.mean(threshold);
    stdDev = StdStats.stddev(threshold);
    double confidenceFraction = (1.96 * stddev() / Math.sqrt(trials));
    lowConfidence = mean - confidenceFraction;
    highConfidence = mean + confidenceFraction;
  }
  // sample mean of percolation threshold
  public double mean() {
      return mean;
  }
  // sample standard deviation of percolation threshold
  public double stddev() {
    return stdDev;
  }
  // low  endpoint of 95% confidence interval
  public double lowConfidence() {
    return lowConfidence;
  }
  // high endpoint of 95% confidence interval
  public double highConfidence() {
    return highConfidence;
  }

  // test client (described below)
  public static void main(String[] args) {
    int gridSize = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);

    PercolationStats percolationStats = new PercolationStats(gridSize, trials);
    System.out.println("mean                    = " + percolationStats.mean());
    System.out.println("stddev                  = " + percolationStats.stddev());
    System.out.println("95% confidence interval = " + percolationStats.lowConfidence() + ", " + percolationStats.highConfidence());
  }
}
