package main;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import model.BusIntervalModel;
import model.BusResultModel;
import model.TrafficModel;

public class ResultWrite {

	public void TrafficResulteWrite(List<TrafficModel> TrafficInfo) throws IOException {
		try {
			FileWriter fw = new FileWriter("C:/workspace_jsp/BusInterver/BusTrafficResult.txt", true);
			
			final SimpleDateFormat fmt = new SimpleDateFormat("HHmmss");
			
			Calendar cal = Calendar.getInstance();
			String time =  fmt.format(cal.getTime());
			fw.write(time + ",");

			for (int i = 0; i < TrafficInfo.size(); i++) {

				String speed = "";

				if (TrafficInfo.size() - 1 == i) {
					speed = String.valueOf(TrafficInfo.get(i).getBusSpeed());
				} else {
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

	public void BusLocationWrite(List<BusResultModel> BusLocationInfo, List<Integer> approvalBusList)
			throws IOException {
		try {
			FileWriter fw = new FileWriter("C:/workspace_jsp/BusInterver/BusLocationResult.txt", true);
			
			final SimpleDateFormat fmt = new SimpleDateFormat("HHmmss");
			
			Calendar cal = Calendar.getInstance();
			String time =  fmt.format(cal.getTime());
			fw.write(time + ",");
			
			int[] value = new int[approvalBusList.size()];
			List<Integer> currentPosList = new ArrayList<>();
			Arrays.fill(value, 0);			
			
			for(int i=0; i<BusLocationInfo.size(); i++){
				int j = approvalBusList.indexOf(BusLocationInfo.get(i).getCurrentBusNum());
				if(j == -1 ){
					continue;
				}
				//System.out.println(BusLocationInfo.size() + ", " + j);
				value[j] = BusLocationInfo.get(i).getCurrentPosition();
			}
			
			for(int i=0; i<value.length; i++){
				currentPosList.add(value[i]);
			}
		
			String location = "";

			for (int i = 0; i < currentPosList.size(); i++) {
				//String location = "";

				if (currentPosList.size() - 1 == i) {
					location = String.valueOf(currentPosList.get(i));
				} else {
					location = String.valueOf(currentPosList.get(i)) + ",";
				}
				fw.write(location);
			}

			fw.write("\r\n");

			fw.close();

		} catch (FileNotFoundException e) {

		}
	}
	
	public void BusIntervalWrite(List<BusResultModel> resultModel) throws IOException {
		
		final SimpleDateFormat filenameDate = new SimpleDateFormat("yyyy-MM-dd");
		final SimpleDateFormat departTime 	= new SimpleDateFormat("HHmmss");
		
		Calendar cal = Calendar.getInstance();		//Wed Dec 28 11:58:06 KST 2016
			
		String filename = filenameDate.format(cal.getTime());
		String depart	= departTime.format(cal.getTime());
		
		String outputString = null;
		
		BusIntervalModel intervalModel = new BusIntervalModel();
		
		try{
			FileWriter fw = new FileWriter(filename + "_9200.txt", true);
			
//			for(int i = 0; i < resultModel.size(); i++){
//				
//			}
			for(int i=0; i<resultModel.size(); i++){
				if(resultModel.get(i).getCurrentPosition() == 1){
					continue;
				}else{
					
					
					intervalModel.setDate(depart);
					intervalModel.setMillisTime(System.currentTimeMillis());
					intervalModel.setBusLicenseNumber(resultModel.get(i).getCurrentBusNum());
					intervalModel.setBusInterval(resultModel.get(i).getBusInterval());
					intervalModel.setBusCurrentLocation(resultModel.get(i).getCurrentPosition());
					intervalModel.setFormerBusLicense(resultModel.get(i).getFormerBusNum());
					
					//이전 model과 비교
					
					//이전 모델이 null 이라면 현재 자료를 넣음.
					
					break;
				}
				
			}
			
			
			
			
		}catch(FileNotFoundException e){
			
		}
		
	}
}
