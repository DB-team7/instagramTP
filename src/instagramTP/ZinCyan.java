package instagramTP;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class ZinCyan {
	private static String dburl = "jdbc:mysql://localhost/dmaster";
	private static String dbUser = "root";
	private static String dbpasswd = "12345";

	public static Post getPostbyPID(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select cnt_like, user_id , content, created_at, cnt_like from posts where post_id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행
		Post list = new Post();

		rs.next();
		list.setPID(rs.getInt(1));
		list.setUID(rs.getInt(2));
		list.setContent(rs.getString(3));
		list.setCreatDate(rs.getDate(4));
		list.setCntLike(rs.getInt(5));

		return list;

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
	
	public static String getUserNamebyPID(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select name from users where ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		return rs.getString(1);

	}

	public static String getTimeBack(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");

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
