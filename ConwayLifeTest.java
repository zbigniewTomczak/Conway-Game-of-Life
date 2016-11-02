import org.junit.Assert;
import org.junit.Test;

public class ConwayLifeTest {
	@Test
	public void getGeneration_small_is() {
		// given
		int [][] expected = {
				{1,1},
				{1,1},
				};
		int[][] small = {
				{0,1},
				{1,1}};
		// when
		int[][] generation = ConwayLife.getGeneration(small, 1);
		//then
		Assert.assertArrayEquals(expected, generation);
	}


	@Test
	public void gameResult_OneAliveInNeightborhoodOfAlive_returnZero() {
		// given
		// when
		Assert.assertEquals(0, ConwayLife.getGameResult(1, 1));
		//then
	}
	@Test
	public void gameResult_ZeroAliveInNeightborhoodOfAlive_returnZero() {
		// given
		// when
		Assert.assertEquals(0, ConwayLife.getGameResult(0, 1));
		//then
	}
	@Test
	public void gameResult_TwoAliveInNeightborhoodOfAlive_returnOne() {
		// given
		// when
		Assert.assertEquals(1, ConwayLife.getGameResult(2, 1));
		//then
	}
	@Test
	public void gameResult_ThreeAliveInNeightborhoodOfAny_returnOne() {
		// given
		// when
		Assert.assertEquals(1, ConwayLife.getGameResult(3, 1));
		Assert.assertEquals(1, ConwayLife.getGameResult(3, 0));
		//then
	}
	@Test
	public void gameResult_FourOrMoreAliveInNeightborhood_returnZero() {
		// given
		// when
		Assert.assertEquals(0, ConwayLife.getGameResult(4, 1));
		Assert.assertEquals(0, ConwayLife.getGameResult(5, 1));
		Assert.assertEquals(0, ConwayLife.getGameResult(6, 1));
		Assert.assertEquals(0, ConwayLife.getGameResult(7, 1));
		Assert.assertEquals(0, ConwayLife.getGameResult(8, 1));
		//then
	}
	@Test
	public void getGeneration_glider_is() {
		// given
		int [][] expected = {
				{0,1,0},
				{0,0,1},
				{1,1,1}};
		int[][] glider =
				{{1,0,0},
				 {0,1,1},
				 {1,1,0}};
		// when
		int[][] generation = ConwayLife.getGeneration(glider, 1);
		//then
		Assert.assertArrayEquals(expected, generation);
	}

//@Ignore
@Test
	public void getGeneration_glider2_is() {
		// given
		int [][] expected = {
				{1,0,1},
				{0,1,1},
				{0,1,0}};
		int[][] glider = {
				{0,1,0},
				{0,0,1},
				{1,1,1}};
		// when
		int[][] generation = ConwayLife.getGeneration(glider, 1);
		//then
		Assert.assertArrayEquals(expected, generation);
	}

	@Test
	public void getGeneration_glider3_is() {
		// given
		int [][] expected = {
				{1,0,1},
				{0,1,1},
				{0,1,0}};
		int[][] glider =
				{{1,0,0},
						{0,1,1},
						{1,1,0}};
		// when
		int[][] generation = ConwayLife.getGeneration(glider, 2);
		//then
		Assert.assertArrayEquals(expected, generation);
	}

}
