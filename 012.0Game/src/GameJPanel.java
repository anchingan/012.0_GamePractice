import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.*;

public class GameJPanel extends JPanel {
	CAirCraft ac;
	ArrayList<CEnemy> cm;
	
	public GameJPanel() {
		ac = new CAirCraft();
		cm = new ArrayList();
		
		this.addMouseListener(new CMyListener1());
		this.addMouseMotionListener(new CMyListener1());
		
		Timer t1 = new Timer(100,
				new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ac.move();
						if (Math.random() > 0.8 && cm.size() < 11) {
							CEnemy c = new CEnemy ((int)(Math.random() * 600), 0, ((int)Math.random() * 10) - 5);
							cm.add(c);
						}
						for (int i = 0; i < cm.size(); i++) {
							if (cm.get(i).move() == false)
								cm.remove(i);
							else
								;
						}
					}
				});
		t1.start();
	}
	
/*	public void paintComponent(Graphics g) {
		
		try {
			g.drawImage(ImageIO.read(getClass().getResource("airplane1.png")), x, y, 250, 250, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/	

	
	class CMyListener1 extends MouseAdapter {
		public void mouseMoved(MouseEvent e) {
			ac.changeDir(e.getX());
		}
	}
	
	@Override
	public void paint(Graphics g) {
		ac.paint(g);
		for (int i = 0; i < cm.size(); i++) {
			cm.get(i).paint(g);
		}
	}

}
