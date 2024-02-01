// Name: Angzhan He
// USC NetID: angzhanh
// CS 455 PA3
// Fall 2022


/**
 MineFieldTester
 A class used to test the instant variables and methods in the MineField Class
 */
public class MineFieldTester_cp {

   public static MineField testOneArgConstructor(boolean[][] mineData) {
      System.out.println("Test One-Arg Constructor");
      MineField mineField = new MineField(mineData);

      System.out.println("Expected:");
      System.out.println(expectedMines(mineData));

      System.out.println("Actual: ");
      System.out.println(mineField);

      System.out.println();
      return mineField;
   }

   public static MineField testThreeArgConstructor(int numRows, int numCols, int numMines) {
      System.out.println("Test Three-Arg Constructor");
      MineField mineField = new MineField(numRows, numCols, numMines);

      System.out.println("Expected:");
      System.out.println(expectedMines(new boolean[numRows][numCols]));

      System.out.println("Actual: ");
      System.out.println(mineField);

      System.out.println();
      return mineField;
   }

   public static void testGetNumRows(MineField mineField, int expectedNumRows) {
      System.out.println("Test numRows method");

      System.out.println("Expected:");
      System.out.println(expectedNumRows);

      System.out.println("Actual: ");
      System.out.println(mineField.numRows());

      System.out.println();
   }

   public static void testGetNumCols(MineField mineField, int expectedNumCols) {
      System.out.println("Test numCols method");

      System.out.println("Expected:");
      System.out.println(expectedNumCols);

      System.out.println("Actual: ");
      System.out.println(mineField.numCols());

      System.out.println();
   }

   public static void testGetNumMines(MineField mineField, int expectedNumMines) {
      System.out.println("Test numMines method");

      System.out.println("Expected:");
      System.out.println(expectedNumMines);

      System.out.println("Actual: ");
      System.out.println(mineField.numMines());

      System.out.println();
   }

   public static void testInRange(MineField mineField, int row, int col, int numRows, int numCols) {
      System.out.println("Test inRange method");

      System.out.println("Expected:");
      System.out.println((0 <= row && row < numRows) && (0 <= col && col < numCols));

      System.out.println("Actual: ");
      System.out.println(mineField.inRange(row, col));

      System.out.println();
   }

   public static void testResetEmpty(MineField mineField) {
      System.out.println("Test resetEmpty method");
      mineField.resetEmpty();

      System.out.println("Expected:");
      System.out.println(expectedMines(new boolean[mineField.numRows()][mineField.numCols()]));

      System.out.println("Actual: ");
      System.out.println(mineField);

      System.out.println();
   }

   public static void testPopulateMineField(MineField mineField, int row, int col) {
      System.out.println("Test populateMineField method");
      mineField.populateMineField(row, col);

      System.out.println("Actual: ");
      System.out.println(mineField);

      System.out.println();
   }

   public static void testNumAdjacentMines(MineField mineField, int row, int col) {
      System.out.println("Test numAdjacentMines method");

      System.out.println("Actual: ");
      System.out.println(mineField.numAdjacentMines(row, col));

      System.out.println();
   }

   private static String expectedMines(boolean[][] mineData) {
      StringBuilder display = new StringBuilder();
      for (boolean[] mineCol : mineData) {
         String prefix = "";
         for (boolean mine : mineCol) {
            display.append(prefix).append(mine);
            prefix = " ";
         }
         display.append("\n");
      }
      display.setLength(display.length() - 1);
      return display.toString();
   }

   public static void main(String[] args) {
      int numRows = 7;
      int numCols = 7;
      int numMines = 10;
      boolean[][] mineData = new boolean[][] {{true, false, false}, {false, true, false}, {false, false, false}};

      MineField mineField1 = MineFieldTester_cp.testOneArgConstructor(mineData);

      testGetNumRows(mineField1, numRows);
      testGetNumCols(mineField1, numCols);
      testGetNumMines(mineField1, numMines);

      testInRange(mineField1, 3, 1, numRows, numCols);

      testResetEmpty(mineField1);

      testPopulateMineField(mineField1, 1, 1);

      testNumAdjacentMines(mineField1, 0, 0);
      testNumAdjacentMines(mineField1, 1, 1);


      MineField mineField2 = testThreeArgConstructor(numRows, numCols, numMines);

      testGetNumRows(mineField2, numRows);
      testGetNumCols(mineField2, numCols);
      testGetNumMines(mineField2, numMines);

      testInRange(mineField2, 1, 1, numRows, numCols);

      testResetEmpty(mineField2);

      testPopulateMineField(mineField2, 1, 1);

      testNumAdjacentMines(mineField1, 2, 2);
      testNumAdjacentMines(mineField1, 1, 1);
   }
}
