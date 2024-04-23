import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class View extends JFrame implements ActionListener {
  private JLabel promptSize;

  JTextField size;
  private String input;
  int outputSize;
  JComboBox<String> initialState;
  JButton ok;
  private JButton start;
  private JButton stop;

  public View() {
    super("✨The Game Of Life✨");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //    setLayout(new BorderLayout());

    JPanel buttonPanel = new JPanel();
    setContentPane(buttonPanel);
    buttonPanel.setBackground(Color.LIGHT_GRAY);

    // Add a label to prompt enter reminder for user;
    promptSize = new JLabel("Please enter the size of the board(Integer and 10 is the minimum): ");
    add(promptSize);

    // user enter the size of the board;
    size = new JTextField(3);
    size.getDocument()
        .addDocumentListener(
            new DocumentListener() {
              @Override
              public void insertUpdate(DocumentEvent e) {
                updateButtonState();
              }

              @Override
              public void removeUpdate(DocumentEvent e) {
                updateButtonState();
              }

              @Override
              public void changedUpdate(DocumentEvent e) {
                updateButtonState();
              }
            });
    add(size);

    // A button for user to click to get the size for the board after they enter the number;
    // The ok button is not working if it's empty, only blank, or not all digit;
    ok = new JButton("OK");
    ok.setEnabled(false);
    ok.addActionListener(this);
    add(ok);

    // A button for user to select the initial state of the grid;
    initialState = new JComboBox<>();
    initialState.addItem("Glider");
    initialState.addItem("Spaceship");
    initialState.setEnabled(false);
    initialState.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (initialState.getSelectedIndex() == 0) {
              // 执行Glider的默认图示；
            }

            if (initialState.getSelectedIndex() == 1) {
              // 执行Spaceship的默认图示；
            }
          }
        });
    add(initialState);

    // Add a "Start" button;
    start = new JButton("START!");
    start.addActionListener(this);
    start.setEnabled(false);
    buttonPanel.add(start);

    // Add a "Stop" button;
    stop = new JButton("STOP!");
    stop.addActionListener(this);
    stop.setEnabled(false);
    buttonPanel.add(stop);
  }

  // The ok button is not working if it's empty, only blank, or not all digit or <10;
  private void updateButtonState() {
    input = size.getText().trim();
    boolean isValid = input.matches("\\d+");

    ok.setEnabled(!input.isEmpty() && isValid && equalBigger10());
  }

  // userInput: N * N;
  // If user input >=10 return true; <10, return false;
  public boolean equalBigger10() {
    return Integer.parseInt(input) >= 10;
  }

  // Actions for click every Jbutton;
  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();

    // input the size N from user to the grid, 10 is the minimum
    if (actionCommand.equals("OK")) {
      System.out.println(Integer.parseInt(input));
      outputSize = Integer.parseInt(input);

      // after the user click the ok, all this tree button will turn on;
      initialState.setEnabled(true);
      start.setEnabled(true);
      stop.setEnabled(true);
    }

    if (actionCommand.equals("START!")) {
      // make the grid to update again and again;
      // (Use the Thread.sleep() method to pause the program for a specified time.)
    }

    if (actionCommand.equals("STOP!")) {}
  }
}
