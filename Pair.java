import java.util.ArrayList;
import java.util.Objects;

class Pair {
	private final int x;
	private final int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
		if (x < 0 || y < 0) {
			throw new CannotCreatePairException();
		}
	}

	private Pair(int x, int y, int max) {
		this(x, y);
		if (x >= max || y >= max) {
			throw new CannotCreatePairException();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pair pair = (Pair) o;
		return x == pair.x &&
				y == pair.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public ArrayList<Pair> getNeighborhood(int maxX, int maxY) {
		ArrayList<Pair> neightborhood = new ArrayList<Pair>();
		for (int i = x - 1; i <= x + 1; i++) {
			for (int k = y - 1; k <= y + 1; k++) {
				if (canCreate(i, k, maxX, maxY)) {
					neightborhood.add(new Pair(i, k));
				}
			}
		}
		return neightborhood;
	}

	private boolean canCreate(int x, int y, int maxX, int maxY) {
		return x >= 0  && y >= 0 && x < maxX && y < maxY && !(x == this.x && y == this.y);
	}
}
