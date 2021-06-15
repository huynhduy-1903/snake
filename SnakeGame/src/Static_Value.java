public class Static_Value {
	private static int SCREEN_WIDTH = 800;
	private static int SCREEN_HEIGHT = 700;
	private static int UNIT = 20;
	private static int GAME_UNIT = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT;
	private static int level;

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int level) {
		Static_Value.level = level;
	}

	public static int getGAME_UNIT() {
		return GAME_UNIT;
	}

	public static void setGAME_UNIT(int gAME_UNIT) {
		GAME_UNIT = gAME_UNIT;
	}

	public static int getUNIT() {
		return UNIT;
	}

	public static void setUNIT(int uNIT) {
		UNIT = uNIT;
	}

	public static int getSCREEN_WIDTH() {
		return SCREEN_WIDTH;
	}

	public static void setSCREEN_WIDTH(int sCREEN_WIDTH) {
		SCREEN_WIDTH = sCREEN_WIDTH;
	}

	public static int getSCREEN_HEIGHT() {
		return SCREEN_HEIGHT;
	}

	public static void setSCREEN_HEIGHT(int sCREEN_HEIGHT) {
		SCREEN_HEIGHT = sCREEN_HEIGHT;
	}
}