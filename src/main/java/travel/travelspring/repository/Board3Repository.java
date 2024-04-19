package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import travel.travelspring.domain.Board3;

public interface Board3Repository extends JpaRepository<Board3, Long>, JpaSpecificationExecutor<Board3>{

	public List<Board3> findAllByOrderByLikeCount3Desc();
}
