import java.util.Objects;

class Point {

	public static final Point EMPTY = new Point(0);
	private final int value;

	public Point(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point point = (Point) o;
		return value == point.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	public int value() {
		return value;
	}

	public boolean isEmpty() {
		return EMPTY.equals(this);
	}
}
