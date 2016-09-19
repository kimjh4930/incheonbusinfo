package main;
import model.BusLineInfoModel;
import model.BusResultModel;
import model.TrafficModel;

public class StringSplit {
	
	public BusResultModel splitBusInfo(String busInfoCorpus){
		BusResultModel model = new BusResultModel();

		String[] spl = busInfoCorpus.split(";");
		
		model.setCurrentBusNum		(Integer.parseInt(spl[0]));
		model.setTemp1				(Integer.parseInt(spl[1]));
		model.setCurrentPosition	(Integer.parseInt(spl[2]));
		model.setBusType			(Integer.parseInt(spl[3]));
		model.setFormerBusNum		(Integer.parseInt(spl[4]));
		model.setBusInterval		(changeTimeForm(Integer.parseInt(spl[5])));
		model.setTemp2				(Integer.parseInt(spl[6]));
		
		return model;
	}
	
	public TrafficModel splitTrafficInfo(String trafficInfoCorpus){
		TrafficModel model = new TrafficModel();
		
		String[] spl = trafficInfoCorpus.split(";");
		
		model.setBusStopIndex		(Integer.parseInt(spl[0]));
		model.setBusStopId			(Integer.parseInt(spl[1]));
		model.setTemp				(Integer.parseInt(spl[2]));
		model.setBusSpeed			(Integer.parseInt(spl[3]));
		
		return model;
	}
	
	public BusLineInfoModel splitLineInfo(String lineInfoCorpus){
		BusLineInfoModel model = new BusLineInfoModel();
		
		String[] spl = lineInfoCorpus.split(";");
		
		model.setWeekdayApprovalNum	(Integer.parseInt(spl[0]));
		model.setWeekendApprovalNum (Integer.parseInt(spl[1]));
		model.setWDStartTime		(Integer.parseInt(spl[4]));
		model.setWDEndTime			(Integer.parseInt(spl[5]));
		model.setWDUnderBoundGap	(Integer.parseInt(spl[6]));
		model.setWDUpperBoundGap	(Integer.parseInt(spl[7]));
		model.setWEStartTime		(Integer.parseInt(spl[8]));
		model.setWEEndTime			(Integer.parseInt(spl[9]));
		model.setWEUnderBoundGap	(Integer.parseInt(spl[10]));
		model.setWEUpperBoundGap	(Integer.parseInt(spl[11]));
		
		return model;
	}
	
	public String changeTimeForm(int time){
		
		int minute;
		int second;
		String mmss;;
		
		if (time == -999){
			return "츨발전";
		}
		
		minute = time / 60;
		second = time % 60;

		mmss = minute +"분 " + second +"초";
		
		return mmss;
	}

}
