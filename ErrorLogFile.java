package errorLog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ErrorLogFile {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	@SuppressWarnings("resource")
	public void addErrorMessage(String message){
		try{
			String filePath = "c:/users/temp/desktop/log.txt";
			File file = new File(filePath);
			file.createNewFile();
			FileReader fileReader = new FileReader(filePath);
			int read ;
			String string = "" ;
			while((read = fileReader.read())!=-1){
				string += (char)read ;
			}
			
			FileWriter fileWriter = new FileWriter(filePath);
			fileWriter.write(string);
			fileWriter.append(System.getProperty("line.separator"));	
			fileWriter.append(message);
			fileWriter.flush();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
