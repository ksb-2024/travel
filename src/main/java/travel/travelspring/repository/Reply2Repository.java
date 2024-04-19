package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.Reply2;

public interface Reply2Repository extends JpaRepository<Reply2, Long>{
	
	public List<Reply2> findAllByBno2(Long bno);
	public Long countByBno2(Long bno);
}
