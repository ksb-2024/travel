package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.NReply;

public interface NReplyRepository extends JpaRepository<NReply, Long>{
	
	public List<NReply> findAllByNno(Long nno);
	public Long countByNno(Long nno);
}
