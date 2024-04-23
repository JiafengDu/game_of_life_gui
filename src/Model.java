public class Model {

  // userInput: N * N;
  // If user input >=10;
  public int[][] initialBoard(int userInputSize) {
    return new int[userInputSize][userInputSize];
  }

  // The method to update the new board according to the role;
  public void newBoard(int[][] initialBoard) {
    // the array to be added for check the 8 cell around the specific cell.
    int[] checkArray = {-1, 0, 1};

    int rows = initialBoard.length;
    int cols = initialBoard[0].length;

    // make a 2D copyArray to keep the original initialBoard;
    int[][] copy = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int i1 = 0; i1 < cols; i1++) {
        copy[i][i1] = initialBoard[i][i1];
      }
    }

    // update the initialBoard;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {

        // go through the 8 cell around the specific cell.
        int oneAroundIt = 0;
        for (int i2 = 0; i2 < 3; i2++) {
          for (int i3 = 0; i3 < 3; i3++) {
            int r = row + checkArray[i2];
            int c = col + checkArray[i3];

            // count how many one around it.
            if (r >= 0 && r < rows && c >= 0 && c < cols && copy[r][c] == 1) {
              oneAroundIt++;
            }
          }
        }

        // don't add this specific cell if it's 1.
        if (copy[row][col] == 1) {
          oneAroundIt--;

          // 2. A creature that has more than 3 neighbors will die of overcrowding. Its cell will be
          // empty in the next generation.
          // 3. A creature that has less than 2 neighbors will die of loneliness.
          if (oneAroundIt > 3 || oneAroundIt < 2) {
            initialBoard[row][col] = 0;
          }

          // 4. A new creature born in an empty cell that has exactly 3 neighbors.
        } else if (oneAroundIt == 3) {
          initialBoard[row][col] = 1;
        }
      }
    }
  }
}
