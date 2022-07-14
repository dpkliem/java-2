package Ein_Ausgabe;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SeqDateiarbeit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		schreiben();
		lesen();
	}
	
	private static void lesen() {
		InputStream in = null;
		try {
			in = Files.newInputStream(
					Paths.get("C:\\Daten\\seqSchreibenwI2.txt"), 
					StandardOpenOption.READ);
			
			int b = in.read();//gibt -1 zurueck beim Dateiende
			while( b != -1) {
				System.out.print((char)b); //b -> Byte
				b = in.read();
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
		OutputStream out = null;//Outputstream -> abstraktes Objekt
		try {
			out = new FileOutputStream("C:\\Daten\\seqSchreibenwI2.txt");
			String text = "Ein kleiner Text \n Noch ein Text";
			char[] zeichen = text.toCharArray();
			for(int m = 0; m < zeichen.length; m++) {
				out.write(zeichen[m]);
			}
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
