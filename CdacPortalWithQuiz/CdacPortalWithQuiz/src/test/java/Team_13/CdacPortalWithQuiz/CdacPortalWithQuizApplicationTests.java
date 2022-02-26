package Team_13.CdacPortalWithQuiz;

import java.util.Random;

import org.hibernate.sql.SelectFragment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CdacPortalWithQuizApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void otpGen()
	{
		String otp = "";
		Random rnd = new Random();
	    String selectFrom="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		while(otp.length()<6)
		{
			char ch = selectFrom.charAt(rnd.nextInt(selectFrom.length()));
			otp=otp+ch;
		}
		System.out.println(otp);
	
	}
}
