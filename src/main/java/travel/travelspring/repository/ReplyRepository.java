package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
	
	public List<Reply> findAllByBno(Long bno);
	public Long countByBno(Long bno);
}
