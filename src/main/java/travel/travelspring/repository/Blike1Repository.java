package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.Blike1;

public interface Blike1Repository extends JpaRepository<Blike1, Long>{
	
	public boolean existsByBno1AndUsername1(Long bno, String username);
	public Blike1 findByBno1AndUsername1(Long bno, String username);
	public List<Blike1> findAllByUsername1OrderByLikeno1Desc(String username);
}
