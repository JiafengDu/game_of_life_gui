import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    View view = new View();
    Model model = new Model();
    Controller controller = new Controller(model, view);

    // User enter the size of the board;
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter the size of the board: ");
    int userInput = input.nextInt();
    controller.setUserInputSize(userInput);

    // Show the GUI;
    view.setVisible(true);
  }
}
