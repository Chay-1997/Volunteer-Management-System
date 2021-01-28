package VolunteerManager.VolunteerMangementSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VolunteerInterface extends JpaRepository<Volunteers, Integer>{
	
	public void deleteByvolunteername(String volunteername);
	public Volunteers findByvolunteername(String volunteername);
	public Volunteers findByemail(String email);
	
	@Query("Select vl from Volunteers vl where vl.review LIKE ?1%")
	public List<Volunteers> findByreview(String name);

}
