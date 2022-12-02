package instagramTP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO { //ȸ�� ���̺� ������ �� �ֵ��� DAP(������ ���� ��ü) ����

	private Connection conn; //�����ͺ��̽��� �����ϰ� ���ִ� �ϳ��� ��ü 
	private PreparedStatement pstmt;
	private ResultSet rs; //��� ������ ���� �� �ִ� �ϳ��� ��ü
	
	public UserDAO() {
		try {
			String dbURL="jdbc:mysql://localhost/dm"; //jdbc:mysql://localhost/�����db�̸�
			String dbID="root"; //����
			String dbPassword="12345"; //��й�ȣ
			Class.forName("com.mysql.jdbc.Driver"); //mysql driver ã�� �� �ֵ���
			conn=DriverManager.getConnection(dbURL,dbID,dbPassword); //������ �Ϸ�Ǹ� conn ��ü �ȿ� ������ ���� ��
		}catch(Exception e) {
			e.printStackTrace(); //���� �߻��� � �������� ���
		}
	}
	
	//ȸ������
	public int join(User user) {
		String SQL="insert into users values (?,?,?,?,?)"; //id, name, phone_num, email, pw
		try {
			pstmt=conn.prepareStatement(SQL); //sql ������ �����ͺ��̽��� ����
			pstmt.setString(1, user.getUserID());
			pstmt.setString(1, user.getUserName());
			pstmt.setInt(1, user.getUserPhoneNum());
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(1, user.getUserPassword());
			
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ����
	}
	
	//�α���
	public int Login(String userID, String userPassword) {
		String SQL="SELECT password FROM users WHERE ID = ?";
		try {
			pstmt=conn.prepareStatement(SQL); //sql ������ �����ͺ��̽��� ����
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery(); //rs : ����� ���� �� �ִ� �ϳ��� ��ü. ���⿡ ���� ����� �־���
			if(rs.next()) { //rs.next() : ����� �����Ѵٸ� �ش� if�� ����
				if(rs.getString(1).equals(userPassword))
					return 1; //�α��� ����
				else
					return 0; // ��й�ȣ ����ġ
			}
			return -1; //���̵� ����
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2; //�����ͺ��̽� ����
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//Reference
//https://green333.tistory.com/28