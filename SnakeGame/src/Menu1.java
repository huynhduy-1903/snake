import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Menu1 extends JPanel{
	
	public Rectangle button = new Rectangle(Static_Value.getSCREEN_WIDTH() / 2 - 175, 260, 350, 100);
	ImageIcon background;
	int score = 0;
	public void paint(Graphics g) {
		super.paint(g);
		background = new ImageIcon(new ImageIcon("background.PNG").getImage().getScaledInstance(
				Static_Value.getSCREEN_WIDTH(), Static_Value.getSCREEN_HEIGHT(), Image.SCALE_DEFAULT));
		background.paintIcon(this, g, 0, 0);
		Graphics2D g2d = (Graphics2D) g;
			g.setColor(new Color(93, 239, 139));
			g.setFont(new Font("MV Boli", Font.BOLD, 80));

			g2d.fill(button);


			g.setColor(new Color(93, 239, 139));
			g.setFont(new Font("MV Boli", Font.BOLD, 100));
			g.drawString("Snake", Static_Value.getSCREEN_WIDTH() / 2 - 150, 200);

			g.setColor(new Color(92, 76, 210));
			g.setFont(new Font("MV Boli", Font.BOLD, 40));
			g.drawString("Play", Static_Value.getSCREEN_WIDTH() / 2 - 60, 330);
			try {
				Scanner scanner = new Scanner(new FileInputStream("highscore.txt"));
				while (scanner.hasNextInt()) {
					score = scanner.nextInt();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.setColor(new Color(93, 239, 139));
			g.drawString("Highest : " + score, Static_Value.getSCREEN_WIDTH() / 3 - 15, 450);
		}
}
