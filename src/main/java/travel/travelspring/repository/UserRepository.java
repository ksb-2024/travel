package travel.travelspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//JPQL select u from User u where u.username = ?
		Optional<User> findByUsername(String username);
}
