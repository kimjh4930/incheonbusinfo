import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.BusResultModel;
import model.TrafficModel;

public class ResultWrite {
	
	public void TrafficResulteWrite(List<TrafficModel> TrafficInfo) throws IOException{
		try {
			FileWriter fw = new FileWriter("C:/workspace/BusInterver/BusTrafficResult.txt", true);
			
			for(int i = 0; i < TrafficInfo.size(); i++){
				
				String speed = "";
				
				if(TrafficInfo.size()-1 == i){
					speed = String.valueOf(TrafficInfo.get(i).getBusSpeed());
				}else{
					speed = String.valueOf(TrafficInfo.get(i).getBusSpeed()) + ",";
				}
				fw.write(speed);
			}
			fw.write("\r\n");
			
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void BusLocationWrite(List<BusResultModel> BusLocationInfo) throws IOException{
		try{
			FileWriter fw = new FileWriter("C:/workspace/BusInterver/BusLocationResult.txt", true);
			
			for(int i = 0; i < BusLocationInfo.size(); i++){
				String location = "";
				
				if(BusLocationInfo.size()-1 == i){
					location = String.valueOf(BusLocationInfo.get(i).getCurrentPosition());
				}else{
					location = String.valueOf(BusLocationInfo.get(i).getCurrentPosition()) + ",";
				}
				fw.write(location);
			}
			
			fw.write("\r\n");
			
			fw.close();
			
		}catch(FileNotFoundException e){
			
		}
	}
}
