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
public class Blike1 {
// 동행자 찾기 게시글 좋아요
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long likeno1;
	
	private Long bno1;
	private String username1;
	
}
