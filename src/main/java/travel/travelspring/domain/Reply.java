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
public class Reply {
// 여행 후기 댓글
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rno;
	private Long bno;
	private String rcontent;
	private String replyer;
	private LocalDateTime rdate;
	private LocalDateTime rupdate;

}
