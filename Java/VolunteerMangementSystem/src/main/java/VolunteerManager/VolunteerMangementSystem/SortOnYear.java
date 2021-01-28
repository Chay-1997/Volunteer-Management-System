package VolunteerManager.VolunteerMangementSystem;

import java.util.Comparator;

public class SortOnYear implements Comparator<AllEvents> {

	@Override
	public int compare(AllEvents o1, AllEvents o2) {
		// TODO Auto-generated method stub
		int y1=o1.date_of_event.getYear();
		int y2=o2.date_of_event.getYear();
		if(y1<y2)
		{
			return -1;
		}
		else if(y1>y2)
		{
			return +1;
		}
		else 
		{
			return 0;
		}
		
	}

}
