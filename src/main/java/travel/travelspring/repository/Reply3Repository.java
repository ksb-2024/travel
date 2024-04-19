package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.Reply3;

public interface Reply3Repository extends JpaRepository<Reply3, Long>{
	
	public List<Reply3> findAllByBno3(Long bno);
	public Long countByBno3(Long bno);
}
