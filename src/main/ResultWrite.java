package main;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.BusResultModel;
import model.TrafficModel;

public class ResultWrite {

	public void TrafficResulteWrite(List<TrafficModel> TrafficInfo) throws IOException {
		try {
			FileWriter fw = new FileWriter("C:/workspace/BusInterver/BusTrafficResult.txt", true);

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
			FileWriter fw = new FileWriter("C:/workspace/BusInterver/BusLocationResult.txt", true);
			
			System.out.println(approvalBusList.indexOf(approvalBusList.get(3)));
			
			int[] value = new int[approvalBusList.size()];
			List<Integer> currentPosList = new ArrayList<>();
			Arrays.fill(value, 0);			
			
			for(int i=0; i<BusLocationInfo.size(); i++){
				int j = approvalBusList.indexOf(BusLocationInfo.get(i).getCurrentBusNum());
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
}
