import java.awt.event.*;

public class FecharFormAction extends WindowAdapter {
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }
}