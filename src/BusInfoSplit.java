
public class BusInfoSplit {
	
	public BusResultModel splitBusInfo(String busInfoCorpus){
		BusResultModel model = new BusResultModel();

		String[] spl = busInfoCorpus.split(",");
		
		model.setBusRemainStopNum	(Integer.parseInt(spl[0]));
		model.setBusRemainTimeM		(Integer.parseInt(spl[1]));
		model.setBusNum				(Integer.parseInt(spl[2]));
		model.setBusDirection		(spl[3]);
		model.setBusStartingPoint	(spl[4]);
		model.setBusTerminalPoint	(spl[5]);
		model.setBusCurrentLocation	(spl[6]);
		model.setBusRemainTimeMS	(Integer.parseInt(changeTimeForm(spl[7])));
		
		return model;
	}
	
	public String changeTimeForm(String time){
		
		String[] spl = time.split("분");
		int minute, second;

		minute = Integer.parseInt(spl[0]) * 60;
		second = Integer.parseInt(spl[1].replaceAll("초", ""));
		
		second += minute;
		
		return String.valueOf(second);
	}

}
