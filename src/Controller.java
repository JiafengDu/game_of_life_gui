public class Controller {
  private Model model;
  private View view;

  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;
  }

  public void setUserInputSizeBoard(int userInputSize) {
    model.initialBoard(userInputSize);
  }

  // Update the board after the first initial board with all 0 in every grid.
  public void updateBoard(int[][] setUserInputSize) {
    model.newBoard(setUserInputSize);
  }
}
