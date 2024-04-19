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
public class Reply1 {
// 동행자 찾기 댓글
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rno1;
	private Long bno1;
	private String rcontent1;
	private String replyer1;
	private LocalDateTime rdate1;
	private LocalDateTime rupdate1;

}
