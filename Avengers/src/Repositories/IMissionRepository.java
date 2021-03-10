package Repositories;

public interface IMissionRepository {
	
	//Create new mission with given avenger name, mission details, mission name, mission status.
	public void CreateMission(String aName, String mDetails, String mName, String mStatus);
	
	//Displays all mission's data
	public void displayAllMissions();
	
	//Provide old avenger on this mission, new avenger which you want to replace, new mission details, new mission name, new mission status.
	public void updateMission(String aOldName, String aUpdateName, String mUpdateDetails, String mUpdateName,
			String mUpdateStatus);
	
	//Provide mission name which you want to display.
	public void displayCurrentMission(String missionName);
	
	//Provide avenger name and mission to which you want to add this avenger.
	public void addAnotherAvenger(String newName, String missionName1);
}
