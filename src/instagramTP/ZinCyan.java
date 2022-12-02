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
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, roleId);
		rs = ps.executeQuery(); // 명렁어 실행

	}

	public static void insertImage(String[] args) {
		System.out.println("Insert Image Example!");
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "디비명";
		String userName = "root";
		String password = "암호";
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
