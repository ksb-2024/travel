package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import travel.travelspring.domain.Board;
import travel.travelspring.domain.Board1;
import travel.travelspring.domain.Board2;

public interface Board2Repository extends JpaRepository<Board2, Long>, JpaSpecificationExecutor<Board2>{

	public List<Board2>  findAllByOrderByBno2Desc();
	public List<Board2> findAllByOrderByLikeCount2Desc();
}
