import org.junit.Assert;
import org.junit.Test;

public class PlaneTest {

	@Test
	public void trim_returns_samePlane() {
		// given
		int[][] central = {
				{0,0,0},
				{0,1,0},
				{0,0,0}};
		Plane p = new Plane(central);
		// when
		Plane trimed = p.trim();
		//then
		Assert.assertArrayEquals(new int[][]{{1}}, trimed.toCells());
	}

	@Test
	public void trim_hugevertical_trimmed() {
		// given
		int[][] input = {
				{0,0,0},
				{0,0,0},
				{0,0,0},
				{0,0,0},
				{0,0,0},
				{0,0,1},
				{0,1,0},
				{1,0,0},
				{0,0,0},
				{0,0,0},
				{0,0,0},
				{0,0,0},
				{0,0,0},
				{0,0,0},
				{0,0,0},
				{0,0,0}};
		int[][] expected = {
				{0,0,1},
				{0,1,0},
				{1,0,0}};
		Plane p = new Plane(input);
		// when
		Plane trimed = p.trim();
		//then
		Assert.assertArrayEquals(expected, trimed.toCells());
	}
}
