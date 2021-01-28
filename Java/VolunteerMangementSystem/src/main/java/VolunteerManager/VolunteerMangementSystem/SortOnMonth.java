package VolunteerManager.VolunteerMangementSystem;

import java.util.Comparator;

public class SortOnMonth implements Comparator<AllEvents> {

	@Override
	public int compare(AllEvents o1, AllEvents o2) {
		// TODO Auto-generated method stub
		
		int m1=o1.date_of_event.getMonth();
		int m2=o2.date_of_event.getMonth();
		if(m1<m2)
		{
			return -1;
			
		}
		else if(m1>m2)
		{
			return +1;
		}else
		{
			return 0;
		}
		
	}

}
