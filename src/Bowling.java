public class Bowling {

	private int score = 0;
	private int frameCount = 1;
	private int frameScore = 0;
	private int multiplier = 1;
	private int nextMultiplier = 1;
	private int currentFrame = 1;

	public void hit(int i) {
		addScore(i);
		frameHit(i);
		shiftMultiplier();
		calculateBonus(i);
	}

	private void shiftMultiplier() {
		multiplier = nextMultiplier;
		nextMultiplier = 1;
	}

	private void addScore(int i) {
		this.score += i * multiplier;
	}

	private void calculateBonus(int i) {
		if (i == 10 && currentFrame < 10) {
			// strike
			multiplier++;
			nextMultiplier++;
			newFrame();
		} else if (frameScore == 10 && currentFrame < 10) {
			// spare
			multiplier++;
			newFrame();
		}
	}

	private void frameHit(int i) {
		if (frameCount < 3) {
			frameCount += 1;
			frameScore += i;
		} else {
			newFrame();
		}
	}

	private void newFrame() {
		frameCount = 1;
		frameScore = 0;
		currentFrame++;
	}

	public int score() {
		return score;
	}
}
