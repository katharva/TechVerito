package AvengersAssemble;

import java.util.Scanner;

import Repositories.AvengerRepository;
import Repositories.IAvengerRepository;
import Repositories.IMissionRepository;
import Repositories.MissionRepository;

public class AvengersAssemble {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in).useDelimiter("\\n");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome Mr. Fury! How would you like to start your day?"+"\n");

		// Here are all methods in these two repositories for CRUD operations.
		// Mission Repository contains details about all missions and AvengerRepository contains details about avengers and missions they are working on.
		IMissionRepository missionRepositories = new MissionRepository();
		IAvengerRepository avengerRepositories = new AvengerRepository();

		// Here we are just initializing the 6 avengers and their missions as null.
		avengerRepositories.initializeAvengers();
		while (true) {
			System.out.println("Press repective number: " + "\n" + "1.Create Misson" + "\n" + "2.Avengers Details"
					+ "\n" + "3.Current mission details" + "\n" + "4.Update Mission" + "\n"
					+ "5.Get all missions details" + "\n" + "6.Add another avenger to the mission" + "\n" + "7.Exit");
			int pressed = scan.nextInt();

			switch (pressed) {
			case 1:
				System.out.println(
						"Please enter Avenger Name whom you want on that mission(DO NOT GIVE ANY SPACES), MissionDetails, Mission Name, Mission status"+"\n"+"Please enter line separated input.");
				
				String aName = sc.nextLine();
				String mDetails = sc.nextLine();
				String mName = sc.nextLine();
				String mStatus = sc.nextLine();
				try {
					missionRepositories.CreateMission(aName, mDetails, mName, mStatus);
				}catch(Exception e) {
					e.printStackTrace();
				}

				break;
			case 2:
				try {
					AvengerRepository.getAllDetails();
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 3:
				System.out.println("Provide Mission Name to get the details.");
				String missionName = sc.nextLine();
				try {
					missionRepositories.displayCurrentMission(missionName);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 4:
				System.out.println(
						"Please enter old avenger's name working on this mission(DO NOT GIVE ANY SPACES), new avenger name(DO NOT GIVE ANY SPACES), Mission name which you want to update, Mission Details, Mission status"
								+"\n"+"Please enter line separated input.");
				String aOldName = sc.nextLine();
				String aUpdateName = sc.nextLine();
				String mUpdateName = sc.nextLine();
				String mUpdateDetails = sc.nextLine();
				String mUpdateStatus = sc.nextLine();
				try {
					missionRepositories.updateMission(aOldName, aUpdateName, mUpdateDetails, mUpdateName, mUpdateStatus);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 5:
				try {
					missionRepositories.displayAllMissions();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 6:
				System.out.println("Enter new avenger's name(DO NOT GIVE ANY SPACES), mission name"+"\n"+"Please enter line separated input.");
				String newName = sc.nextLine();
				String existingMission = sc.nextLine();
				try {
					missionRepositories.addAnotherAvenger(newName, existingMission);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 7:
				System.exit(0);
			}
			System.out.println();
		}

	}

}
