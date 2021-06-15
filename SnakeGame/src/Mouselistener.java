import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouselistener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int mousex = e.getX();
		int mousey = e.getY();
		if (mousex >= Static_Value.getSCREEN_WIDTH() / 2 - 175
				&& mousex <= Static_Value.getSCREEN_WIDTH() / 2 - 175 + 350) {
			if (mousey >= 225 && mousey <= 360) {
				GamePanel.state = GamePanel.State.GAME;
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
