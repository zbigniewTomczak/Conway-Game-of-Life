import java.util.ArrayList;
import java.util.List;

class Plane {

	private int hSize;
	private List<Row> rows = new ArrayList<Row>();

	public Plane(int[][] cells) {
		int vSize = cells.length;
		copyPlane(cells, vSize);
		extendPlane();

		allRowsHaveSameLength();
	}

	private void extendPlane() {
		if (rows.isEmpty()) {
			return;
		}
		extendEachRow();
		rows.add(0, rows.get(0).createEmptyRow());
		rows.add(rows.get(0).createEmptyRow());
	}

	private void extendEachRow() {
		for (Row row : rows) {
			row.extend();
		}
	}

	private void copyPlane(int[][] cells, int vSize) {
		for (int i = 0; i < vSize; i++) {
			int[] inputRow = cells[i];
			hSize = inputRow.length;
			Row row = new Row(hSize);
			rows.add(row);
			for (int j = 0; j < hSize; j++) {
				Point point = new Point(cells[i][j]);
				row.add(point);
			}
		}
	}

	private void allRowsHaveSameLength() {
		if (rows.isEmpty()) {
			return;
		}
		int rowSize = rows.get(0).size();
		for (Row row : rows) {
			if (row.size() != rowSize) {
				throw new RuntimeException("Rows not equal size");
			}
		}

	}

	public Plane liveOneTurn() {
		int[][] ret = this.toCells();
		for (int i = 0; i < rows.size(); i++) {
			Row row = rows.get(i);
			for (int k = 0; k < row.size(); k++) {
				Pair starting = new Pair(i, k);
				ArrayList<Pair> neighborhood = starting.getNeighborhood(rows.size(), row.size());
				int aliveInNeighborhood = countAliveInNeighborhood(neighborhood);
				ret[i][k] = ConwayLife.getGameResult(aliveInNeighborhood, row.get(k));
			}
		}

		return new Plane(ret);
	}

	private int countAliveInNeighborhood(ArrayList<Pair> neighborhood) {
		int sum = 0;
		for (Pair pair : neighborhood) {
			sum += rows.get(pair.getX()).get(pair.getY());
		}

		return sum;
	}

	public int[][] toCells() {
		int [][] array = new int[rows.size()][hSize];
		for (int i = 0; i < array.length; i++) {
			array[i] = rows.get(i).toArray();
		}
		return array;
	}

	public Plane trim() {
		trimBegin();
		trimEnd();
		trimBeginCol();
		trimEndCol();
		return this;
	}

	private void trimBeginCol() {
		for (int i = 0; i < hSize; i++) {
			if (allBeginColEmpty()) {
				rows.stream().forEach(row -> row.removeFirst());
			} else {
				break;
			}
		}
		updateHSize();
	}

	private void trimEndCol() {
		for (int i = 0; i < hSize; i++) {
			if (allEndColEmpty()) {
				rows.stream().forEach(row -> row.removeLast());
			} else {
				break;
			}
		}
		updateHSize();
	}

	private void updateHSize() {
		if (rows.isEmpty()) {
			hSize = 0;
		}
		hSize = rows.get(0).size();
		allRowsHaveSameLength();
	}

	private boolean allEndColEmpty() {
		return rows.stream().allMatch(row -> row.endsWithEmpty());
	}

	private boolean allBeginColEmpty() {
		return rows.stream().allMatch(row -> row.beginsWithEmpty());
	}

	private void trimEnd() {
		int initialSize = rows.size();
		for (int i = 0; i < initialSize; i++) {
			if (rows.get(rows.size()-1).isEmpty()) {
				rows.remove(rows.size()-1);
			} else {
				break;
			}
		}
	}

	private void trimBegin() {
		int initialSize = rows.size();
		for (int i = 0; i < initialSize; i++) {
			if (rows.get(0).isEmpty()) {
				rows.remove(0);
			} else {
				break;
			}
		}
	}

	@Override
	public String toString() {
		String out = "";
		for (Row row : rows) {
			out += row + "\n";
		}

		return out;
	}
}
