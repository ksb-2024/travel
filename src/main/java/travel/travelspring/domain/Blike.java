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
public class Blike {
// 여행 후기 게시글 좋아요
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long likeno;
	
	private Long bno;
	private String username;
	
}
