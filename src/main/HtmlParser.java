package main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

	public String DownloadHtml(String strURL) {

		StringBuilder html = new StringBuilder();

		try {
			URL url = new URL(strURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			if (conn != null) {
				// Connection Timeout 5초
				conn.setConnectTimeout(5000);
				conn.setUseCaches(false);

				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "EUC-KR"));

					String line = "";

					while (true) {
						line = br.readLine();

						if (line == null)
							break;

						html.append(line + "\n");
					}

					br.close();
				}
				conn.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return html.toString();
	}

	public List getBusGapInfo(String html) {

		String PageData = html.trim();
		String operateBusRegex = String.format("\\d{7};\\d+;\\d+;\\d;\\d+;-?\\d+;\\d");
		List<String> operateBusList = new ArrayList<String>();

		Pattern operateBusPattern = Pattern.compile(operateBusRegex);
		Matcher operateBusPatternMatches = operateBusPattern.matcher(PageData);

		String busGapInfo = "";

		while (operateBusPatternMatches.find()) {
			busGapInfo = operateBusPatternMatches.group(0).trim();
			operateBusList.add(busGapInfo);
		}

		return operateBusList;
	}

	public List getTrafficInfo(String html) {

		String PageData = html.trim();
		
		String trafficRegex = String.format("\\d{1,3};\\d{9,10}?;\\d;\\d{1,3}");
		List<String> trafficList = new ArrayList<String>();

		Pattern trafficPattern = Pattern.compile(trafficRegex);
		Matcher trafficPatternMatches = trafficPattern.matcher(PageData);

		String trafficInfo = "";

		while (trafficPatternMatches.find()) {
			trafficInfo = trafficPatternMatches.group(0).trim();
			trafficList.add(trafficInfo);
		}
		
		return trafficList;
	}
	
	public String getBusLineInfo(String html){
		
		String PageData = html.trim();
		
		String lineInfoRegex = String.format("\\d+;\\d+;\\d+;\\d+;\\d{4};\\d{4};\\d+;\\d+;\\d{4};\\d{4};\\d+;\\d+");
		
		Pattern lineInfoPattern = Pattern.compile(lineInfoRegex);
		Matcher lineInfoPatternMatches = lineInfoPattern.matcher(PageData);
		
		String lineInfo = "";
		
		while(lineInfoPatternMatches.find()){
			lineInfo = lineInfoPatternMatches.group(0).trim();
		}
		
		return lineInfo;
	}

}
