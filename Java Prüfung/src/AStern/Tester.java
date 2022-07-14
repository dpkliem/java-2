package AStern;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] graph = new int[10][10];
		graph[0][1] = graph[1][0]= 65;
		graph[0][2] = graph[2][0]= 30;
		graph[0][4] = graph[4][0]= 75;
		graph[1][4] = graph[4][1]= 35;
		graph[2][3] = graph[3][2]= 40;
		graph[2][5] = graph[5][2]= 35;
		graph[3][4] = graph[4][3]= 30;
		graph[3][6] = graph[6][3]= 25;
		graph[5][9] = graph[9][5]= 70;
		graph[6][7] = graph[7][6]= 50;
		graph[6][9] = graph[9][6]= 50;
		graph[7][8] = graph[8][7]= 25;
		graph[8][9] = graph[9][8]= 15;
		
		double[][] heuristik = new double[10][10];
		
		heuristik[0][8] = heuristik[8][0] = 57;
		heuristik[1][8] = heuristik[8][1] = 54;
		heuristik[2][8] = heuristik[8][2] = 43;
		heuristik[3][8] = heuristik[8][3] = 32;
		heuristik[4][8] = heuristik[8][4] = 42;
		heuristik[5][8] = heuristik[8][5] = 32;
		heuristik[6][8] = heuristik[8][6] = 23;
		heuristik[7][8] = heuristik[8][7] = 20;
		heuristik[9][8] = heuristik[8][9] = 10;
		
		AStern astern = new AStern(graph, heuristik);
		System.out.println(astern.berechneWeg(0, 8));
	}

}
