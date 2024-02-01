public class MineFieldTester {
   public static void main(String[] args) {
      boolean[][] mineData1 = {
         { false, false, false, true },
         { false, true, false, false },
         { true, false, false, false },
         { false, true, true, false },
         { true, true, false, true }
      };

      MineField field1 = new MineField(mineData1);
      fieldBasics(field1);

      // System.out.println("Test inRange: ");
      // System.out.println("Expected false: " + field1.inRange(-1, 3));
      System.out.println("Test mines detection");
      System.out.println("Expected 0: " + field1.numAdjacentMines(0, 3));
      System.out.println("Expected 1: " + field1.numAdjacentMines(1, 1));
      System.out.println("Expected 2: " + field1.numAdjacentMines(2, 0));
      System.out.println("Expected 4: " + field1.numAdjacentMines(3, 1));
      System.out.println("Expected 3: " + field1.numAdjacentMines(3, 2));
      System.out.println("Expected 2: " + field1.numAdjacentMines(4, 0));
      System.out.println("Expected 3: " + field1.numAdjacentMines(4, 1));
      System.out.println("Expected 1: " + field1.numAdjacentMines(4, 3));

      boolean[][] mineData2 = {
         { false, false, true},
         { false, true, false},
         { true, false, false }
      };
      MineField field2 = new MineField(mineData2);
      fieldBasics(field2);
      System.out.println("Test mines detection");
      System.out.println("Expected 1: " + field2.numAdjacentMines(0, 0));
      System.out.println("Expected 1: " + field2.numAdjacentMines(0, 2));
      System.out.println("Expected 2: " + field2.numAdjacentMines(1, 1));
      System.out.println("Expected 1: " + field2.numAdjacentMines(2, 0));
      System.out.println("Expected 2: " + field2.numAdjacentMines(2, 1));

   }
   
   private static void fieldBasics(MineField field) {
      int rows = field.numRows();
      int cols = field.numCols();
      int nummines = field.numMines();
      System.out.println(
         "The field has " + rows + " rows, " + cols + " columns and "
         + nummines + " mines."
      );
   }
}
