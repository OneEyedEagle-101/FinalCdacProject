package Team_13.CdacPortalWithQuiz.controllers;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Team_13.CdacPortalWithQuiz.models.*;

@RestController
public class Controllers {

	@PersistenceContext
	 public EntityManager em;
	@GetMapping("/Home")
	public @ResponseBody String method1()
	{
		User u1 = new User();
		Subject sb1 = new Subject();
		StudentDataManagement s1 = new StudentDataManagement();
		ScoreDetails sd1 = new ScoreDetails();
		RecordingsManagement rm1 = new RecordingsManagement();
		Question q1 = new Question();
		Options op1 = new Options();
		Notices n1 = new Notices();
		Notes not =new Notes();
		return "Hello";
		
	}
	
	
}
