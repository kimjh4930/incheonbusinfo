import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusInterverMain {
	
	
	static List <String> bStopId;
	static List <String> bPathSeq; 
	static String bRouteId;
	
	public static List<BusResultModel> busInfoList;

	
	public static void main(String[] args){
		
		bStopId = new ArrayList<String>(Arrays.asList(
				"164000470","164000186","164000450","164000176","164000342","164000131","164000115","164000120","164000179","163000003",
				"163000005","163000512","163000161","163000510","161000135","161000145","161000158","161000175","161000186","161000188",
				"161000254","161000155","161000146","161000133","163000211","163000154","163000511","163000006","163000004","164000175",
				"164000132","164000168","164000173","164000451","164000183","164000202","164000213","164000217"));
		
		bPathSeq = new ArrayList<String>(Arrays.asList(
				"1","3","5","7","9","11","13","16","18","20",
				"21","27","32","36","40","42","44","45","48","49",
				"52","54","56","58","60","66","70","77","78","80",
				"83","85","87","89","91","93","95","97")); 
		
		bRouteId = "165000083";
		
		busInfoList = new ArrayList<BusResultModel>();
		
		HtmlParser parser = new HtmlParser();
		BusInfoSplit split = new BusInfoSplit();
		
		System.out.println("bStopId size : " + bStopId.size());


		String busURL = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?routenm=521&routeid=165000083&authtpcd=&rNo=363";
			
		String html = parser.DownloadHtml(busURL);
		
		parser.getBusGapInfo(html);
		
		/*for(int i=0; i<busInfoList.size()-1; i++){
			BusResultModel model = new BusResultModel();
			model = busInfoList.get(i);
			System.out.println(	"busRemainStopNum   : " + model.getBusRemainStopNum() + 
					"	busRemainTimeM    : " + model.getBusRemainTimeM()	+
					"	busNum            : " + model.getBusNum() +
					"	busDirection      : " + model.getBusDirection() + 
					"	busStartingPoint  : " + model.getBusStartingPoint() + 
					"	busTerminalPoint  : " + model.getBusTerminalPoint() + 
					"	busCurrentLocation: " + model.getBusCurrentLocation() +
					"	busRemainTimeMS   : " + model.getBusRemainTimeMS());
		}*/
		
	}
}
