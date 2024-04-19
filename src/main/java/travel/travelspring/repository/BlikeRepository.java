package travel.travelspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travel.travelspring.domain.Blike;

public interface BlikeRepository extends JpaRepository<Blike, Long>{
	
	public boolean existsByBnoAndUsername(Long bno, String username);
	public Blike findByBnoAndUsername(Long bno, String username);
	public List<Blike> findAllByUsernameOrderByLikenoDesc(String username);
}
