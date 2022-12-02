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
			System.out.println("���� ����");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}

		PreparedStatement ps = null; // ��ü ����

		String sql = "select cnt_like, user_id , content, created_at, cnt_like from posts where post_id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // ���� ����
		Post list = new Post();

		rs.next();
		list.setPID(rs.getInt(1));
		list.setUID(rs.getString(2));
		list.setContent(rs.getString(3));
		list.setCreateDate(rs.getTimestamp(4));
		list.setCntLike(rs.getInt(5));

		return list;

	}

	public static String getLikeNum(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���� ����");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}

		PreparedStatement ps = null; // ��ü ����

		String sql = "select count(target_id) as cnt_likes from likes where target_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // ���� ����

		rs.next();
		return rs.getInt(1) + " Likes";

	}

	public static String getUserNamebyPID(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���� ����");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}

		PreparedStatement ps = null; // ��ü ����

		String sql = "select user_id from posts where ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // ���� ����

		rs.next();
		return rs.getString(1);

	}

	public static String getUserNameByUID(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���� ����");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}

		PreparedStatement ps = null; // ��ü ����

		String sql = "select name from users where ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // ���� ����

		rs.next();
		return rs.getString(1);

	}

	public static String getTimeBack(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}

		PreparedStatement ps = null; // ��ü ����

		String sql = "select created_at from posts where ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // ���� ����

		rs.next();
		long timebackTimestamp = (System.currentTimeMillis() - rs.getTimestamp(1).getTime()) / 1000;

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
			System.out.println("���� ����");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}

		if (src == null) {
			PreparedStatement ps = null; // ��ü ����

			String sql = "insert into posts(user_id) values (?,?,?,?,?,?); ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, post.getUID());
			ps.setString(2, post.getContent());
			ps.setTimestamp(3, post.getCreateDate());
			ps.setInt(4, 0);
			ps.setString(5, null);
			ps.setBinaryStream(6, null);// Stream���� ���� ���ε�
			int rs = ps.executeUpdate(); // ���� ����
			System.out.println("Inserting Successfully!");
		} else {
			File imgfile = new File(src);
			FileInputStream fin = new FileInputStream(imgfile);
			PreparedStatement ps = null; // ��ü ����

			String sql = "insert into posts(user_id) values (?,?,?,?,?,?); ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, post.getUID());
			ps.setString(2, post.getContent());
			ps.setTimestamp(3, post.getCreateDate());
			ps.setInt(4, 0);
			ps.setString(5, post.getCreateDate().toString());
			ps.setBinaryStream(6, fin, (int) imgfile.length());// Stream���� ���� ���ε�
			int rs = ps.executeUpdate(); // ���� ����
			System.out.println("Inserting Successfully!");
		}
	}

//	public static void insertImage(String src, Integer PID) throws SQLException {
//		System.out.println("Insert Image Example!");
//		String driverName = "com.mysql.jdbc.Driver";
//		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
//		try {
//			Class.forName(driverName);
//			Statement st = conn.createStatement();
//			File imgfile = new File(src);
//			FileInputStream fin = new FileInputStream(imgfile);
//			PreparedStatement ps = conn.prepareStatement("insert into tbl_test (FILENAME, FILE) VALUES (?, ?)");
//			ps.setInt(1, PID);
//			ps.setString(2, Integer.toString(PID));
//			ps.setBinaryStream(3, fin, (int) imgfile.length());// Stream���� ���� ���ε�
//			ps.executeUpdate();
//			System.out.println("Inserting Successfully!");
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}

}
