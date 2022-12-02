package instagramTP;

import java.sql.Date;

public class Post {

	private Integer PID;
	private Integer UID;
	private String content;
	private Date createDate;
	private Integer cntLike;

	public Integer getPID() {
		return PID;
	}

	public void setPID(Integer pID) {
		PID = pID;
	}

	public Integer getUID() {
		return UID;
	}

	public void setUID(Integer uID) {
		UID = uID;
	}

	public Integer getCntLike() {
		return cntLike;
	}

	public void setCntLike(Integer cntLike) {
		this.cntLike = cntLike;
	}

	public Date getCreatDate() {
		return createDate;
	}

	public void setCreatDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
