package Repositories;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Models.Avenger;

public class AvengerRepository implements IAvengerRepository{
	static HashMap<String, Avenger> avengerHash = new HashMap<>();
	Set<String> avengersSet = new HashSet<>();
	@Override
	public void initializeAvengers() {
		String[] str = new String[6];
		str[0] = "IronMan";
		str[1] = "CaptainAmerica";
		str[2] = "Hulk";
		str[3] = "Thor";
		str[4] = "BlackWidow";
		str[5] = "Hawkeye";
		for (int i = 0; i < 6; i++) {
			Avenger card = new Avenger();
			card.setName(str[i]);
			card.setTotalMissions(0);
			card.setMissionName(null);
			avengerHash.put(str[i], card);
		}
	}

	public static void getAllDetails() {
		for (Map.Entry<String, Avenger> entry : avengerHash.entrySet()) {
			System.out.println("----------------------------------");
			System.out.println(entry.getKey() + ": " + entry.getValue().getMissionName() + "\t" + "total missions: "
					+ entry.getValue().getTotalMissions());
		}
	}

}
