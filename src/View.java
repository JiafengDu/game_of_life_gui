import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class View extends JFrame implements ActionListener {
  private JLabel promptSize;
  private JTextField size;
  private JButton ok;
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
    promptSize = new JLabel("Please enter the size of the board(Integer and 1 is the minimum): ");
    add(promptSize);

    // user enter size of the board;
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

    // Add a "Start" button;
    start = new JButton("START!");
    start.addActionListener(this);
    buttonPanel.add(start);

    // Add a "Stop" button;
    stop = new JButton("STOP!");
    stop.addActionListener(this);
    buttonPanel.add(stop);
  }

  // The ok button is not working if it's empty, only blank, or not all digit;
  private void updateButtonState() {
    String input = size.getText().trim();
    boolean isValid = input.matches("\\d+");

    ok.setEnabled(!input.isEmpty() && isValid);
  }

  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();

    if (actionCommand.equals("OK")) {
      // input the size N from user to the grid, 1 is the minimum
      // need to change from string to integer;
      // size.getText().trim();
    }

    if (actionCommand.equals("START!")) {
      // make the grid to update again and again;
      // (Use the Thread.sleep() method to pause the program for a specified time.)
    }

    if (actionCommand.equals("STOP!")) {}
  }
}
