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
public class NReply {
// 공지 사항 댓글
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nrno;
	private Long nno;
	private String nrcontent;
	private String nreplyer;
	private LocalDateTime nrdate;
	private LocalDateTime nrupdate;

}
