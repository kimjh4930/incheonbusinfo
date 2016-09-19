import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import model.BusResultModel;

public class BusLicense {

	public List loadBusLicenseInfo(List<BusResultModel> busModelList, int approvalNum) throws IOException {
		BufferedReader br;
		List<Integer> downloadLicenseList = new ArrayList();
		List<Integer> loadedLicenseList = new ArrayList();
		List<Integer> newLicenseList = new ArrayList();
		String result = null;

		for (int i = 0; i < busModelList.size(); i++) {
			downloadLicenseList.add(busModelList.get(i).getCurrentBusNum());
		}

		Collections.sort(downloadLicenseList);

		try {
			br = new BufferedReader(new FileReader("C:/workspace/BusInterver/BusLicenseList.txt"));

			while (true) {
				String line = br.readLine();

				if (line == null)
					break;

				result = line;

			}

			br.close();

			if (result == null){
				System.out.println("result is null");
				return null;
			}

			loadedLicenseList = splitLoadData(result);
			
			if(approvalNum == loadedLicenseList.size()){
				System.out.println("여기서 종료");
				return loadedLicenseList;
			}else{
			
				loadedLicenseList.addAll(downloadLicenseList);
	
				HashSet hs = new HashSet(loadedLicenseList);
				newLicenseList = new ArrayList<Integer>(hs);
	
				Collections.sort(newLicenseList);
				
				writeToFile(newLicenseList);
				
				return newLicenseList;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return writeToFile(downloadLicenseList);
		}
	}

	public List writeToFile(List data) {
		FileWriter fw;
		
		List<Integer> numberList = new ArrayList();
		
		try {
			fw = new FileWriter("C:/workspace/BusInterver/BusLicenseList.txt");

			for (int i = 0; i < data.size(); i++) {

				String number;

				if (data.size() - 1 == i) {
					number = String.valueOf(data.get(i));
				} else {
					number = String.valueOf(data.get(i)) + ",";
				}
				
				numberList.add((Integer) data.get(i));

				fw.write(number);
			}

			fw.close();
			
			return numberList;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List splitLoadData(String data) {
		List<Integer> list = new ArrayList();

		String[] spl = data.split(",");
		
		System.out.println(data);
		System.out.println(spl.length);

		for (int i = 0; i < spl.length; i++) {
			list.add(Integer.parseInt(spl[i]));
		}

		return list;
	}

}
