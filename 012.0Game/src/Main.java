import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;


public class Main {
	public static void main(String[] args) {
		final JFrame f = new JFrame();
		GameJPanel gm =new GameJPanel();
		f.setTitle("Airplane game");
		f.setSize(700, 650);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(gm);
		f.setVisible(true);
		
		Timer timer = new Timer(100,
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						f.repaint();
					}
				});
		timer.start();
		
	}

	

}
