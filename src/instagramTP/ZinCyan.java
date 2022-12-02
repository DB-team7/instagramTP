package instagramTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		ps.close();

		Post list = new Post();

		rs.next();
		list.setPID(rs.getInt(1));
		list.setUID(rs.getString(2));
		list.setContent(rs.getString(3));
		list.setCreateDate(rs.getTimestamp(4));
		list.setCntLike(rs.getInt(5));
		rs.close();

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
		ps.close();

		rs.next();
		String tmp = rs.getString(1);
		rs.close();
		return tmp + " Likes";

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

		String sql = "select user_id from posts where ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행
		ps.close();

		rs.next();
		String tmp = rs.getString(1);
		rs.close();
		return tmp;

	}

	public static String getUserNameByUID(String UID) throws SQLException {
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
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행
		ps.close();

		rs.next();
		String tmp = rs.getString(1);
		rs.close();
		return tmp;

	}

	public static String getTimeBack(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select created_at from posts where ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행
		ps.close();

		rs.next();
		long timebackTimestamp = (System.currentTimeMillis() - rs.getTimestamp(1).getTime()) / 1000;
		rs.close();
		if (timebackTimestamp < 60) {
			return "few seconds ago";
		} else if (timebackTimestamp < 3600) {
			return (timebackTimestamp / 60) + "min ago";
		} else if (timebackTimestamp < 86400) {
			return (timebackTimestamp / 3600) + "hour ago";
		} else {
			return (timebackTimestamp / 86400) + "day ago";
		}
	}

	public static void initPost(Post post, String src) throws SQLException, FileNotFoundException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		if (src == null) {
			PreparedStatement ps = null; // 객체 생성

			String sql = "insert into posts(user_id) values (?,?,?,?,?,?); ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, post.getUID());
			ps.setString(2, post.getContent());
			ps.setTimestamp(3, post.getCreateDate());
			ps.setInt(4, 0);
			ps.setString(5, null);
			ps.setBinaryStream(6, null);// Stream형의 파일 업로드
			int rs = ps.executeUpdate(); // 명렁어 실행
			ps.close();
			System.out.println("Inserting Successfully!");
		} else {
			File imgfile = new File(src);
			FileInputStream fin = new FileInputStream(imgfile);
			PreparedStatement ps = null; // 객체 생성

			String sql = "insert into posts(user_id) values (?,?,?,?,?,?); ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, post.getUID());
			ps.setString(2, post.getContent());
			ps.setTimestamp(3, post.getCreateDate());
			ps.setInt(4, 0);
			ps.setString(5, post.getCreateDate().toString());
			ps.setBinaryStream(6, fin, (int) imgfile.length());// Stream형의 파일 업로드
			int rs = ps.executeUpdate(); // 명렁어 실행
			ps.close();
			System.out.println("Inserting Successfully!");
		}
	}

	public static Integer getPostNum(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(ID) from posts where id = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행
		ps.close();

		rs.next();
		Integer postNumInteger = rs.getInt(1);
		rs.close();
		return postNumInteger;
	}


}
