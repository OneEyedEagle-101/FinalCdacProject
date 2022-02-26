package Team_13.CdacPortalWithQuiz.DTO;

import Team_13.CdacPortalWithQuiz.models.User;

public class LoginStatusDto {
	
	private User user;
	private boolean email;
	private boolean password;
	private boolean active;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isEmail() {
		return email;
	}
	public void setEmail(boolean email) {
		this.email = email;
	}
	public boolean isPassword() {
		return password;
	}
	public void setPassword(boolean password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

}
