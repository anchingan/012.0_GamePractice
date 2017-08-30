
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;


public class CAirCraft {
	BufferedImage img;
	public int x, y;
	int dir;
	
	public CAirCraft() {
		try {
			img = ImageIO.read(getClass().getResource("airplane1.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		x = 350;
		y = 500;
	}
	
	public void changeDir(int x) {
		if (this.x > x)
			dir = 1;
		else
			dir = 0;
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	public void move() {
		if (dir == 0)
			this.x += 16;
		else
			this.x -= 16;
	}
	
}
