package VolunteerManager.VolunteerMangementSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import VolunteerManager.VolunteerMangementSystem.JWTSecurity.GuyEvent;

public interface VolunteerAndEventInterface extends JpaRepository<VolunteerWithRegisteredEvent, Integer>{

	public void deleteByvolunteername(String volunteername);

	public List<VolunteerWithRegisteredEvent> findAllByeventnameregistered(String s);
}
