import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
	private Bowling b;

	@Before
	public void setup() {
		b = new Bowling();
	}

	@Test
	public void shouldCountStandardHits() throws Exception {
		b.hit(4);
		b.hit(3);
		b.hit(2);
		assertScore(9);
	}

	@Test
	public void shouldCountOtherStandardHits() throws Exception {
		b.hit(1);
		b.hit(5);
		assertScore(6);
	}

	@Test
	public void shouldCountHitAfterSpareTwoTimes() throws Exception {
		hitMultiple(5, 5);
		assertScore(35);
	}

	@Test
	public void shouldCountTwoHitsAfterStrikeTwice() throws Exception {
		b.hit(10);
		b.hit(4);
		b.hit(1);
		b.hit(10);
		b.hit(2);
		b.hit(3);
		assertScore(40);
	}
	
	@Test
	public void shouldHandleOnlySpares() throws Exception {
		hitMultiple(5, 21);
		assertScore(150);
	}
	
	@Test
	public void shouldHandleOnlyStrikes() throws Exception {
		hitMultiple(10, 12);
		assertScore(300);
	}

	private void assertScore(int i) {
		assertEquals(i, b.score());
	}

	private void hitMultiple(int pins, int count) {
		for (int i = 0; i < count; i++) {
			b.hit(pins);
		}
	}
}
