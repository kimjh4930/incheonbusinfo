package main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import model.BusLineInfoModel;
import model.BusResultModel;
import model.TrafficModel;

public class BusInterverMain {

	static List<String> bStopId;
	static List<String> bPathSeq;
	static String bRouteId;

	public static List<BusResultModel> busInfoList;

	public static void main(String[] args) throws IOException {
		// 실행간격 지정(3초)
		int sleepSec = 10;

		// 시간 출력 포맷
		final SimpleDateFormat fmt = new SimpleDateFormat("HHmmss");

		// 주기적인 작업을 위한
		final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

		exec.scheduleAtFixedRate(new Runnable() {

			public void run() {
				try {
					Calendar cal = Calendar.getInstance();

					// 콘솔에 현재 시간 출력
					System.out.println(fmt.format(cal.getTime()));
					runtest();

				} catch (Exception e) {

					e.printStackTrace();

					// 에러 발생시 Executor를 중지시킨다
					exec.shutdown();
				}
			}
		}, 0, sleepSec, TimeUnit.SECONDS);
	}	

	public static void runtest() throws IOException {
		List<String> busInfoList = new ArrayList<>();
		List<String> trafficInfoList = new ArrayList<>();
		List<BusResultModel> busInfoModelList = new ArrayList<>();
		List<TrafficModel> trafficInfoModelList = new ArrayList<>();
		List<Integer> approvalBusList = new ArrayList<>();

		BusLineInfoModel busLineInfo = new BusLineInfoModel();

		HtmlParser parser = new HtmlParser();
		StringSplit split = new StringSplit();
		ResultWrite write = new ResultWrite();
		BusLicense getLicense = new BusLicense();

		String busURL = "http://bus.incheon.go.kr/iwcm/retrieverouteruninfolist.laf?routenm=521&routeid=165000083&authtpcd=&rNo=363";

		String html = parser.DownloadHtml(busURL);

		busInfoList = parser.getBusGapInfo(html);
		trafficInfoList = parser.getTrafficInfo(html);
		busLineInfo = split.splitLineInfo(parser.getBusLineInfo(html));

		for (int i = 0; i < busInfoList.size(); i++) {
			busInfoModelList.add(split.splitBusInfo(busInfoList.get(i)));

//			System.out.println("버스번호 : " + busInfoModelList.get(i).getCurrentBusNum() + "\t\t현재위치 : "
//					+ busInfoModelList.get(i).getCurrentPosition() + "\t\t버스유형 : "
//					+ busInfoModelList.get(i).getBusType() + "\t\t선행버스 : " + busInfoModelList.get(i).getFormerBusNum()
//					+ "\t\t버스간격 : " + busInfoModelList.get(i).getBusInterval());

		}

		for (int i = 0; i < trafficInfoList.size(); i++) {
			trafficInfoModelList.add(split.splitTrafficInfo(trafficInfoList.get(i)));

//			System.out.println("index : " + trafficInfoModelList.get(i).getBusStopIndex() + "\t\t정거장ID : "
//					+ trafficInfoModelList.get(i).getBusStopId() + "\t\t구간속도 : "
//					+ trafficInfoModelList.get(i).getBusSpeed());
		}

		write.TrafficResulteWrite(trafficInfoModelList);

		approvalBusList = getLicense.loadBusLicenseInfo(busInfoModelList, busLineInfo.getWeekdayApprovalNum());
		write.BusLocationWrite(busInfoModelList, approvalBusList);
	}
}
