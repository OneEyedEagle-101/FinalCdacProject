package Team_13.CdacPortalWithQuiz.models;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;


@Entity
public class Notices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noticeId;
	@Column(length=9000)
	@Type(type="text")
	private String notice;
	@OneToOne
	private User user;
	private LocalDate uploadDate;
	
}
