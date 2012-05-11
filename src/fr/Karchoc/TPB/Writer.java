package fr.Karchoc.TPB;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer{
	
	public void WritingFile (String Txt, String NomDossier, String NomFichier){
		
		String adresseDuFichier = System.getProperty("user.dir"+ "/" + NomDossier + "/" + "NomFichier");	
		try {
			
			FileWriter fw = new FileWriter(adresseDuFichier, true);
			BufferedWriter output = new BufferedWriter(fw);
			
			output.write(Txt);
			output.flush();
			output.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
