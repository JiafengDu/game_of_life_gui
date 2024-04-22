import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    View view = new View();
    Model model = new Model();
    Controller controller = new Controller(model, view);
    view.setVisible(true);    // Show the GUI;

    System.out.print("Please enter the size of the board: ");
    // User enter the size of the board;
    Scanner input = new Scanner(System.in);
    int userInput = input.nextInt();

    controller.setUserInputSizeBoard(userInput);


  }
}