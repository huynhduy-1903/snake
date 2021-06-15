public class Snake {
	private int bodyparts;
	private Point[] point;
	private char direction;

	public Snake() {
		bodyparts = 3;
		direction = 'R';
		point = new Point[Static_Value.getGAME_UNIT()];
		for (int i = 0; i < Static_Value.getGAME_UNIT(); i++) {
			point[i] = new Point(0, 0);
		}

		point[0].setX(80);
		point[0].setY(40);

		point[1].setX(60);
		point[1].setY(40);

		point[2].setX(40);
		point[2].setY(40);

	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getBodyparts() {
		return bodyparts;
	}

	public void setBodyparts(int bodyparts) {
		this.bodyparts = bodyparts;
	}

	public Point getPoint(int i) {
		return point[i];
	}

	public void setPoint(int i, Point point) {
		this.point[i].setX(point.getX());
		this.point[i].setY(point.getY());
	}
	@Override
	public String toString() {
		return	(bodyparts-3)+"";
	}
}
