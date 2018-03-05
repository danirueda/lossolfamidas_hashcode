package hashCode2018;

import java.util.ArrayList;

public class Coche {
	
	//private int id;
	private int fil, col;
	private boolean ocupado;
	private ArrayList<Integer> rutas;
	private  int ti;
	
	public Coche() {
		this.ti = 0;
		this.fil = 0;
		this.col = 0;
		this.ocupado = false;
		this.rutas = new ArrayList<Integer>();
	}

	public int getFil() {
		return fil;
	}

	public void setFil(int fil) {
		this.fil = fil;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public ArrayList<Integer> getRutas() {
		return rutas;
	}

	public void setRutas(ArrayList<Integer> rutas) {
		this.rutas = rutas;
	}

	public void addRuta(int i) {
		rutas.add(i);
	}
	
	public void setTi(int t) {
		this.ti = t;
	}
	
	public void comprobar(int t) {
		if (ti<t+1) {
			this.ocupado = false;
		}
	}
	
	@Override
	public String toString() {
		return "Coche [fil=" + fil + ", col=" + col + ", ocupado=" + ocupado + ", rutas=" + rutas + "]";
	}
	
}
