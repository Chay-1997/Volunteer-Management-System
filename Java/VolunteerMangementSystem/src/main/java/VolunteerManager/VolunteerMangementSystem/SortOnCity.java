package VolunteerManager.VolunteerMangementSystem;

import java.util.Comparator;

public class SortOnCity implements Comparator<AllEvents> {

	@Override
	public int compare(AllEvents o1, AllEvents o2) {
		// TODO Auto-generated method stub
		String s1=o1.getCity();
		String s2=o2.getCity();
		
		return s1.compareTo(s2);
		
		
	}

}
