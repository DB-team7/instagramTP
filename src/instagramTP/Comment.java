package instagramTP;

public class Comment {

	private Integer CID;
	private String UID;
	private Integer PID;
	private String content;
	private java.sql.Timestamp createDate;
	private Integer cntLike;

	public Integer getCID() {
		return CID;
	}

	public void setCID(Integer cID) {
		CID = cID;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public Integer getPID() {
		return PID;
	}

	public void setPID(Integer pID) {
		PID = pID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCntLike() {
		return cntLike;
	}

	public void setCntLike(Integer cntLike) {
		this.cntLike = cntLike;
	}

}
