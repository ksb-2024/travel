package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.Reply1;

public interface Reply1Repository extends JpaRepository<Reply1, Long>{
	
	public List<Reply1> findAllByBno1(Long bno);
	public Long countByBno1(Long bno);
}
