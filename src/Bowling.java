public class Bowling {

	private int score;
	private int multiplier = 1;
	private int frameScore = 0;
	private int frameHit = 0;
	private int nextMultiplier = 1;
	private int frameCount = 1;

	public void hit(int pins) {

		score += pins * multiplier;

		hitFrame(pins);
		shiftBonus();

		if (frameCount < 10) {
			handleBonus(pins);
		}

		if (frameHit == 2) {
			newFrame();
		}
	}

	private void shiftBonus() {
		multiplier = nextMultiplier;
		nextMultiplier = 1;
	}

	private void hitFrame(int pins) {
		frameHit++;
		frameScore += pins;
	}

	private void handleBonus(int i) {
		if (i == 10) {
			multiplier++;
			nextMultiplier++;
			newFrame();
		} else if (frameScore == 10) {
			multiplier++;
		}
	}

	private void newFrame() {
		frameHit = 0;
		frameScore = 0;
		frameCount++;
	}

	public int score() {
		return score;
	}

}
