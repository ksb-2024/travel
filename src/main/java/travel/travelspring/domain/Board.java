package travel.travelspring.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Board {
// 여행 후기

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	
	private String title;
	private String content;
	private LocalDate createDate;
	private LocalDate modifyDate;
	private Long hit;
	private String filename;
	private String username;
	private Long reply_count;
	private Long likeCount;
}
