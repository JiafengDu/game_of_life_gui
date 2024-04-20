public class Controller {
  private Model model;
  private View view;

  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;
  }

  public void setUserInputSize(int userInputSize) {
    model.newBoard(model.sizeOfBoard(userInputSize));
  }
}
