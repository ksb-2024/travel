package travel.travelspring.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Users")
public class User {
// 회원
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    private String username;
    private String userpw;
    private String useremail;
    private Integer userbirth;
    private String usertel;
    private String usergender;
    private String userimgfile;
    private String introduction;
    private LocalDate signupday;
    private LocalDate modifiedday;

}
