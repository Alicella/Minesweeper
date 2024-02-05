// CS 455 PA3
// Fall 2022

import java.util.Arrays;
import java.util.Random;


/**
 * MineField
 * class with locations of mines for a game.
 * This class is mutable, because we sometimes need to change it once it's created.
 * mutators: populateMineField, resetEmpty
 * includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {

   private boolean[][] mineField;
   private int totalMines;

   /**
    * Create a minefield with same dimensions as the given array, and populate it with the mines in the array
    * such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
    * this minefield corresponds to the number of 'true' values in mineData.
    *
    * @param mineData the data for the mines; must have at least one row and one col,
    *                 and must be rectangular (i.e., every row is the same length)
    */
   public MineField(boolean[][] mineData) {

      mineField = new boolean[mineData.length][];

      for (int i = 0; i < mineData.length; i++) {
         mineField[i] = Arrays.copyOf(mineData[i], mineData[i].length);
      }

      for (int i = 0; i < numRows(); i++) {
         for (int j = 0; j < numCols(); j++) {
            if (mineField[i][j]) {
               totalMines++;
            }
         }
      }

   }


   /**
    * Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once
    * populateMineField is called on this object).  Until populateMineField is called on such a MineField,
    * numMines() will not correspond to the number of mines currently in the MineField.
    *
    * @param numRows  number of rows this minefield will have, must be positive
    * @param numCols  number of columns this minefield will have, must be positive
    * @param numMines number of mines this minefield will have,  once we populate it.
    *                 PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations).
    */
   public MineField(int numRows, int numCols, int numMines) {
      mineField = new boolean[numRows][numCols];
      totalMines = numMines;
      
   }


   /**
    * Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
    * ensuring that no mine is placed at (row, col).
    *
    * @param row the row of the location to avoid placing a mine
    * @param col the column of the location to avoid placing a mine
    *            PRE: inRange(row, col) and numMines() < (1/3 * numRows() * numCols())
    */
   public void populateMineField(int row, int col) {
      resetEmpty();
      
      int currNumMines = 0;
      Random generator = new Random();

      // when not enough mines are populated and the random position is not the start position and there isn't already a mine
      // at the position, put a mine there
      while (currNumMines < numMines()) {
         int newRow = generator.nextInt(numRows());
         int newCol = generator.nextInt(numCols());

         if (!(newRow == row && newCol == col) && !mineField[newRow][newCol]) {
            mineField[newRow][newCol] = true;
            currNumMines++;
         }
      }
   }


   /**
    * Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
    * Thus, after this call, the actual number of mines in the minefield does not match numMines().
    * Note: This is the state a minefield created with the three-arg constructor is in
    * at the beginning of a game.
    */
   public void resetEmpty() {
      for (int i = 0; i < numRows(); i++) {
         for (int j = 0; j < numCols(); j++) {
            mineField[i][j] = false;
         }
      }
   }


   /**
    * Returns the number of mines adjacent to the specified mine location (not counting a possible
    * mine at (row, col) itself).
    * Diagonals are also considered adjacent, so the return value will be in the range [0,8]
    *
    * @param row row of the location to check
    * @param col column of the location to check
    * @return the number of mines adjacent to the square at (row, col)
    * PRE: inRange(row, col)
    */
   public int numAdjacentMines(int row, int col) {
      int total = 0;
      if (inRange(row - 1, col) && mineField[row - 1][col]) {
         total++;
      }

      if (inRange(row + 1, col) && mineField[row + 1][col]) {
         total++;
      }

      if (inRange(row, col - 1) && mineField[row][col - 1]) {
         total++;
      }

      if (inRange(row, col + 1) && mineField[row][col + 1]) {
         total++;
      }

      if (inRange(row - 1, col - 1) && mineField[row - 1][col - 1]) {
         total++;
      }

      if (inRange(row - 1, col + 1) && mineField[row - 1][col + 1]) {
         total++;
      }

      if (inRange(row + 1, col - 1) && mineField[row + 1][col - 1]) {
         total++;
      }

      if (inRange(row + 1, col + 1) && mineField[row + 1][col + 1]) {
         total++;
      }

      return total;
   }


   /**
    * Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
    * start from 0.
    *
    * @param row row of the location to consider
    * @param col column of the location to consider
    * @return whether (row, col) is a valid field location
    */
   public boolean inRange(int row, int col) {
      if (row >= 0 && row < numRows() && col >= 0 && col < numCols()) {
         return true;
      }

      return false;

   }


   /**
    * Returns the number of rows in the field.
    *
    * @return number of rows in the field
    */
   public int numRows() {
      return mineField.length;
   }


   /**
    * Returns the number of columns in the field.
    *
    * @return number of columns in the field
    */
   public int numCols() {
      return mineField[0].length;
   }


   /**
    * Returns whether there is a mine in this square
    *
    * @param row row of the location to check
    * @param col column of the location to check
    * @return whether there is a mine in this square
    * PRE: inRange(row, col)
    */
   public boolean hasMine(int row, int col) {
      return mineField[row][col];
   }


   /**
    * Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
    * sometime this value does not match the actual number of mines currently on the field.  See doc for that
    * constructor, resetEmpty, and populateMineField for more details.
    *
    * @return the actual number of mines in the field
    */
   public int numMines() {
      return totalMines;
   }

}

