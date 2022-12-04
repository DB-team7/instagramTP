package instagramTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class ZinCyan {
	private static String dburl = "jdbc:mysql://localhost/dmaster";
	private static String dbUser = "root";
	private static String dbpasswd = "12345";

	public static Post getPostbyPID(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select ID, user_id , content, created_at, cnt_like, file from posts where ID=?;";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		Post list = new Post();

		rs.next();
		list.setPID(rs.getInt(1));
		list.setUID(rs.getString(2));
		list.setContent(rs.getString(3));
		list.setCreateDate(rs.getTimestamp(4));
		list.setCntLike(rs.getInt(5));
		list.setInputStream(rs.getBinaryStream(6));
		rs.close();
		ps.close();

		return list;

	}

	public static String getLikeNum(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(target_id) as cnt_likes from likes where target_id = ?;";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		String tmp = rs.getString(1);
		rs.close();
		ps.close();
		return tmp + " Likes";

	}

	public static String getUserNamebyPID(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select user_id from posts where ID = ?;";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		System.out.println(PID);
		rs.next();
		String tmp = rs.getString(1);
		System.out.println(tmp);
		rs.close();
		ps.close();
		return tmp;

	}

	public static String getUserNameByUID(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select name from users where ID = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		String tmp = rs.getString(1);
		rs.close();
		ps.close();
		return tmp;

	}

	public static String getTimeBack(int PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select created_at from posts where ID = ?;";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		long timebackTimestamp = (System.currentTimeMillis() - rs.getTimestamp(1).getTime()) / 1000;
		rs.close();
		ps.close();
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
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		System.out.println(src);

		if (src == null) {
			PreparedStatement ps = null; // 객체 생성

			String sql = "insert into posts(user_id, content, created_at, cnt_like, FILENAME, FILE) values (?,?,?,?,?,?); ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, post.getUID());
			ps.setString(2, post.getContent());
			ps.setTimestamp(3, post.getCreateDate());
			ps.setInt(4, 0);
			ps.setString(5, null);
			ps.setBinaryStream(6, null);// Stream형의 파일 업로드
			ps.executeUpdate(); // 명렁어 실행
			ps.close();
			System.out.println("Inserting Successfully!");
		} else {
			File imgfile = new File(src);
			FileInputStream fin = new FileInputStream(imgfile);
			PreparedStatement ps = null; // 객체 생성

			String sql = "insert into posts(user_id, content, created_at, cnt_like, FILENAME, FILE) values (?,?,?,?,?,?); ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, post.getUID());
			ps.setString(2, post.getContent());
			ps.setTimestamp(3, post.getCreateDate());
			ps.setInt(4, 0);
			ps.setString(5, post.getCreateDate().toString());
			ps.setBinaryStream(6, fin, (int) imgfile.length());// Stream형의 파일 업로드
			ps.executeUpdate(); // 명렁어 실행
			ps.close();
			System.out.println("Inserting Successfully!");
		}
	}

	public static void modPost(Post post, String src) throws SQLException, FileNotFoundException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		if (src == null) {
			PreparedStatement ps = null; // 객체 생성

			String sql = "update posts set content = ? where ID = ? ;";
			ps = conn.prepareStatement(sql);
			ps.setString(2, post.getContent());
			ps.setInt(2, post.getPID());
			ps.executeUpdate(); // 명렁어 실행
			ps.close();
			System.out.println("update Successfully!");
		} else {
			File imgfile = new File(src);
			FileInputStream fin = new FileInputStream(imgfile);
			PreparedStatement ps = null; // 객체 생성

			String sql = "UPDATE posts SET content = ?, FILENAME = ?, FILE = ? WHERE ID = ?; ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, post.getContent());
			ps.setInt(2, post.getPID());
			ps.setBinaryStream(3, fin, (int) imgfile.length());// Stream형의 파일 업로드
			ps.executeUpdate(); // 명렁어 실행
			ps.close();
			System.out.println("update Successfully!");
		}
	}

	public static Integer getPostNum(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(ID) from posts where user_id = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		Integer postNumInteger = rs.getInt(1);
		System.out.println(postNumInteger);
		rs.close();
		ps.close();
		return postNumInteger;
	}

	public static User getUserByUID(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select ID, name, phone_num, email from users where ID=?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		User list = new User();

		rs.next();
		list.setUserID(rs.getString(1));
		list.setUserName(rs.getString(2));
		list.setUserPhoneNum(rs.getString(3));
		list.setUserEmail(rs.getString(4));
		rs.close();
		ps.close();

		return list;

	}

	public static Integer getFolloweeNum(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(followee) from follow natural join users where followee = users.ID = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		Integer postNumInteger = rs.getInt(1);
		rs.close();
		ps.close();
		return postNumInteger;
	}

	public static Integer getFollowerNum(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(follower) from follow natural join users where follower = users.ID = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		Integer postNumInteger = rs.getInt(1);
		rs.close();
		ps.close();
		return postNumInteger;
	}

	public static Integer[] getPIDsByUID(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "SELECT * FROM posts WHERE user_id = ? ORDER BY created_at DESC;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		Integer numPost = ZinCyan.getPostNum(UID);
		Integer[] tmp = new Integer[numPost];
		for (int i = 0; i < numPost; i++) {
			rs.next();
			tmp[i] = rs.getInt(1);
		}
		rs.close();
		ps.close();

		return tmp;

	}

	public static Boolean isFollow(String followee, String follower) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(id) from follow where follower = ? and followee = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, follower);
		ps.setString(2, followee);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		Integer tmp = rs.getInt(1);
		rs.close();
		ps.close();
		if (tmp == 0) {
			return false;
		}
		return true;
	}

	public static void follow(String followee, String follower) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "insert into follow values (?,?);";
		ps = conn.prepareStatement(sql);
		ps.setString(1, follower);
		ps.setString(2, followee);
		ps.executeUpdate(); // 명렁어 실행
		ps.close();
	}

	public static void unFollow(String followee, String follower) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "delete from follow where follower = ? and followee = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, follower);
		ps.setString(2, followee);
		ps.executeUpdate(); // 명렁어 실행
		ps.close();

	}

	public static Integer[] getStarPost() throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select ID from posts where created_at between date_add(now(), interval -1 week) and now() order by cnt_like desc; ";

		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		Integer numPost = ZinCyan.getStarPostNum();
		Integer[] tmp = new Integer[numPost];
		for (int i = 0; i < numPost; i++) {
			rs.next();
			tmp[i] = rs.getInt(1);
		}
		rs.close();
		ps.close();

		return tmp;

	}

	public static Integer getStarPostNum() throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(ID) from posts where created_at between date_add(now(), interval -1 week) and now() order by cnt_like desc; ";
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행
		rs.next();
		Integer numPost = rs.getInt(1);

		rs.close();
		ps.close();

		System.out.println(numPost);

		return numPost;

	}

	public static String[] getFollowers(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select followee from follow where follower = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		Integer followerNum = ZinCyan.getFollowerNum(UID);
		String[] tmp = new String[followerNum];
		for (int i = 0; i < followerNum; i++) {
			rs.next();
			tmp[i] = rs.getString(1);
		}
		rs.close();
		ps.close();
		return tmp;
	}

	public static String[] getFollowees(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select follower from follow where followee = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		Integer followeeNum = ZinCyan.getFolloweeNum(UID);
		String[] tmp = new String[followeeNum];
		for (int i = 0; i < followeeNum; i++) {
			rs.next();
			tmp[i] = rs.getString(1);
		}
		rs.close();
		ps.close();
		return tmp;
	}

	public static Boolean isUser(String UID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(ID) from users where ID=?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		Integer tmp = rs.getInt(1);

		rs.close();
		ps.close();
		if (tmp == 0) {
			return false;
		}
		return true;
	}

	public static Boolean validPW(String UID, String PW) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "SELECT password FROM users WHERE ID = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		String tmp = rs.getString(1);
		rs.close();
		ps.close();
		if (PW.equals(tmp)) {
			return true;
		}
		return false;

	}

	public static void initUser(User user) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "insert into users values (?,?,?,?,?); ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUserID());
		ps.setString(2, user.getUserName());
		ps.setString(3, user.getUserPhoneNum());
		ps.setString(4, user.getUserEmail());
		ps.setString(5, user.getUserPassword());
		ps.executeUpdate(); // 명렁어 실행
		ps.close();
		System.out.println("Inserting Successfully!");

	}

	public static Boolean isLike(String UID, Integer PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select count(user_id) from likes where user_id=? and target_id=?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ps.setInt(2, PID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		rs.next();
		Integer tmp = rs.getInt(1);
		rs.close();
		ps.close();
		if (tmp == 0) {
			return false;
		}
		return true;
	}

	public static void like(String UID, Integer PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "insert into likes values (?,?);";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ps.setString(2, UID);
		ps.executeUpdate(); // 명렁어 실행
		ps.close();
	}

	public static void unLike(String UID, Integer PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "delete from likes where  user_id=? and target_id=?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, UID);
		ps.setInt(2, PID);
		ps.executeUpdate(); // 명렁어 실행
		ps.close();

	}

	public static String getUIDByCommentID(Integer postID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "SELECT user_id FROM comment WHERE ID = ?;";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, postID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		String tmp = null;
		rs.next();
		tmp = rs.getString(1);

		rs.close();
		ps.close();

		return tmp;

	}

	public static Comment getCommentbyCID(int CID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "select user_id , content, created_at, cnt_like from comment where ID=?;";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, CID);
		ResultSet rs = ps.executeQuery(); // 명렁어 실행

		Comment comment = new Comment();

		rs.next();
		comment.setCID(CID);
		comment.setUID(rs.getString(1));
		comment.setContent(rs.getString(2));
		comment.setCreateDate(rs.getTimestamp(3));
		comment.setCntLike(rs.getInt(4));
		rs.close();
		ps.close();

		return comment;

	}

	public static void delPost(Integer PID) throws SQLException {
		Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		PreparedStatement ps = null; // 객체 생성

		String sql = "DELETE FROM posts WHERE ID = ?;";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, PID);
		ps.executeUpdate(); // 명렁어 실행
	}

}
