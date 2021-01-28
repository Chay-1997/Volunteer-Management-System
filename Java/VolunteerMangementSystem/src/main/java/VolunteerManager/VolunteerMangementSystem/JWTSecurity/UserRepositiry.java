package VolunteerManager.VolunteerMangementSystem.JWTSecurity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositiry extends JpaRepository<User,Long> {

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	Optional<User> findByUsername(String username);

}
