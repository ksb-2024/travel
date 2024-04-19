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
public class Notice {
// 공지사항

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nno;
	private String ntitle;
	private String ncontent;
	private LocalDate ncreateDate;
	private LocalDate nmodifyDate;
	private Long nhit;
	private String nfilename;
	private String nusername;
	private Long nreply_count;
	private Long nlikeCount;
}
