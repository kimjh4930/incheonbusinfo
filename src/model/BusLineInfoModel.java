package model;

public class BusLineInfoModel {

	//WD : Weekday, WE : Weekend
	private int WeekdayApprovalNum;
	private int WeekendApprovalNum;
	private int WDStartTime;			
	private int WDEndTime;
	private int WDUnderBoundGap;
	private int WDUpperBoundGap;
	private int WEStartTime;
	private int WEEndTime;
	private int WEUnderBoundGap;
	private int WEUpperBoundGap;

	public int getWEUnderBoundGap() {
		return WEUnderBoundGap;
	}

	public void setWEUnderBoundGap(int wEUnderBoundGap) {
		WEUnderBoundGap = wEUnderBoundGap;
	}

	public int getWEUpperBoundGap() {
		return WEUpperBoundGap;
	}

	public void setWEUpperBoundGap(int wEUpperBoundGap) {
		WEUpperBoundGap = wEUpperBoundGap;
	}

	public int getWeekdayApprovalNum() {
		return WeekdayApprovalNum;
	}

	public void setWeekdayApprovalNum(int weekdayApprovalNum) {
		WeekdayApprovalNum = weekdayApprovalNum;
	}

	public int getWeekendApprovalNum() {
		return WeekendApprovalNum;
	}

	public void setWeekendApprovalNum(int weekendApprovalNum) {
		WeekendApprovalNum = weekendApprovalNum;
	}

	public int getWDStartTime() {
		return WDStartTime;
	}

	public void setWDStartTime(int wDStartTime) {
		WDStartTime = wDStartTime;
	}

	public int getWDEndTime() {
		return WDEndTime;
	}

	public void setWDEndTime(int wDEndTime) {
		WDEndTime = wDEndTime;
	}

	public int getWDUnderBoundGap() {
		return WDUnderBoundGap;
	}

	public void setWDUnderBoundGap(int wDUnderBoundGap) {
		WDUnderBoundGap = wDUnderBoundGap;
	}

	public int getWDUpperBoundGap() {
		return WDUpperBoundGap;
	}

	public void setWDUpperBoundGap(int wDUpperBoundGap) {
		WDUpperBoundGap = wDUpperBoundGap;
	}

	public int getWEStartTime() {
		return WEStartTime;
	}

	public void setWEStartTime(int wEStartTime) {
		WEStartTime = wEStartTime;
	}

	public int getWEEndTime() {
		return WEEndTime;
	}

	public void setWEEndTime(int wEENdTime) {
		WEEndTime = wEENdTime;
	}

}
