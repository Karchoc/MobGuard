package fr.Karchoc.MobGuard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer{


	public static void WriteFile (String TextToBeWritten, String directoryName, String fileName) throws IOException{

		//This program write a text (TextToBeWritten) in a file (fileName), which is in a directory (directoryName), and if the directory or the file
		//does not exist, it creates the file or the directory and the file.

		String directoryPath = System.getProperty("user.dir") +  "\\" + directoryName + "\\";
		String filePath = System.getProperty("user.dir") +  "\\" + directoryName + "\\" + fileName ;

		//Getting filePath and directoryPath with the file name and the directory name.

		File file = new File(filePath);
		File dir = new File(directoryPath);


		if (dir.exists() && dir.isDirectory() && file.exists()){

			//Write the TextToBeWritten if the file is already created	

			try {

				FileWriter fw = new FileWriter(filePath, true);
				BufferedWriter output = new BufferedWriter(fw);

				output.write(TextToBeWritten);
				output.flush();
				output.close();


			} catch (IOException ioe) {
				// TODO Auto-generated catch block
				ioe.printStackTrace();
			} catch (java.lang.NullPointerException e){
				System.out.println ("Error");
				e.printStackTrace();
			}

		}



		else{

			if (dir.exists() && dir.isDirectory()){

				//Create a new file if the directory already exists, but not the file

				file.createNewFile();
				System.out.println("New file at " + filePath);



				try {

					//Then write the TextToBeWritten in the file
					FileWriter fw = new FileWriter(filePath, true);
					BufferedWriter output = new BufferedWriter(fw);

					output.write(TextToBeWritten);
					output.flush();
					output.close();


				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					ioe.printStackTrace();
				} catch (java.lang.NullPointerException e){
					System.out.println ("Error");
					e.printStackTrace();
				}
			}
			else{

				//Creates directory if directory doesn't exist

				dir.mkdir();
				System.out.println("New directory at " + directoryPath);

				//Then creates the file in the directory

				file.createNewFile();
				System.out.println("New file at " + filePath);			
				try {
					FileWriter fw = new FileWriter(filePath, true);
					BufferedWriter output = new BufferedWriter(fw);

					output.write(TextToBeWritten);
					output.flush();
					output.close();


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
