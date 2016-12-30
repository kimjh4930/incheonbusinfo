package model;

public class BusIntervalModel {

	int index;
	String date;
	long millisTime;
	String busLicenseNumber;
	String busInterval;
	int busCurrentLocation;
	int formerBusLicense;
	int formerBusLocation;
	String busInterverTime;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getMillisTime() {
		return millisTime;
	}

	public void setMillisTime(long millisTime) {
		this.millisTime = millisTime;
	}

	public String getBusLicenseNumber() {
		return busLicenseNumber;
	}

	public void setBusLicenseNumber(String busLicenseNumber) {
		this.busLicenseNumber = busLicenseNumber;
	}

	public String getBusInterval() {
		return busInterval;
	}

	public void setBusInterval(String busInterval) {
		this.busInterval = busInterval;
	}

	public int getBusCurrentLocation() {
		return busCurrentLocation;
	}

	public void setBusCurrentLocation(int busCurrentLocation) {
		this.busCurrentLocation = busCurrentLocation;
	}

	public int getFormerBusLicense() {
		return formerBusLicense;
	}

	public void setFormerBusLicense(int formerBusLicense) {
		this.formerBusLicense = formerBusLicense;
	}

	public int getFormerBusLocation() {
		return formerBusLocation;
	}

	public void setFormerBusLocation(int formerBusLocation) {
		this.formerBusLocation = formerBusLocation;
	}

	public String getBusInterverTime() {
		return busInterverTime;
	}

	public void setBusInterverTime(String busInterverTime) {
		this.busInterverTime = busInterverTime;
	}

}
