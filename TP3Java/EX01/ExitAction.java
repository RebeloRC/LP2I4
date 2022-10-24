/**
 * @author Rodrigo Rebelo e Luiz Gustavo
 */

package lp2i4_tp03;

import java.awt.event.*;

public class ExitAction extends WindowAdapter implements ActionListener {

	 public void windowClosing(WindowEvent e)
	    {
	        System.exit(0);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        System.exit(0);
	    }
}
