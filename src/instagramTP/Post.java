package instagramTP;

import java.io.InputStream;

public class Post {

	private Integer PID;
	private String UID;
	private String content;
	private java.sql.Timestamp createDate;
	private Integer cntLike;
	private InputStream inputStream;

	public Integer getPID() {
		return PID;
	}

	public void setPID(Integer pID) {
		PID = pID;
	}


	public Integer getCntLike() {
		return cntLike;
	}

	public void setCntLike(Integer cntLike) {
		this.cntLike = cntLike;
	}

	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
