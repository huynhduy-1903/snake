import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Point food = new Point(0, 0);
	Random random = new Random();
	Timer timer;
	boolean running = true;
	Snake sn;
	int[] locationfoodx = { 0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360,
			380, 400, 420, 440, 460, 480, 500, 520, 540, 560, 580, 600, 620, 640, 660, 680, 700, 720, 740, 760, 780,
			800 };
	int[] locationfoody = { 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400,
			420, 440, 460, 480, 500, 520, 540, 560, 580, 600, 620, 640, 660, 680, 700 };
	ImageIcon background;
	Menu1 menu = new Menu1();

	public static enum State {
		GAME, MENU
	};

	public static State state = State.MENU;

	GamePanel() {
		this.setPreferredSize(new Dimension(Static_Value.getSCREEN_WIDTH(), Static_Value.getSCREEN_HEIGHT()));
		this.setBackground(Color.black);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.addMouseListener(new Mouselistener());
		Start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		background = new ImageIcon(new ImageIcon("background.PNG").getImage().getScaledInstance(
				Static_Value.getSCREEN_WIDTH(), Static_Value.getSCREEN_HEIGHT(), Image.SCALE_DEFAULT));
		background.paintIcon(this, g, 0, 0);
		if (state == State.GAME) {

			if (running) {

				g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
				g.fillOval(food.getX(), food.getY(), Static_Value.getUNIT(), Static_Value.getUNIT());

				for (int i = 0; i < sn.getBodyparts(); i++) {
					if (i == 0) {
						g.setColor(Color.red);
						g.fillRect(sn.getPoint(i).getX(), sn.getPoint(i).getY(), Static_Value.getUNIT(),
								Static_Value.getUNIT());
					} else {
						g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
						g.fillRect(sn.getPoint(i).getX(), sn.getPoint(i).getY(), Static_Value.getUNIT(),
								Static_Value.getUNIT());
					}
				}

				g.setColor(new Color(191, 218, 249));
				g.fillRect(0, 0, Static_Value.getSCREEN_WIDTH(), 40);

				g.setColor(Color.black);
				g.setFont(new Font("MV Boli", Font.BOLD, 25));
				g.drawString("Score : " + (sn.getBodyparts() - 3), 350, 30);
				g.setFont(new Font("MV Boli", Font.BOLD, 15));
				g.drawString("Press Esc to pause", 600, 20);
				g.drawString("Press Space to continue", 600, 35);
			} else {
				g.setColor(Color.white);
				g.setFont(new Font("MV Boli", Font.BOLD, 100));
				g.drawString("Game Over", 115, 300);
				g.setFont(new Font("MV Boli", Font.BOLD, 50));
				g.drawString("Score : " + (sn.getBodyparts() - 3), 265, 400);
				g.setFont(new Font("MV Boli", Font.BOLD, 30));
				g.drawString("Press Space to restart", 220, 500);
			}
		} else if (state == State.MENU) {
			menu.paint(g);
		}
	}

	public void Start() {

			sn = new Snake();
			running = true;
			if (running) {
				NewFood();
				timer = new Timer(100, this);
				timer.start();
			}
	}

	public void NewFood() {
		food.setX(locationfoodx[random.nextInt(40)]);
		food.setY(locationfoody[random.nextInt(33)]);
	}

	public void Eatting() {
		if (sn.getPoint(0).getX() == food.getX() && sn.getPoint(0).getY() == food.getY()) {
			sn.setBodyparts(sn.getBodyparts() + 1);
			NewFood();
		}
	}

	public void CheckCollision() {
		for (int i = sn.getBodyparts(); i > 0; i--) {
			if (sn.getPoint(0).getX() == sn.getPoint(i).getX() && sn.getPoint(0).getY() == sn.getPoint(i).getY()) {
				running = false;
				timer.stop();
			}
		}
		if (sn.getPoint(0).getX() < 0) {
			running = false;
			timer.stop();
		}
		if (sn.getPoint(0).getX() > Static_Value.getSCREEN_WIDTH()) {
			running = false;
			timer.stop();
		}
		if (sn.getPoint(0).getY() < 40) {
			running = false;
			timer.stop();
		}
		if (sn.getPoint(0).getY() > Static_Value.getSCREEN_HEIGHT()) {
			running = false;
			timer.stop();
		}
	}

	public void Move() {
		Point p = new Point(0, 0);
		for (int i = sn.getBodyparts(); i > 0; i--) {
			p = sn.getPoint(i - 1);
			sn.setPoint(i, p);
		}
		switch (sn.getDirection()) {
		case 'R':
			p.setX(sn.getPoint(0).getX() + Static_Value.getUNIT());
			p.setY(sn.getPoint(0).getY());
			sn.setPoint(0, p);
			break;
		case 'L':
			p.setX(sn.getPoint(0).getX() - Static_Value.getUNIT());
			p.setY(sn.getPoint(0).getY());
			sn.setPoint(0, p);
			break;
		case 'U':
			p.setX(sn.getPoint(0).getX());
			p.setY(sn.getPoint(0).getY() - Static_Value.getUNIT());
			sn.setPoint(0, p);
			break;
		case 'D':
			p.setX(sn.getPoint(0).getX());
			p.setY(sn.getPoint(0).getY() + Static_Value.getUNIT());
			sn.setPoint(0, p);
			break;
		}
	}

	public void HighScore() throws IOException {
		int score = 0;
		try {
			Scanner scanner = new Scanner(new FileInputStream("highscore.txt"));
			while (scanner.hasNextInt()) {
				score = scanner.nextInt();
				if (sn.getBodyparts() - 3 > score) {
					FileOutputStream writer = new FileOutputStream("highscore.txt");
					String s = sn.toString();
					writer.write(s.getBytes());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (state == State.GAME) {
			if (running) {
				Move();
				Eatting();
				CheckCollision();
				try {
					HighScore();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (running == false) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				Start();
			}
		}
		if (state == State.GAME) {
			switch (e.getKeyCode()) {

			case KeyEvent.VK_DOWN:
				if (sn.getDirection() != 'U') {
					sn.setDirection('D');
				}
				break;
			case KeyEvent.VK_UP:
				if (sn.getDirection() != 'D') {
					sn.setDirection('U');
				}
				break;
			case KeyEvent.VK_LEFT:
				if (sn.getDirection() != 'R') {
					sn.setDirection('L');
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (sn.getDirection() != 'L') {
					sn.setDirection('R');
				}
				break;
			case KeyEvent.VK_ESCAPE:
				timer.stop();
				break;
			case KeyEvent.VK_SPACE:
				timer.start();
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
