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
public class Blike2 {
// 나의 계획 게시글 좋아요
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long likeno2;
	
	private Long bno2;
	private String username2;
	
}
