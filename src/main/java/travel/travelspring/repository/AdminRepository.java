package travel.travelspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	//JPQL select ad from Admin ad where ad.nusername = ?
		Optional<Admin> findByNusername(String nusername);
		
		boolean existsByNusername(String nusername);
}
