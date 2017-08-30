import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CEnemy {
	BufferedImage img;
	private int x, y, d;
	
	public CEnemy(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
		
		try {
			img = ImageIO.read(getClass().getResource("enemy1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	public boolean move() {
		y += 16;
		x += d;
		if (y > 50)
			return false;
		return true;
	}

}
