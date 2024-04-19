package travel.travelspring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Blike3 {
// Q&A 게시글 좋아요
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long likeno3;
	
	private Long bno3;
	private String username3;
	
}
