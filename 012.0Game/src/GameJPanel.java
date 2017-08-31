import java.applet.Applet;
import java.applet.AudioClip;
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
	ArrayList<CBoom> bm;
	int sx, sy;
	AudioClip clip; 
	
	public GameJPanel() {
		ac = new CAirCraft();
		cm = new ArrayList<CEnemy>();
		bm = new ArrayList<CBoom>();
		sx = 0;
		sy = 0;
		
		this.addMouseListener(new CMyListener1());
		this.addMouseMotionListener(new CMyListener1());
		try {
			clip = Applet.newAudioClip(getClass().getResource("bomb.wav"));
		}
		catch (Exception e) {
			
		}
		
		
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
							else {
								if (ac.checkAttack(cm.get(i)))
									System.exit(0);
							}
						}
						for (int i = 0; i < bm.size(); i++) {
							if (bm.get(i).move() == false)
								bm.remove(i);
							else {
								if (bm.get(i).state == 0) {
									for (int j = 0; j < cm.size(); j++) {
										if (bm.get(i).checkAttack(cm.get(j))) {
											cm.remove(j);
											break;
										}
									}
								}
							}
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
		
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				sx = ac.x + 5;
				sy = ac.y - 10;
				bm.add(new CBoom(sx, sy));
				clip.play();
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		ac.paint(g);
		for (int i = 0; i < cm.size(); i++) 
			cm.get(i).paint(g);
		for (int i = 0; i < bm.size(); i++) 
			bm.get(i).paint(g);
	}

}
