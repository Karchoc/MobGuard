package fr.Karchoc.TPB;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer{
		
	public static void WriteFile (String Text, String directoryName, String fileName) throws IOException{
		
		 String directoryPath = System.getProperty("user.dir") +  "\\" + directoryName + "\\";
		 String filePath = System.getProperty("user.dir") +  "\\" + directoryName + "\\" + fileName ;
		 
		 //Getting filePath and directoryPath with the file name and the directory name.
		 
		 File file = new File(filePath);
		 File dir = new File(directoryPath);
		
		
		if (dir.exists() && dir.isDirectory() && file.exists()){
		
			try {
			
				FileWriter fw = new FileWriter(filePath, true);
				BufferedWriter output = new BufferedWriter(fw);
			
				output.write(Text);
				output.flush();
				output.close();
			
				System.out.println("Text written!");
			
				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					ioe.printStackTrace();
				} catch (java.lang.NullPointerException e){
					System.out.println ("Error");
					e.printStackTrace();
				}
		
		}
		
		//Write the text if the file is already created
		
		else{
			
			if (dir.exists() && dir.isDirectory()){
				
				file.createNewFile();
				System.out.println("New file at " + filePath);
				
				//Create a new file if the directory already exists, but neither the file
				
				try {					
					FileWriter fw = new FileWriter(filePath, true);
					BufferedWriter output = new BufferedWriter(fw);
				
					output.write(Text);
					output.flush();
					output.close();
				
					System.out.println("Text written!");
				
					} catch (IOException ioe) {
						// TODO Auto-generated catch block
						ioe.printStackTrace();
					} catch (java.lang.NullPointerException e){
						System.out.println ("Error");
						e.printStackTrace();
					}
				//Write the text in the file
			}
			else{
				dir.mkdir();
				System.out.println("New directory at " + directoryPath);
				file.createNewFile();
				System.out.println("New file at " + filePath);			
				try {
					FileWriter fw = new FileWriter(filePath, true);
					BufferedWriter output = new BufferedWriter(fw);
				
					output.write(Text);
					output.flush();
					output.close();
				
					System.out.println("Text written!");
				
					} catch (IOException ioe) {
						// TODO Auto-generated catch block
						ioe.printStackTrace();
					} catch (java.lang.NullPointerException e){
						System.out.println ("Error");
						e.printStackTrace();
					}
			}
		}
			
	}
	
}
