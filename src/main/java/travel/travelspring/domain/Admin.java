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
@Table(name = "Admins")
public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nuserid;
	
	private String nusername;
	private String nuserpw;
	private LocalDate nsignupday;
}
