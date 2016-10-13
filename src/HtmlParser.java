import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {
	
	public String DownloadHtml(String strURL){
		
		StringBuilder html = new StringBuilder();
		
		try{
			URL url = new URL(strURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			if(conn != null){
				//Connection Timeout 5초
				conn.setConnectTimeout(5000);
				conn.setUseCaches(false);
				
				if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
					BufferedReader br = new BufferedReader(
							new InputStreamReader(conn.getInputStream(), "EUC-KR"));
					
					String line = "";
					
					while(true){
						line = br.readLine();
						
						if(line == null)
							break;
						
						html.append(line + "\n");
					}
					
					br.close();
				}
				conn.disconnect();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//System.out.println(html.toString());
		
		//return html.toString().replaceAll("\\p{Z}", "");
		//return html.toString().replace(" ", "").replace("\t", "").replace("\r", "");
		return html.toString().replaceAll("\\p{Space}", "");
	}
	
	/*public String getBusGapInfo(String html){
		
		String PageData = html.trim();
		String operateBusRegex = String.format("\\d{7};\\d+;\\d+;\\d;\\d+;-?\\d+;\\d");
		
		Pattern operateBusPattern = Pattern.compile(operateBusRegex);
		Matcher operateBusPatternMatches = operateBusPattern.matcher(PageData);
		
		String busGapInfo = "";
		
		System.out.println(operateBusPatternMatches.find());
		
		while(operateBusPatternMatches.find()){
			busGapInfo = operateBusPatternMatches.group(0).trim();
			System.out.println(busGapInfo);
		}
		
		System.out.println(busGapInfo);
		
		return "";
	}*/
	
	public String getBusInfo(String html){
		
		String PageData = html.trim();
		
		//System.out.println(PageData);
		
		String busStopRegex = String.format("<tdalign=\"center\"bgcolor=\"#FFFFFF\">521</td>" 	//노선번호
				+ "<tdalign=\"center\"bgcolor=\"#FFFFFF\">[가-힣]{1,2}</td>"							//방향
				+ "<tdalign=\"center\"bgcolor=\"#FFFFFF\">옥련중학교</td>"								//기점
				+ "<tdalign=\"center\"bgcolor=\"#FFFFFF\">동인천</td>"								//종점
				+ "<tdalign=\"center\"bgcolor=\"#FFFFFF\">.{1,20}</td>"								//현재정류소
				+ "<tdalign=\"center\"bgcolor=\"#FFFFFF\">\\d{1,2}분\\d{1,2}초</td>");				//도착예정시간
		
		String busLocationRegex = String.format("<fontcolor=\"red\">\\d{1,2}</font>번째전정류소에서<fontcolor=\"red\">\\d{1,2}분</font>");
		
		Pattern busStopPattern = Pattern.compile(busStopRegex);
		Matcher busStopPatternMatches = busStopPattern.matcher(PageData);
		
		Pattern busLocationPattern = Pattern.compile(busLocationRegex);
		Matcher busLocationPatternMatches = busLocationPattern.matcher(PageData);
		
		String busStopInfo = "";
		String busLocationInfo = "";
		
		while(busLocationPatternMatches.find()){
			busLocationInfo = busLocationPatternMatches.group(0).trim()
																.replaceAll("<fontcolor=\"red\">", "")
																.replaceAll("</font>번째전정류소에서", ",")
																.replaceAll("분</font>", ",");
		}
		
		if("".equals(busLocationInfo))
			busLocationInfo = "0,0,";
		
		while(busStopPatternMatches.find()){			
			busStopInfo += busStopPatternMatches.group(0).trim().replaceAll("<tdalign=\"center\"bgcolor=\"#FFFFFF\">", "").replaceAll("</td>", ",");			
		}
		
		if("".equals(busStopInfo))
			busStopInfo = "521,상행,옥련중학교,동인천,출발전,0분0초";
		
		
		System.out.println(busLocationInfo + busStopInfo);
		
		return busLocationInfo + busStopInfo;
	}
}
