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
			System.out.println("���� ����");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("����: " + e);
		}

		PreparedStatement ps = null; // ��ü ����

		String sql = "select cnt_like, user_id , content, created_at from posts where post_id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // ���� ����

		rs.next();
		return rs.getInt(1) + " Likes";

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

	public static String getTimeBack(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/mysql";
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
			ps.setBinaryStream(3, fin, (int) imgfile.length());// Stream���� ���� ���ε�
			ps.executeUpdate();
			System.out.println("Inserting Successfully!");
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
