package instagramTP;

import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
import java.sql.*;

public class ZinCyan {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb1?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "Michael";
	private static String dbpasswd = "Michael@dbclass";

	public static int getPost(String[] args) throws SQLException {
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

		String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, roleId);
		rs = ps.executeQuery(); // ���� ����

	}

	public static void insertImage(String[] args) {
		System.out.println("Insert Image Example!");
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "����";
		String userName = "root";
		String password = "��ȣ";
		Connection con = null;
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			Statement st = conn.createStatement();
			File imgfile = new File("d:\\images.jpg");
			FileInputStream fin = new FileInputStream(imgfile);
			PreparedStatement ps = conn.prepareStatement("insert into tbl_test (ID, FILENAME, FILE) VALUES (?, ?, ?)");
			ps.setInt(1, 5);
			ps.setString(2, "Durga");
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
