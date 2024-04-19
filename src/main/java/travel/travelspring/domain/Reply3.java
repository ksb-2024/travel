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
public class Reply3 {
// Q&A 댓글
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rno3;
	private Long bno3;
	private String rcontent3;
	private String replyer3;
	private LocalDateTime rdate3;
	private LocalDateTime rupdate3;

}
