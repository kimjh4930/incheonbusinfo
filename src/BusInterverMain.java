import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BusInterverMain {
	
	
	static List <String> bStopId;
	static List <String> bPathSeq; 
	static String bRouteId;
	
	public static List<BusResultModel> busInfoList;

	
	public static void main(String[] args){
		
		int sleepSec = 10;
		
		final SimpleDateFormat fmt = new SimpleDateFormat("HHmmss");
		
		final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
		
		exec.scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Calendar cal = Calendar.getInstance();
					
					System.out.println(fmt.format(cal.getTime()));
					
					runtest();
					//
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
			
		}, 0, sleepSec, TimeUnit.SECONDS);
		
	}
	
	public static void runtest(){
		
		HtmlParser parser = new HtmlParser();
		BusInfoSplit split = new BusInfoSplit();
		ResultWrite write = new ResultWrite();
		

		
		String busURL = "http://bus.incheon.go.kr/iwcm/retrievebusstopcararriveinfo.laf?bstopid=163000512&routeid=165000083&pathseq=27";
			
		String html = parser.DownloadHtml(busURL);
		
		String result = parser.getBusInfo(html);
		
		try {
			write.TrafficResultWrite(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
