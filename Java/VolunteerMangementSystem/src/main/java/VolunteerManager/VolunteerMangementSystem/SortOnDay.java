package VolunteerManager.VolunteerMangementSystem;

import java.util.Comparator;

public class SortOnDay implements Comparator<AllEvents> {

	@Override
	public int compare(AllEvents o1, AllEvents o2) {
		// TODO Auto-generated method stub
		int day1=o1.date_of_event.getDay();
		int day2=o2.date_of_event.getDay();
		
		if(day1<day2)
		{
			return -1;
		}
		else if(day1>day2)
		{
			return +1;
		}
		else
		{
			return 0;
		}
		
		
		
	}

}
