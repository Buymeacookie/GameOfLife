package de.hska.iwii.i2.gol;

/**
 * Die eigentliche Spielelogik. Das Spielfeld wird hier nicht als zyklisch
 * geschlossen betrachtet wird.
 *
 * @author Niklas Kreutzarek
 */
public class GameOfLifeLogic {

	private boolean[][] generation;

	/**
	 * 
	 * @param generation
	 *            2D Matrix
	 */

	public void setStartGeneration(boolean[][] generation) {

		this.generation = generation;

	}

	/**
	 * Berechnet die nächste Generation.
	 * 
	 * 
	 */
	public void nextGeneration() {

		boolean[][] generationTemp = new boolean[generation.length][generation[0].length];

		for (int i = 0; i < generation.length; i++) {

			for (int j = 0; j < generation[0].length; j++) {

				generationTemp[i][j] = generation[i][j];
			}
		}
		for (int x = 0; x < generationTemp.length; x++) {
			for (int y = 0; y < generationTemp[x].length; y++) {

				int count = countNeighbours(x, y);

				if (generationTemp[x][y]) {

					if (!(count == 2 || count == 3)) {

						generationTemp[x][y] = false;

					}

				} else {

					if (count == 3) {

						generationTemp[x][y] = true;

					}

				}
			}
		}

		generation = generationTemp.clone();

	}

	/**
	 * Prüft ob eine Zelle lebend ist.
	 * 
	 * @param x
	 *            Reihe
	 * @param y
	 *            Spalte
	 * @return Gibt true(lebend) oder false(tot) zurück
	 */
	public boolean isCellAlive(int x, int y) {

		return generation[x][y];
	}

	/**
	 * Zählt die lebenden Nachbarn einer Zelle.
	 * 
	 * @param x
	 *            Reihe
	 * @param y
	 *            Spalte
	 * @return Gibt die anzahl der lebenden Nachbarn zurück.
	 */
	public int countNeighbours(int x, int y) {

		int count = 0;

		for (int i = x - 1; i <= x + 1; i++) {
			if ((i != -1) && (i < generation.length)) {

				for (int j = y - 1; j <= y + 1; j++) {

					if ((j != -1) && (j < generation[0].length)) {

						if (isCellAlive(i, j)) {

							count++;
							if ((i == x) && (j == y)) {

								count--;

							}

						}

					}
				}

			}

		}

		return count;
	}

}