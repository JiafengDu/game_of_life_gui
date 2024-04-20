import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame implements ActionListener {
  private JButton start;
  private JButton stop;

  public View() {
    super("✨The Game Of Life✨");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(Color.LIGHT_GRAY);
    buttonPanel.setLayout(new FlowLayout());

    start = new JButton("START");
    start.addActionListener(this);
    buttonPanel.add(start);
  }

  public void actionPerformed(ActionEvent e){
    String actioncommand = e.getActionCommand();

//    if (actioncommand.equals("START")){
//      start = g
//    }
  }
}
