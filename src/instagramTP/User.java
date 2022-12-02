package instagramTP;

public class User {
	
	private String userID; //ID
	private String userName; //name
	private int userPhoneNum; //phone_num
	private String userEmail; //email
	private String userPassword; //password
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getUserPhoneNum() {
		return userPhoneNum;
	}
	public void setUserPhoneNum(int userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}


