package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.Blike3;

public interface Blike3Repository extends JpaRepository<Blike3, Long>{
	
	public boolean existsByBno3AndUsername3(Long bno, String username);
	public Blike3 findByBno3AndUsername3(Long bno, String username);
	public List<Blike3> findAllByUsername3OrderByLikeno3Desc(String username);
}
