package AStern;

import java.util.Arrays;

public class AStern {
	
	private int[][] graph;//Graph als Adjazenzmatrix
	
	private int[] distanz;
	
	private double[] prioritaeten;
	
	private double[][] heuristik;
	
	private boolean[] besucht;
	
	public AStern(int[][] graph, double[][] heuristik) {
		this.graph = graph;
		this.heuristik = heuristik;
		distanz = new int[graph.length];
		prioritaeten = new double[graph.length];
		//in welcher Reihenfolge muessen die Knoten besucht werden
		besucht = new boolean[graph.length];
		
		Arrays.fill(distanz, Integer.MAX_VALUE);
		Arrays.fill(prioritaeten,Integer.MAX_VALUE);
		//distanz / prioritaeten auf hohen Wert setzen, da Basis Init. 0 ist
	}
	
	public double berechneWeg(int start, int ende) {
		distanz[start] = 0;//Distanz am Start ist 0
		
		prioritaeten[start] = heuristik[start][ende];
		
		while(true) {
			//solange Knoten zum besuchen da sind
			
			double niedrigstePrioritaet = Integer.MAX_VALUE;
			int niedrigsterIndex = -1;
			
			for(int i = 0; i < prioritaeten.length; i++) {
				if(prioritaeten[i] < niedrigstePrioritaet && !besucht[i]) {
					niedrigstePrioritaet = prioritaeten[i];
					niedrigsterIndex = i;
				}
			}
			
			if(niedrigsterIndex == -1) {
				//keine Knoten gefunden, bspw. Verbindung existiert nicht
				return -1;
			}
			
			if(niedrigsterIndex == ende) {
				//Ziel gefunden
				System.out.println("Ziel gefunden");
				return distanz[niedrigsterIndex];
			}
			
			for(int i = 0; i < graph[niedrigsterIndex].length;i++) {
				if(graph[niedrigsterIndex][i] != 0 && !besucht[i]) {
					//alle nicht besuchten Knoten bearbeiten
					if(distanz[niedrigsterIndex] + graph[niedrigsterIndex][i] < distanz[i]) {
						distanz[i] = distanz[niedrigsterIndex]+ graph[niedrigsterIndex][i];
						prioritaeten[i] = distanz[i] + heuristik[i][ende];
					}
				}
			}
			besucht[niedrigsterIndex] = true;
		}
	}
	
	

}
