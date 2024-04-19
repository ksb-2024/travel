package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import travel.travelspring.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>, JpaSpecificationExecutor<Board>{

	public List<Board> findAllByOrderByBnoDesc();
	public List<Board> findAllByOrderByLikeCountDesc();
}
