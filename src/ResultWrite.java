import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResultWrite {
	
	public void TrafficResultWrite(String result) throws IOException{
		
		try{
			FileWriter fw = new FileWriter("C:/workspace_jsp/BusInterver/realtime.txt", true);
			
			final SimpleDateFormat fmt = new SimpleDateFormat("HHmmss");
			Calendar cal = Calendar.getInstance();
			String time = fmt.format(cal.getTime());
			
			fw.write(time + " " + result);
			fw.write("\r\n");
			
			fw.close();
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		
	}

}
