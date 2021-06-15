import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
	ImageIcon TitleIcon = new ImageIcon("titleicon.jpg");

	GameFrame() {
		this.add(new GamePanel());
		this.setTitle("Java Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setIconImage(TitleIcon.getImage());
		this.setLocationRelativeTo(null);
		this.setVisible(true);	

	}
}
