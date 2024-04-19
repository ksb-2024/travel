package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.Blike2;

public interface Blike2Repository extends JpaRepository<Blike2, Long>{
	
	public boolean existsByBno2AndUsername2(Long bno, String username);
	public Blike2 findByBno2AndUsername2(Long bno, String username);
	public List<Blike2> findAllByUsername2OrderByLikeno2Desc(String username);
}
