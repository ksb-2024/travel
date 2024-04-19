package travel.travelspring.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reply2 {
// 나의 계획 댓글
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rno2;
	private Long bno2;
	private String rcontent2;
	private String replyer2;
	private LocalDateTime rdate2;
	private LocalDateTime rupdate2;

}
