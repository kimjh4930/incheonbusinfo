import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusInterverMain {
	
	
	static List <String> bStopId;
	static List <String> bPathSeq; 
	static String bRouteId;
	
	public static List<BusResultModel> busInfoList;

	
	public static void main(String[] args){
		
		List<BusResultModel> 	splitModelList	= new ArrayList<>();
		List<String>			resultModelList = new ArrayList<>();
		
		HtmlParser parser = new HtmlParser();
		BusInfoSplit split = new BusInfoSplit();

		String busURL = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?routenm=521&routeid=165000083&authtpcd=&rNo=363";
			
		String html = parser.DownloadHtml(busURL);
		
		resultModelList = parser.getBusGapInfo(html);
		
		for(int i=0; i < resultModelList.size(); i++){
			splitModelList.add(split.splitBusInfo(resultModelList.get(i)));
			
			System.out.println("버스번호 : " + splitModelList.get(i).getCurrentBusNum() + 
							"\t\t현재위치 : " + splitModelList.get(i).getCurrentPosition() +
							"\t\t버스유형 : " + splitModelList.get(i).getBusType() +
							"\t\t선행버스 : " + splitModelList.get(i).getFormerBusNum() +
							"\t\t버스간격 : " + splitModelList.get(i).getBusInterval());
		}		
	}
}
