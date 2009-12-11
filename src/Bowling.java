import java.util.ArrayList;
import java.util.List;

public class Bowling {
	private List<Integer> rolls = new ArrayList<Integer>();

	public void roll(int i) {
		rolls.add(i);
	}

	public int score() {
		Integer score = 0;
		for (int i = 1; i <= 10; i++) {
			score += frameScore(i);
		}
		return score;
	}

	private int frameScore(int i) {
		int frameIndex = (i - 1) * 2;
		Integer slot1 = getHits(frameIndex);
		Integer slot2 = getHits(frameIndex + 1);

		int frameScore = slot1 + slot2;
		if (frameScore == 10) {
			frameScore += getHits(frameIndex + 2);
		}
		return frameScore;
	}

	private Integer getHits(int index) {
		if (rolls.size() > index)
			return rolls.get(index);
		else
			return 0;
	}

}
