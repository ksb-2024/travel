package travel.travelspring.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Board2 {
// 나의 계획
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno2;
	private String title2;
	private String content2;
	private LocalDate createDate2;
	private LocalDate modifyDate2;
	private Long hit2;
	private String filename2;
	private String username2;
	private Long reply_count2;
	private Long likeCount2;
}
