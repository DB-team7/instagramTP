package instagramTP;

import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
import java.sql.*;

public class ZinCyan {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb1?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "Michael";
	private static String dbpasswd = "Michael@dbclass";

	public static String getPostbyPID(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/mysql";
			conn = DriverManager.getConnection(url, "root", "12345");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select cnt_like, user_id , content, created_at from posts where post_id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		return rs.getInt(1) + " Likes";

	}

	public static String getLikeNum(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(target_id) as cnt_likes from likes where target_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		return rs.getInt(1) + " Likes";

	}

	public static String getTimeBack(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/mysql";
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(target_id) as cnt_likes from likes where target_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		return rs.getInt(1) + " Likes";

	}

	public static void insertImage(int PID) throws SQLException {
		System.out.println("Insert Image Example!");
		String driverName = "com.mysql.jdbc.Driver";
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName(driverName);
			Statement st = conn.createStatement();
			File imgfile = new File("d:\\images.jpg");
			FileInputStream fin = new FileInputStream(imgfile);
			PreparedStatement ps = conn.prepareStatement("insert into tbl_test (ID, FILENAME, FILE) VALUES (?, ?, ?)");
			ps.setInt(1, PID);
			ps.setString(2, Integer.toString(PID));
			ps.setBinaryStream(3, fin, (int) imgfile.length());// Stream형의 파일 업로드
			ps.executeUpdate();
			System.out.println("Inserting Successfully!");
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
