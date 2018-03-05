package hashCode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HashCode2018 {

	private static final String FICHERO = "e_high_bonus";
	
	public static void main (String [] Args) {

		
		leerFicheroPorLineas(FICHERO+".in");
		//escribirFichero(output,append);
	}

	private static void leerFicheroPorLineas(String input) {
			Scanner s = null;
			try {			
				String linea = "";
				
				s = new Scanner (new File(input));
				
				int numFilas = s.nextInt();
				int numCols = s.nextInt();
				int numCoches = s.nextInt();
				int numViajes = s.nextInt();
				int bonus = s.nextInt();
				int steps = s.nextInt();

				DatosProblema dp = new DatosProblema(numFilas, numCols, numCoches, numViajes, bonus, steps);
				
				System.out.println(numFilas + " " + numCols + " " + numCoches + " " +
						+ numViajes + " " + bonus + " " + steps);
				ArrayList<Viajes> viajes = new ArrayList<Viajes>();
				int idViaje=0;
				while (s.hasNextLine()) {
					
					int filIni = s.nextInt();
					int colIni = s.nextInt();
					int filEnd = s.nextInt();
					int colEnd = s.nextInt();
					int tiempoIni = s.nextInt();
					int tiempoEnd = s.nextInt();
					
					Viajes viaje = new Viajes(idViaje, filIni, colIni, filEnd, colEnd, tiempoIni, tiempoEnd);
					idViaje++;
					viajes.add(viaje);
					s.nextLine();
					//linea = s.nextLine();
					//System.out.println(linea);
				}
				
				System.out.println(viajes.size());
				
				
				// EMPIEZA PROBLEMA
				// Ordenar arraylist
				Collections.sort(viajes, new Comparator<Viajes>() {
			        @Override public int compare(Viajes p1, Viajes p2) {
			            return p1.getTiempoIni() - p2.getTiempoIni(); // Ascending
			        }
				});
				
				mostrar(viajes);
				
				
				// SOLUCIONAR PROBLEMA
				
				// crear coches
				ArrayList<Coche> coches = new ArrayList<Coche>();
				for(int i=0; i<dp.getNumCoches(); i++) {
					coches.add(new Coche());
				}
				
				// bucle principal
				for(int t=0; t<dp.getSteps(); t++) {
					
					for(Coche c : coches) {
						// Si no esta ocupado
						if(!c.isOcupado()) {
							
							// Recorrer viajes
							for(int v=0; v<viajes.size(); v++) {
								
								int ss = viajes.get(v).getTiempoIni();
								int aa = Math.abs(c.getFil() - viajes.get(v).getFilaIni());
								int bb = Math.abs(c.getCol() - viajes.get(v).getColIni());
								
								int tiempoFilaFin = Math.abs(viajes.get(v).getFilaIni() - viajes.get(v).getFilaFin());
								int tiempoColFin = Math.abs(viajes.get(v).getColIni() - viajes.get(v).getColFin());
								int tiempoFinViaje = tiempoFilaFin + tiempoColFin;
								
								int cochelibre = t + tiempoFinViaje + aa + bb;

								// Ordenar arraylist
								Collections.sort(viajes, new Comparator<Viajes>() {
									@Override public int compare(Viajes p1, Viajes p2) {
										/*
										int aa1 = Math.abs(c.getFil() - p1.getFilaIni());
										int aa2 = Math.abs(c.getFil() - p2.getFilaIni());
										
										int bb1 = Math.abs(c.getCol() - p1.getColIni());
										int bb2 = Math.abs(c.getCol() - p2.getColIni());
										
										int tiempoFilaTotal = Math.abs(p1.getFilaIni() - p1.getFilaFin());
										int tiempoFila2Total = Math.abs(p2.getFilaIni() - p2.getFilaFin());
										
										int tiempoColTotal = Math.abs(p1.getColIni() - p1.getColFin());
										int tiempoCol2Total = Math.abs(p2.getColIni() - p2.getColFin());
										

										
										int tiempoTotalViaje1 = tiempoFilaTotal + tiempoColTotal;
										int tiempoTotalViaje2 = tiempoFila2Total + tiempoCol2Total;
										
										
										int coche1libre = tiempoTotalViaje1 + aa1 + bb1;
										int coche2libre = tiempoTotalViaje2 + aa2 + bb2;
										
										return coche1libre - coche2libre; // Ascending*/
										return p1.getTiempoIni() - p2.getTiempoIni();
									}
								});
								
								if(viajes.get(v).getTiempoFin()-t >= aa + bb + tiempoFinViaje) {
									c.setTi(cochelibre);
									c.setOcupado(true);
									c.setFil(viajes.get(v).getFilaFin());
									c.setCol(viajes.get(v).getColFin());
									c.addRuta(viajes.get(v).getId());
									viajes.remove(v);
									break;
								}
							}
						}
						c.comprobar(t);
					}
					
				}
				/*
				for(int i=0; i<coches.size(); i++) {
					System.out.println(coches.get(i).getRutas().toString());
				}*/
				
				// CREAR FICHERO
				escribirFichero(FICHERO+".out", false, coches);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if(s != null) {
					s.close();	
				}
			}
			
			
			

	}

	private static void escribirFichero(String output, boolean append, ArrayList<Coche> coches) {
		try {
           FileWriter fw=new FileWriter(output, append);
           PrintWriter pw = new PrintWriter(fw);
           
           //pw.println("Algo " + 97);
           for(Coche c : coches) {
        	   pw.print(c.getRutas().size());
        	   for(Integer r : c.getRutas()) {
        		   pw.print(" " + r);
        	   }
        	   pw.println();
           }
           
           pw.close();
           fw.close(); 
        } catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
		
	}
	
	private static void mostrar(ArrayList<Viajes> viajes) {
		/*for(int i=0; i<viajes.size(); i++) {
			System.out.println(viajes.get(i));
		}*/
	}
	
	
}
