package VolunteerManager.VolunteerMangementSystem.JWTSecurity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import VolunteerManager.VolunteerMangementSystem.Volunteers;

public interface EventGuyInterface extends JpaRepository<GuyEvent, Integer> {

	List<GuyEvent> findAllById(int id);

}
