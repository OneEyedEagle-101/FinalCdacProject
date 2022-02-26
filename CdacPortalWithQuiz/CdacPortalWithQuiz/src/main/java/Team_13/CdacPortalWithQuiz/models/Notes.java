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
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notesId;
	@Column(length = 1000)
	@Type(type="text")
	private String notelink;
	private String topicName;
	@OneToOne
	private User user;
	private LocalDate uploadDate;
	public int getNotesId() {
		return notesId;
	}
	public void setNotesId(int notesId) {
		this.notesId = notesId;
	}
	public String getNotelink() {
		return notelink;
	}
	public void setNotelink(String notelink) {
		this.notelink = notelink;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}
	
}
