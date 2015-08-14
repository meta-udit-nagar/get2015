class Matrix {

	int data[][];
	int noRows;
	int noCols;

	public Matrix(int row, int col) {

		this.noCols = col;
		this.noRows = row;
		data = new int[row][col];

	}

	void addElements(int row, int col, int val) {
		try {
			data[row][col] = val;
		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("wrong input");
		}

	}

	public Matrix transpose() {

		Matrix matrix = new Matrix(noRows, noCols);

		for (int i = 0; i < noRows; i++) {
			for (int j = 0; j < noCols; j++) {

				matrix.data[i][j] = data[j][i];

			}

		}

		return matrix;

	}

	public void show() {

		for (int i = 0; i < noRows; i++) {
			for (int j = 0; j < noCols; j++) {
				System.out.print(" " + data[i][j]);

			}

			System.out.println();
		}

	}
}

class MatrixMain {

	public static void main(String a[]) {
		Matrix matrix = new Matrix(2, 2);
		System.out.println("hello");
		matrix.addElements(0, 0, 1);
		matrix.addElements(0, 1, 2);
		matrix.addElements(1, 0, 3);
		matrix.addElements(1, 1, 4);

		Matrix m = matrix.transpose();
		m.show();

	}

}
