package Models;

import java.util.Set;

public class Avenger {
	private String name;
	private Set<String> missionName;
	private int totalMissions;

	public Avenger() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getMissionName() {
		return missionName;
	}

	public void setMissionName(Set<String> missionName) {
		this.missionName = missionName;
	}

	public int getTotalMissions() {
		return totalMissions;
	}

	public void setTotalMissions(int totalMissions) {
		this.totalMissions = totalMissions;
	}

	@Override
	public String toString() {
		return "Avenger [name=" + name + ", missionName=" + missionName + ", totalMissions=" + totalMissions + "]";
	}

}
