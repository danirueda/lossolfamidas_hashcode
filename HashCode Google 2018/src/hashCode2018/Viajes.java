package hashCode2018;

public class Viajes {

	private int id;
	private int filaIni;
	private int colIni;
	private int filaFin;
	private int colFin;
	private int tiempoIni;
	private int tiempoFin;
	
	public Viajes(int id, int a, int b, int x, int y, int s, int f) {
		this.id = id;
		this.filaIni = a;
		this.colIni = b;
		this.filaFin = x;
		this.colFin = y;
		this.tiempoIni = s;
		this.tiempoFin = f;
	}

	public int getId() {
		return id;
	}
	public int getFilaIni() {
		return filaIni;
	}

	@Override
	public String toString() {
		return "Viajes [filaIni=" + filaIni + ", colIni=" + colIni + ", filaFin=" + filaFin + ", colFin=" + colFin
				+ ", tiempoIni=" + tiempoIni + ", tiempoFin=" + tiempoFin + "]";
	}

	public void setFilaIni(int filaIni) {
		this.filaIni = filaIni;
	}

	public int getColIni() {
		return colIni;
	}

	public void setColIni(int colIni) {
		this.colIni = colIni;
	}

	public int getFilaFin() {
		return filaFin;
	}

	public void setFilaFin(int filaFin) {
		this.filaFin = filaFin;
	}

	public int getColFin() {
		return colFin;
	}

	public void setColFin(int colFin) {
		this.colFin = colFin;
	}

	public int getTiempoIni() {
		return tiempoIni;
	}

	public void setTiempoIni(int tiempoIni) {
		this.tiempoIni = tiempoIni;
	}

	public int getTiempoFin() {
		return tiempoFin;
	}

	public void setTiempoFin(int tiempoFin) {
		this.tiempoFin = tiempoFin;
	}
}
