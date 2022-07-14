package Ein_Ausgabe;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFSeminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		grundlagenRAF();//RAF - Random Access File
		int anzahl = 20;
		schreibeZufallszahlen(anzahl);
		int liesZahl = 14;
		
		double nWert = leseZufallszahl(liesZahl);
		System.out.println(nWert);
	}
	
	private static double leseZufallszahl(int n) {
		double erg = -1; //Rueckgabe bei Fehler
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("C:\\Daten\\DateiZufallwI2.data", "r");
			if(n * 8 + 8 <= raf.length()) {
				raf.seek(n*8);//8 -> 8 Byte(Double)
				erg = raf.readDouble();
			}else {
				erg = -2;//Zahl die gelesen werden soll ist nicht im Bereich
			}
		}catch(IOException ioex) {
			ioex.printStackTrace();//gibt auf der Console den Fehlerbaum aus
		}finally {
			//wird immer ausgefuehrt, auch bei einer Fehlermeldung
			if(raf != null) {
				try {
					raf.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
		return erg;
	}
	
	private static void schreibeZufallszahlen(int anzahl) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("C:\\Daten\\DateiZufallwI2.data", "rw");
			for(int m = 0; m < anzahl; m++) {
				raf.writeDouble(Math.random());
			}
		}catch(IOException ioex) {
			ioex.printStackTrace();//gibt auf der Console den Fehlerbaum aus
		}finally {
			//wird immer ausgefuehrt, auch bei einer Fehlermeldung
			if(raf != null) {
				try {
					raf.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}
	
	private static void grundlagenRAF() {
		RandomAccessFile raf = null;
		try {
			
			raf = new RandomAccessFile("C:\\Daten\\DateiRAFwI2.data", "rw");
			//(Pfad + Dateiname, Modus(r - read, rw - read write))
			raf.writeDouble(12345.6789);
			raf.writeUTF("Hallo liebe Studierende");
			//jede Operation (lesen, schreiben) aendert den Dateizeiger / Filepointer
			raf.seek(0);//seek aendert den DAteizeiger auf die Position 
			System.out.println(raf.readDouble());
			System.out.println(raf.readUTF());
			//Merke: die Reihenfolge der Eingabe und Ausgabe muessen identisch sein
		}catch(IOException ioex) {
			ioex.printStackTrace();//gibt auf der Console den Fehlerbaum aus
		}finally {
			//wird immer ausgefuehrt, auch bei einer Fehlermeldung
			if(raf != null) {
				try {
					raf.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}

}
