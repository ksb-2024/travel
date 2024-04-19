package travel.travelspring.controller;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {

	private String username;
    private String userpw;
    private String useremail;
    private Integer userbirth;
    private String userphone;
    private String usergender;
    private String image;
    private String introduction;
    private LocalDate signupday;
    private LocalDate modifiedday;
}
