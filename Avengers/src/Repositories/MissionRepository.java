package Repositories;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Models.Avenger;
import Models.Mission;

public class MissionRepository extends AvengerRepository implements IMissionRepository{
	HashMap<String, Mission> missionHash = new HashMap<>();
	Set<String> avengersMissionNameSet = new HashSet<>();

	//Create new mission with given avenger name, mission details, mission name, mission status.
	@Override
	public void CreateMission(String aName, String mDetails, String mName, String mStatus) {
		Set<String> avengersOnMission = new HashSet<>();
		boolean isMission=false;;
		for (Map.Entry<String, Mission> entry : missionHash.entrySet()) {
			if(entry.getValue().getMissionName()==mName) {
				isMission = true;
				System.out.println("This mission already exist.");
			}
		}
		if(!isMission) {
			if (missionHash.containsKey(mName)) {
				Avenger aCard = avengerHash.get(aName);
				if (aCard.getTotalMissions() > 1) {
					System.out.println("Cannot assign more missions to this avenger.");
				} else {
					Mission mission = new Mission();
					avengersOnMission.add(aName);
					mission.setAvengerName(avengersOnMission);
					mission.setMissionDetails(mDetails);
					mission.setMissionName(mName);
					mission.setMissionStatus(mStatus);
					missionHash.put(aName, mission);

					aCard.setTotalMissions(aCard.getTotalMissions() + 1);
					avengerHash.put(aName, aCard);
				}

			} else {
				Mission mission = new Mission();
				
				if(avengerHash.get(aName).getTotalMissions() > 1) {
					System.out.println("Cannot assign more missions to this avenger.");
				}else {
					avengersOnMission.add(aName);
					mission.setAvengerName(avengersOnMission);
					mission.setMissionDetails(mDetails);
					mission.setMissionName(mName);
					mission.setMissionStatus(mStatus);
					missionHash.put(mName, mission);
				}
				
				Avenger aCard = new Avenger();
				Set<String> avengersMissionNameSetNew = new HashSet<>();
				if(avengerHash.get(aName).getTotalMissions()==0) {
					avengersMissionNameSetNew.add(mName);
					aCard.setMissionName(avengersMissionNameSetNew);
					aCard.setName(aName);
					aCard.setTotalMissions(1);
					avengerHash.put(aName, aCard);
					System.out.println("Mission has been assigned to " + aName);
				}
				else {
					if(avengerHash.get(aName).getTotalMissions() > 1) {
						System.out.println("Cannot assign more missions to this avenger.");
					}else {
						avengersMissionNameSetNew = avengerHash.get(aName).getMissionName();
						avengersMissionNameSetNew.add(mName);
						aCard.setMissionName(avengersMissionNameSetNew);
						aCard.setName(aName);
						aCard.setTotalMissions(avengersMissionNameSetNew.size());
						avengerHash.put(aName, aCard);
						System.out.println("Mission has been assigned to " + aName);
					}	
				}
			}
		}
	}

	//Displays all mission's data
	@Override
	public void displayAllMissions() {
		for(Map.Entry<String, Mission> entry : missionHash.entrySet()) {
			System.out.println("----------------------------------");
			System.out.println("Mission Name: "+entry.getValue().getMissionName()+"\nMission Details: "+entry.getValue().getMissionDetails()+
					"\nAvengers on this mission: "+entry.getValue().getAvengerName()+"\nMission status: "+entry.getValue().getMissionStatus());
		}
	}

	//Updates existing mission
	//Provide old avenger on this mission, new avenger which you want to replace, new mission details, new mission name, new mission status.
	@Override
	public void updateMission(String mOldName, String aUpdateName, String mUpdateDetails, String mUpdateName,
			String mUpdateStatus) {

		Mission currentMission = missionHash.get(mOldName);

		currentMission.getAvengerName().add(aUpdateName);
		currentMission.setMissionDetails(mUpdateDetails);
		currentMission.setMissionStatus(mUpdateStatus);
		currentMission.setMissionName(mUpdateName);

		missionHash.replace(mUpdateName, currentMission);
	}

	//Provide mission name which you want to display.
	@Override
	public void displayCurrentMission(String missionName) {
		boolean found = false;
		for (Map.Entry<String, Mission> entry : missionHash.entrySet()) {
			Mission mission = entry.getValue();
			if (mission.getMissionName().equals(missionName)) {
				System.out.println(mission.toString());
				found = true;
				break;
			} 
		}
		if(!found) {
			System.out.println("This mission name does not exist!");
		}
	}
	
	//Provide avenger name and mission name to which you want to add this avenger.
	@Override
	public void addAnotherAvenger(String newName, String missionName1) {
		
		for (Map.Entry<String, Mission> entry : missionHash.entrySet()) {
			Mission mission = entry.getValue();
			
			if (mission.getMissionName().equals(missionName1)) {
				mission.getAvengerName().add(newName);
				missionHash.replace(missionName1,mission);
				
				
				Avenger av = avengerHash.get(newName);
				if(av.getTotalMissions()>0) {
					av.setName(newName);
					avengersMissionNameSet = av.getMissionName();
					avengersMissionNameSet.add(missionName1);
					av.setMissionName(avengersMissionNameSet);
					av.setTotalMissions(av.getTotalMissions()+1);
					avengerHash.replace(newName, av);
				} else {
					avengersMissionNameSet = new HashSet<>();
					avengersMissionNameSet.add(missionName1);
					av.setMissionName(avengersMissionNameSet);
					av.setName(newName);
					av.setTotalMissions(1);
					avengerHash.put(newName, av);
				}
				System.out.println("Avenger " + newName + " added to the mission!");
			}
		}

	}

}
