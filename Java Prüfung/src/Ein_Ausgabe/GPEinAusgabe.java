package Ein_Ausgabe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GPEinAusgabe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		schreiben();
		lesen();
	}
	
	private static void lesen() {
		BufferedReader in = null;
		try {
			in = Files.newBufferedReader(
					Paths.get("C:\\Daten\\gpwI2.txt"),
					StandardCharsets.UTF_8
					);
			
			String zeile = null;//Ende der Datei wird mit null dargestellt
			while((zeile = in.readLine())!=null) {//readline -> ignoriert Zeilenumbrueche
				System.out.println(zeile);
			}
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if(in != null) {
				try {
					in.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}

	private static void schreiben() {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(
					new FileWriter("C:\\Daten\\gpwI2.txt")
					);
			
			out.write("Fast jeder Befehl wird mit einen ; abgeschlossen, ");
			out.newLine();//Zeilenumbruch
			out.write("aber halt nur fast jeder.");
			
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if(out != null) {
				try {
					out.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}
}
