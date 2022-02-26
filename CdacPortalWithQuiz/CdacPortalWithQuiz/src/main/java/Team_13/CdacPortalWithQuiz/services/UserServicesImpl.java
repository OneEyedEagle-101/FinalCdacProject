package Team_13.CdacPortalWithQuiz.services;

import java.security.MessageDigest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Team_13.CdacPortalWithQuiz.DTO.LoginStatusDto;
import Team_13.CdacPortalWithQuiz.models.User;
import Team_13.CdacPortalWithQuiz.repository.UserRepository;
@Service
public class UserServicesImpl {
	
	@Autowired
	UserRepository userrepo;
	@Autowired
	MailService mail;
	@Autowired
	OtpGenerator otpgen;
	MessageDigest md;
	
	public boolean registerService(User u1)
	{
		try {
		md=MessageDigest.getInstance("MD5");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		md.update(u1.getPassword().getBytes());
		byte[] hashpsw =md.digest();
		String psw = DatatypeConverter.printHexBinary(hashpsw).toUpperCase();
		u1.setPassword(psw);
		boolean status = userrepo.registerUser(u1);
		if(status)
		{
			mail.sendSimpleMessage(u1.getEmail());
			return true;
		}
		return false;	
	}
	
	public LoginStatusDto loginService(String email, String password)
	{
		try {
			md=MessageDigest.getInstance("MD5");
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		md.update(password.getBytes());
		byte[] psw = md.digest();
		String hashpsw = DatatypeConverter.printHexBinary(psw).toUpperCase();
		return userrepo.loginVerify(email,hashpsw);
	}
	
	public boolean passwordUpdateService(String email, String password)
	{
		try {
			md=MessageDigest.getInstance("MD5");
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		md.update(password.getBytes());
		byte[] psw = md.digest();
		String hashpsw = DatatypeConverter.printHexBinary(psw).toUpperCase();
		userrepo.updatePassword(email,hashpsw);
		return true;
	}
	
	public boolean sendOtp(String email)
	{
	
		String otp=otpgen.otpGen();
		if(userrepo.checkUserExist(email))
		{
			mail.sendSimpleMessage(email,otp);
			return true;
		}
		else
			return false;
		
	}

}







