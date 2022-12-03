package instagramTP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO { //회원 테이블에 접근할 수 있도록 DAP(데이터 접근 객체) 생성

	private Connection conn; //데이터베이스에 접근하게 해주는 하나의 객체 
	private PreparedStatement pstmt;
	private ResultSet rs; //어떠한 정보를 담을 수 있는 하나의 객체
	
	public UserDAO() {
		try {
			String dbURL="jdbc:mysql://localhost/dmaster"; //jdbc:mysql://localhost/사용할db이름
			String dbID="root"; //계정
			String dbPassword="12345"; //비밀번호
			Class.forName("com.mysql.jdbc.Driver"); //mysql driver 찾을 수 있도록
			conn=DriverManager.getConnection(dbURL,dbID,dbPassword); //접속이 완료되면 conn 객체 안에 정보가 담기게 됨
		}catch(Exception e) {
			e.printStackTrace(); //오류 발생시 어떤 오류인지 출력
		}
	}
	/*
	//JoinFrame에 아이디 중복 체크와 합해서 수정 후 넣음
	//회원가입
	public int join(User user) {
		String SQL="insert into users values (?,?,?,?,?)"; //id, name, phone_num, email, pw
		try {
			pstmt=conn.prepareStatement(SQL); //sql 문장을 데이터베이스에 삽입
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserName());
			pstmt.setInt(3, user.getUserPhoneNum());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setString(5, user.getUserPassword());
			
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	*/
	
	//로그인
	public int Login(String userID, String userPassword) {
		String SQL="SELECT password FROM users WHERE ID = ?";
		try {
			pstmt=conn.prepareStatement(SQL); //sql 문장을 데이터베이스에 삽입
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery(); //rs : 결과를 담을 수 있는 하나의 객체. 여기에 실행 결과를 넣어줌
			if(rs.next()) { //rs.next() : 결과가 존재한다면 해당 if문 실행
				if(rs.getString(1).equals(userPassword))
					return 1; //로그인 성공
				else
					return 0; // 비밀번호 불일치
			}
			return -1; //아이디 없음
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2; //데이터베이스 오류
	}

}

//Reference
//https://green333.tistory.com/28