package instagramTP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UserDAO { //ȸ�� ���̺��� ������ �� �ֵ��� DAP(������ ���� ��ü) ����

	private Connection conn; //�����ͺ��̽��� �����ϰ� ���ִ� �ϳ��� ��ü 
	private PreparedStatement pstmt;
	private ResultSet rs; //��� ������ ���� �� �ִ� �ϳ��� ��ü
	
	public UserDAO() {
		try {
			String dbURL="jdbc:mysql://localhost/dmaster"; //jdbc:mysql://localhost/�����db�̸�
			String dbID="root"; //����
			String dbPassword="12345"; //��й�ȣ
			Class.forName("com.mysql.jdbc.Driver"); //mysql driver ã�� �� �ֵ���
			conn=DriverManager.getConnection(dbURL,dbID,dbPassword); //������ �Ϸ�Ǹ� conn ��ü �ȿ� ������ ���� ��
		}catch(Exception e) {
			e.printStackTrace(); //���� �߻��� � �������� ���
		}
	}
	
	//���̵� �ߺ� üũ
	public boolean findExistID(int cnt_ID) {
		
		String SQL="select ID, count(ID) as cnt_id from users group by ID having ? > 1";
		
		try {
			pstmt=conn.prepareStatement(SQL); 
			pstmt.setInt(1, cnt_ID);
			rs=pstmt.executeQuery(); 
			if(rs.next()) {
				return true; //�ߺ��� ����
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; //�ߺ��� ����
	}
	
	
	//ȸ������
	public int join(User user) {
		
		UserDAO userDAO = new UserDAO();
		
		int result = userDAO.join(user);
		
		String SQL="insert into users values (?,?,?,?,?)"; //id, name, phone_num, email, pw
		try {
			pstmt=conn.prepareStatement(SQL); //sql ������ �����ͺ��̽��� ����
			pstmt.setString(1, user.getUserID());
			pstmt.setString(1, user.getUserName());
			pstmt.setInt(1, user.getUserPhoneNum());
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(1, user.getUserPassword());
			
			if(findExistID(result)==true) { //�ߺ��̸� ������Ʈ x
				JOptionPane.showMessageDialog(null, "�ߺ� ���̵��Դϴ�", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			}
			else //�ߺ��� �ƴϸ� ������Ʈ
				return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ����
	}
}