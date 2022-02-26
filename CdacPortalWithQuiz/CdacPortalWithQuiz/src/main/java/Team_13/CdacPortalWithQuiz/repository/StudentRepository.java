package Team_13.CdacPortalWithQuiz.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import Team_13.CdacPortalWithQuiz.DTO.StudentDashboardDTO;
import Team_13.CdacPortalWithQuiz.models.ScoreDetails;
import Team_13.CdacPortalWithQuiz.models.User;

@Repository
public class StudentRepository {

	@PersistenceContext
	EntityManager em;
	
	public List<ScoreDetails> dashBoard(User student)
	{
		List<ScoreDetails> scoreList =  new ArrayList<>();
		scoreList = em.createQuery("select s from ScoreDetails s where s.userID.portalId=:id").setParameter("id", student.getPortalId()).getResultList();
		return scoreList;
	}
}
