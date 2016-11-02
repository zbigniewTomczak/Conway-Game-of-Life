public class ConwayLife {
	public static int[][] getGeneration(int[][] cells, int generations) {
		Plane plane = new Plane(cells);
		for (int i = 0; i < generations; i++) {
			plane = plane.liveOneTurn();
		}
		Plane evolvedTrimmedPlane = plane.trim();
//		System.out.println(evolvedTrimmedPlane);
		return evolvedTrimmedPlane.toCells();
	}

	static int getGameResult(int aliveInNeighborhood, int cellValue) {
		if (aliveInNeighborhood == 3) {
			return 1;
		}
		if (cellValue == 1 && aliveInNeighborhood == 2) {
			return 1;
		} else {
			return 0;
		}
	}
}
