package hashCode2018;

public class DatosProblema {
	
	private int numFilas;
	private int numCols;
	private int numCoches;
	private int numViajes;
	private int bonus;
	private int steps;
	
	public DatosProblema(int r, int c, int f, int n, int b, int t) {
		this.numFilas = r;
		this.numCols = c;
		this.numCoches = f;
		this.numViajes = n;
		this.bonus = b;
		this.steps = t;
	}

	public int getNumFilas() {
		return numFilas;
	}

	public void setNumFilas(int numFilas) {
		this.numFilas = numFilas;
	}

	public int getNumCols() {
		return numCols;
	}

	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}

	public int getNumCoches() {
		return numCoches;
	}

	public void setNumCoches(int numCoches) {
		this.numCoches = numCoches;
	}

	public int getNumViajes() {
		return numViajes;
	}

	public void setNumViajes(int numViajes) {
		this.numViajes = numViajes;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}
}
