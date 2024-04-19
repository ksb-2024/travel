package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import travel.travelspring.domain.Board;
import travel.travelspring.domain.Board1;

public interface Board1Repository extends JpaRepository<Board1, Long>, JpaSpecificationExecutor<Board1>{

	public List<Board1>  findAllByOrderByBno1Desc();
	public List<Board1> findAllByOrderByLikeCount1Desc();
}
