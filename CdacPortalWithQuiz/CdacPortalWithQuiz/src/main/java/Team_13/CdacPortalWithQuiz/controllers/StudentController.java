package Team_13.CdacPortalWithQuiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Team_13.CdacPortalWithQuiz.DTO.StudentDashboardDTO;
import Team_13.CdacPortalWithQuiz.models.ScoreDetails;
import Team_13.CdacPortalWithQuiz.models.User;
import Team_13.CdacPortalWithQuiz.repository.StudentRepository;


@RestController
public class StudentController {

	@Autowired
	StudentRepository stdrepo;
	@PostMapping("/Student")
	public List<ScoreDetails> dashBoard(@RequestBody User student)
	{
		return stdrepo.dashBoard(student);
		
	}
}
