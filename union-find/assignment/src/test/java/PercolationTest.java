/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import edu.princeton.cs.algs4.In;

public class PercolationTest {
    private static final int GRID_SIZE = 5;
    private Percolation percolation;

    @Before public void setUp() {
        percolation = new Percolation(GRID_SIZE);
    }

    @Test public void testPercolationThrowsIllegalArgumentExceptionIfEqualToZero() {
        try {
          new Percolation(0);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("n must be either be equal to or greater than 1"));
        }
    }

    @Test public void testPercolationThrowsIllegalArgumentExceptionIfLessThanZero() {
        try {
          new Percolation(-1);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("n must be either be equal to or greater than 1"));
        }
    }


    // Open tests
    @Test public void testPercolationOpenThrowsIllegalArgumentExceptionIfRowLessThanZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.open(-1,1);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationOpenThrowsIllegalArgumentExceptionIfRowEqualToZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.open(0,1);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationOpenThrowsIllegalArgumentExceptionIfColLessThanZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.open(1,-1);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationOpenThrowsIllegalArgumentExceptionIfColEqualToZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.open(1,0);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationOpenOpensANode() {
      Percolation appUnderTest = new Percolation(1);
      assertFalse("Is not open", appUnderTest.isOpen(1,1));
      appUnderTest.open(1,1);

      assertTrue("Is now open", appUnderTest.isOpen(1,1));
    }

    // isOpen tests
    @Test public void testPercolationIsOpenThrowsIllegalArgumentExceptionIfRowLessThanZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.isOpen(-1,1);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsOpenThrowsIllegalArgumentExceptionIfRowEqualToZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.isOpen(0,1);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsOpenThrowsIllegalArgumentExceptionIfColLessThanZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.isOpen(1,-1);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsOpenThrowsIllegalArgumentExceptionIfColEqualToZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.isOpen(1,0);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsOpenThrowsIllegalArgumentExceptionIfOutOfBounds() {
        Percolation appUnderTest = new Percolation(10);
        try {
          appUnderTest.isOpen(11,5);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsOpenReturnsFalseWhenInitialised() {
      Percolation appUnderTest = new Percolation(1);

      assertFalse("Node is not open", appUnderTest.isOpen(1,1));
    }

    @Test public void testPercolationIsOpenReturnsTrueWhenOpened() {
      Percolation appUnderTest = new Percolation(1);
      appUnderTest.open(1,1);

      assertTrue("Node is open", appUnderTest.isOpen(1,1));
    }


    // isFull tests
    @Test public void testPercolationIsFullThrowsIllegalArgumentExceptionIfRowLessThanZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.isFull(-1,1);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsFullThrowsIllegalArgumentExceptionIfRowEqualToZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.isFull(0,1);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsFullThrowsIllegalArgumentExceptionIfColLessThanZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.isFull(1,-1);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsFullThrowsIllegalArgumentExceptionIfColEqualToZero() {
        Percolation appUnderTest = new Percolation(1);
        try {
          appUnderTest.isFull(1,0);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsFullThrowsIllegalArgumentExceptionIfOutOfBounds() {
        Percolation appUnderTest = new Percolation(10);
        try {
          appUnderTest.isFull(11,5);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationOpenThrowsIllegalArgumentExceptionIfOutOfBounds() {
        Percolation appUnderTest = new Percolation(10);
        try {
          appUnderTest.open(11,5);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationOpenFailedToThrowIllegalArgumentExceptionInFeedBack() {
        Percolation appUnderTest = new Percolation(10);
        try {
          appUnderTest.open(5,11);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsOpenFailedToThrowIllegalArgumentExceptionInFeedBack() {
        Percolation appUnderTest = new Percolation(10);
        try {
          appUnderTest.isOpen(5,11);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationIsFullFailedToThrowIllegalArgumentExceptionInFeedBack() {
        Percolation appUnderTest = new Percolation(10);
        try {
          appUnderTest.isFull(5,11);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationOpenFailedToThrowIllegalArgumentExceptionInFeedBackWithLargeNumber() {
        Percolation appUnderTest = new Percolation(10);
        try {
          appUnderTest.open(2147483647, 2147483647);
          fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException anIllegalArgumentException) {
          assertThat(anIllegalArgumentException.getMessage(), is("Value must be greater than 0 and less than or equal to the grid size"));
        }
    }

    @Test public void testPercolationShouldBeFull() {
        percolation.open(1, 1);
        percolation.open(1, 2);

        assertTrue(percolation.isFull(1, 2));
    }

    @Test public void testPercolationShouldNotBeFull() {
        percolation.open(3, 2);

        assertFalse(percolation.isFull(3, 2));
    }

    @Test public void testPercolationShouldNotBeFilled() {
        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(4, 3);
        percolation.open(5, 3);
        percolation.open(5, 5);

        assertTrue(percolation.isFull(1, 3));
        assertTrue(percolation.isFull(2, 3));
        assertTrue(percolation.isFull(3, 3));
        assertTrue(percolation.isFull(4, 3));
        assertTrue(percolation.isFull(5, 3));
        assertFalse(percolation.isFull(5, 5));
    }

    @Test public void testPercolationShouldNotBeFilledUsingThreesInput() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(3, 1);
        assertFalse(percolation.isFull(3, 1));
    }

    @Test public void testPercolationPercolateReturnsFalseAfterInitialisation() {
      Percolation appUnderTest = new Percolation(1);

      assertFalse("It should not percolate", appUnderTest.percolates());
    }

    @Test public void testPercolationPercolateReturnsTrueAfterConnectingTopToBottom() {
      Percolation appUnderTest = new Percolation(1);
      appUnderTest.open(1,1);
      assertTrue("It should percolate", appUnderTest.percolates());
    }

    @Test public void testPercolationLargerGridConnectsAdjacentSites() {
      Percolation appUnderTest = new Percolation(3);

      appUnderTest.open(1,2);
      appUnderTest.open(2,1);
      appUnderTest.open(2,3);
      appUnderTest.open(3,2);

      assertFalse("Does not percolate", appUnderTest.percolates());
      appUnderTest.open(2,2);

      assertTrue("Does percolate", appUnderTest.percolates());
    }

    @Test public void testPercolationCountOpenSites() {
      percolation.open(1,1);
      percolation.open(5,5);

      assertTrue("Count open sites is correct", percolation.numberOfOpenSites() == 2);
    }

    @Test public void testWithInputOneNoDoesNotPercolate() {
      Percolation percolation = runIntegrationTest("src/test/java/test-data/input1-no.txt");

      assertFalse("Input one does not percolate", percolation.percolates());
      assertTrue("Has zero open sites", percolation.numberOfOpenSites() == 0);
    }

    @Test public void testWithInputOneDoesPercolate() {
      Percolation percolation = runIntegrationTest("src/test/java/test-data/input1.txt");

      assertTrue("Input one does not percolate", percolation.percolates());
      assertTrue("Has one open sites", percolation.numberOfOpenSites() == 1);
    }

    @Test public void testWithInputTwoNoDoesNotPercolate() {
      Percolation percolation = runIntegrationTest("src/test/java/test-data/input2-no.txt");

      assertFalse("Input two does not percolate", percolation.percolates());
      assertTrue("Has two open sites", percolation.numberOfOpenSites() == 2);
    }

    @Test public void testWithInputTwoDoesPercolate() {
      Percolation percolation = runIntegrationTest("src/test/java/test-data/input2.txt");

      assertTrue("Input two does not percolate", percolation.percolates());
      assertTrue("Has two open sites", percolation.numberOfOpenSites() == 3);
    }

    @Test public void testWithInputThreeDoesPercolate() {
      Percolation percolation = runIntegrationTest("src/test/java/test-data/input3.txt");

      assertTrue("Input three does percolate", percolation.percolates());
      assertTrue("Has six open sites", percolation.numberOfOpenSites() == 6);
    }

    @Test public void testWithInputTenDoesNotPercolate() {
      Percolation percolation = runIntegrationTest("src/test/java/test-data/input10-no.txt");

      assertFalse("Input ten does not percolate", percolation.percolates());
      assertTrue("Has six open sites", percolation.numberOfOpenSites() == 55);
    }

    private Percolation runIntegrationTest(String file) {
      In in = new In(file);
      int n = in.readInt();
      Percolation percolation = new Percolation(n);
      while (!in.isEmpty()) {
          int row = in.readInt();
          int col = in.readInt();
          percolation.open(row, col);
      }
      return percolation;
    }
}
