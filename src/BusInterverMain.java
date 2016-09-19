import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusInterverMain {
	
	
	static List <String> bStopId;
	static List <String> bPathSeq; 
	static String bRouteId;
	
	public static List<BusResultModel> busInfoList;

	
	public static void main(String[] args){
		
		List<String>			busInfoList 		= new ArrayList<>();
		List<String>			trafficInfoList		= new ArrayList<>();
		List<BusResultModel> 	busInfoModelList		= new ArrayList<>();
		List<TrafficModel>		trafficInfoModelList 	= new ArrayList<>();			
		
		
		HtmlParser parser = new HtmlParser();
		StringSplit split = new StringSplit();

		String busURL = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?routenm=521&routeid=165000083&authtpcd=&rNo=363";
			
		String html = parser.DownloadHtml(busURL);
		
		//busInfoList = parser.getBusGapInfo(html);
		trafficInfoList = parser.getTrafficInfo(html);
		
		
		for(int i=0; i < busInfoList.size(); i++){
			busInfoModelList.add(split.splitBusInfo(busInfoList.get(i)));
			
			System.out.println("버스번호 : " + busInfoModelList.get(i).getCurrentBusNum() + 
							"\t\t현재위치 : " + busInfoModelList.get(i).getCurrentPosition() +
							"\t\t버스유형 : " + busInfoModelList.get(i).getBusType() +
							"\t\t선행버스 : " + busInfoModelList.get(i).getFormerBusNum() +
							"\t\t버스간격 : " + busInfoModelList.get(i).getBusInterval());
		}
		
		for(int i=0; i < trafficInfoList.size(); i++){
			trafficInfoModelList.add(split.splitTrafficInfo(trafficInfoList.get(i)));
			
			System.out.println("index : " + trafficInfoModelList.get(i).getBusStopIndex() +
							"\t\t정거장ID : " + trafficInfoModelList.get(i).getBusStopId() +
							"\t\t구간속도 : " + trafficInfoModelList.get(i).getBusSpeed());
		}
	}
}
