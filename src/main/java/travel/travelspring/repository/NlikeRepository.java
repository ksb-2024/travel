package travel.travelspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.Nlike;

public interface NlikeRepository extends JpaRepository<Nlike, Long>{
	
	public boolean existsByNnoAndNusername(Long nno, String nusername);
	public Nlike findByNnoAndNusername(Long nno, String nusername);
}
