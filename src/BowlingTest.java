import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
	private Bowling bowling;

	@Before
	public void setup() {
		bowling = new Bowling();
	}

	@Test
	public void shouldGetResults() throws Exception {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		lists.add(Arrays.asList(4, 4)); // one hit
		lists.add(Arrays.asList(1, 2, 7, 10)); // three hits
		lists.add(Arrays.asList(6, 4, 5, 20)); // spare
		lists.add(Arrays.asList(6, 4, 5, 5, 3, 31)); // multiple spares
		lists.add(Arrays.asList(10, 4, 5, 2, 30)); // strike
		lists.add(Arrays.asList(9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 90)); // 10x9
		lists.add(Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 150)); // 10 spares
		lists.add(Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 300)); // 12 strikes

		for (List<Integer> list : lists) {
			bowling = new Bowling();
			for (int i = 0; i < list.size() - 1; i++) {
				bowling.hit(list.get(i));
			}
			assertEquals((int) list.get(list.size() - 1), bowling.score());
		}
	}
}
