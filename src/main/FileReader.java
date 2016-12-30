package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {
	
	public String readTextFromFile(){
		
		BufferedReader bufferReader = null;
		InputStreamReader inputStreamReader = null;
		FileInputStream fileInputStream = null;
		
		//file 경로
		String filePath = "";
		File file = new File("C:/workspace_jsp/BusInterver/recentBusLicense.txt");
		
		String temp = "";
		String content = "";
		
		try{
			fileInputStream = new FileInputStream(file);
			inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			bufferReader = new BufferedReader(inputStreamReader);
			
			while((temp = bufferReader.readLine()) != null){
				content += temp;
			}
			
			//System.out.println("==================== 파일 내용 출력 ====================");
			//System.out.println(content);
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
			
		}catch (IOException e){
			
		}finally{
			try{
				fileInputStream.close();
			}catch (IOException e){
				e.printStackTrace();
			}
			
			try{
				inputStreamReader.close();
			}catch (IOException e){
				e.printStackTrace();
			}
			
			try{
				bufferReader.close();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		
		return content;
	}

}
