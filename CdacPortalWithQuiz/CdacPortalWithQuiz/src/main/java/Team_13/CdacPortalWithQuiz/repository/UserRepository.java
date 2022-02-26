package Team_13.CdacPortalWithQuiz.repository;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import Team_13.CdacPortalWithQuiz.DTO.LoginStatusDto;

import Team_13.CdacPortalWithQuiz.models.User;
@Repository
public class UserRepository {

	@PersistenceContext
	public EntityManager em;
	
		@Transactional
       public boolean registerUser(User u1)
       {
		   System.out.println(u1.getEmail());
		   User us=(User)em.createQuery("select u from User u where u.email= :email").setParameter("email",u1.getEmail()).getResultList().stream().findFirst().orElse(null);
		   System.out.println(us);
		   if(us==null)
    	   {
		   em.persist(u1);
		   return true;
    	   }
    	   return false;
    	    
       }
	@Transactional
       public LoginStatusDto loginVerify(String emailId,String password)
       {
		   LoginStatusDto loginStatus = new LoginStatusDto();
		   User us=(User)em.createQuery("select u from User u where u.email= :email").setParameter("email",emailId).getResultList().stream().findFirst().orElse(null);
		   if(us==null)
    	   {
			   loginStatus.setEmail(false); 
			   return loginStatus;
    	   }
		   else if(!us.getPassword().equals(password))
		   {
			   loginStatus.setEmail(true);
			   loginStatus.setPassword(false);
			   return loginStatus;
		   }
		   else if(!us.isActive())
		   {
			   loginStatus.setEmail(true);
			   loginStatus.setPassword(true);
			   loginStatus.setActive(false);
	    	   return loginStatus;
		   }
		   loginStatus.setUser(us);
		   loginStatus.setActive(true);
		   loginStatus.setPassword(true);
		   loginStatus.setEmail(true);
		   return loginStatus;
       }
       
	@Transactional
    public void updatePassword(String emailId,String password)
    {
		   User us=(User)em.createQuery("select u from User u where u.email= :email").setParameter("email",emailId).getSingleResult();
		   System.out.println(us.getEmail());
		   us.setPassword(password);
		   em.merge(us);
    }
	
       public List<User> getAllUsers()
       {
    	  Query q= em.createQuery("select s from User s where s.role=faculty");
    	  List<User> facultylist = q.getResultList();
    	  return facultylist; 
       }
       
       public User getUserById(int id)
       {
    	  User user = em.find(User.class, id);
    	  return user;
       }
       
       public User updateUser(User u1)
       {
    	   User user = em.merge(u1);
    	   return user;
       }
       
       public List<User> getAllStudents()
       {
    	  Query q= em.createQuery("select s from User s where s.role = student");
    	  List<User> stdlist = q.getResultList();
    	  return stdlist; 
       }
       
       @Transactional
       public boolean checkUserExist(String email)
       {
    	   User us=(User)em.createQuery("select u from User u where u.email= :email").setParameter("email",email).getResultList().stream().findFirst().orElse(null);
    	   if(us==null)
    	   {
    		   return false;
    	   }
    	   return true;
       }
}
