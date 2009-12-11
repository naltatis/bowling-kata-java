import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
	private Bowling bowling;

	@Before
	public void setup() {
		bowling = new Bowling();
	}

	@Test
	public void shouldScore0IfNoRollWasDone() throws Exception {
		assertScore(0);
	}

	@Test
	public void shouldScore0IfAllRollsAre0() throws Exception {
		rollMultiple(3, 0);
		assertScore(0);
	}

	@Test
	public void shouldAddUpHitsOfMultipleFrames() throws Exception {
		roll(4);
		roll(2);
		roll(8);
		roll(1);
		assertScore(15);
	}
	
	@Test
	public void shouldDoubleHitAfterSpare() throws Exception {
		roll(3);
		roll(7);
		roll(7);
		roll(1);
		assertScore(25);
	}

	private void rollMultiple(int times, int hits) {
		for (int i = 0; i < times; i++) {
			roll(hits);
		}
	}

	private void roll(int i) {
		bowling.roll(i);
	}

	private void assertScore(int i) {
		assertEquals(i, bowling.score());
	}
}
