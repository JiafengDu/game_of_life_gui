import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    View view = new View();
    Model model = new Model();
    Controller controller = new Controller(model, view);
    view.setVisible(true); // Show the GUI;

    // pass the valid N user typed in after click "ok";
    controller.setUserInputSizeBoard(view.outputSize);
  }
}
