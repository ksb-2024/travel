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
public class Board3 {
// Q&A

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno3;
	private String title3;
	private String content3;
	private LocalDate createDate3;
	private LocalDate modifyDate3;
	private Long hit3;
	private String filename3;
	private String username3;
	private Long reply_count3;
	private Long likeCount3;
}
