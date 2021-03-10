package Models;

import java.util.Set;

public class Mission {
	//contains names of all avengers which are on this mission.
	private Set<String> avengerName;
	private String missionName;
	private String missionStatus;
	private String missionDetails;

	public Mission() {
		super();
	}

	public Set<String> getAvengerName() {
		return avengerName;
	}

	public void setAvengerName(Set<String> avengersOnMission) {
		this.avengerName = avengersOnMission;
	}

	public String getMissionName() {
		return missionName;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public String getMissionStatus() {
		return missionStatus;
	}

	public void setMissionStatus(String missionStatus) {
		this.missionStatus = missionStatus;
	}

	public String getMissionDetails() {
		return missionDetails;
	}

	public void setMissionDetails(String missionDetails) {
		this.missionDetails = missionDetails;
	}

	@Override
	public String toString() {
		return "Mission [avengerName=" + avengerName + ", missionName=" + missionName + ", missionStatus="
				+ missionStatus + ", missionDetails=" + missionDetails + "]";
	}

}
