package Team_13.CdacPortalWithQuiz.controllers;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Team_13.CdacPortalWithQuiz.DTO.LoginStatusDto;
import Team_13.CdacPortalWithQuiz.models.User;
import Team_13.CdacPortalWithQuiz.repository.UserRepository;
import Team_13.CdacPortalWithQuiz.services.MailService;
import Team_13.CdacPortalWithQuiz.services.OtpGenerator;
import Team_13.CdacPortalWithQuiz.services.UserServicesImpl;

@RestController
public class UserController {

	@Autowired
	UserServicesImpl uservice;
	@Autowired
	OtpGenerator op1;
	
	@PostMapping("/register")
	public boolean registerUser(@RequestBody User user)
	{
		boolean status = uservice.registerService(user);
		return status;
	}
	@PostMapping("/login")
	public LoginStatusDto loginUser( @RequestParam String email,@RequestParam String password)
	{
		return uservice.loginService(email, password);
	}
	@PostMapping("/ForgetPasswordGenerateOtp")
	public String generateOtp(@RequestParam String email)
	{
		if(uservice.sendOtp(email))
		{
		return "otp has been sent to your registered mail";
		}
		return "Not a registered email";
	}
	@PostMapping("/verifyOtp")
	public boolean verifyOtp(@RequestParam String otp)
	{
		
		if(op1.verifyOtp(otp))
		{
		   return true;
		}
		return false;
	}
	@PostMapping("/updatePassword")
	public boolean updatePassword(@RequestParam String newPassword,@RequestParam String email )
	{
		uservice.passwordUpdateService(email, newPassword);
	    return true;
	}
}
