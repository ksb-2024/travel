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
public class Board1 {
// 동행자 찾기

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno1;
	private String title1;
	private String content1;
	private LocalDate createDate1;
	private LocalDate modifyDate1;
	private Long hit1;
	private String filename1;
	private String username1;
	private Long reply_count1;
	private Long likeCount1;
}
