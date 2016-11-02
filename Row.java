import java.util.ArrayList;

class Row {
	private final ArrayList<Point> elements;

	public Row(int rowSize) {
		this.elements = new ArrayList<>(rowSize);
	}

	public void add(Point point) {
		elements.add(point);
	}

	public int size() {
		return elements.size();
	}

	public Row createEmptyRow() {
		int size = elements.size();
		Row row = new Row(size);
		for (int i = 0; i < size; i++) {
			row.add(Point.EMPTY);
		}
		return row;
	}

	public void extend() {
		elements.add(0, Point.EMPTY);
		elements.add(Point.EMPTY);
	}

	public boolean isEmpty() {
		return elements.stream().allMatch(element -> element.isEmpty());
	}

	public void removeFirst() {
		if (elements.isEmpty()) {
			return;
		}
		elements.remove(0);
	}

	public boolean beginsWithEmpty() {
		if (elements.isEmpty()) {
			return false;
		}
		return Point.EMPTY.equals(elements.get(0));
	}

	public void removeLast() {
		elements.remove(elements.size() - 1);
	}

	public boolean endsWithEmpty() {
		if (elements.isEmpty()) {
			return false;
		}
		return Point.EMPTY.equals(elements.get(elements.size() - 1));
	}

	public int[] toArray() {
		int [] a = new int[elements.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = elements.get(i).value();
		}
		return a;
	}

	public int get(int k) {
		return elements.get(k).value();
	}

	@Override
	public String toString() {
		String ret = "";
		for (Point element : elements) {
			ret += element.value();
		}

		return ret;
	}
}
