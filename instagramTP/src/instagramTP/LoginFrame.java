package instagramTP;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;


public class LoginFrame extends javax.swing.JFrame implements ActionListener{

	public LoginFrame() {
		initComponents();
	}

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		id = new javax.swing.JLabel();
		pw = new javax.swing.JLabel();
		idTextField = new javax.swing.JTextField();
		pwTextField = new javax.swing.JPasswordField();
		loginBtn = new javax.swing.JButton();
		joinBtn = new javax.swing.JButton();

		setExtendedState(JFrame.MAXIMIZED_BOTH);	// full screen
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(245, 245, 245));
		getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 80));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setPreferredSize(new java.awt.Dimension(470, 500));
		jPanel1.setLayout(new java.awt.GridBagLayout());

		jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 48)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("in*gram");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 40, 0);
		jPanel1.add(jLabel1, gridBagConstraints);

		id.setText(" ID");
		id.setFont(new java.awt.Font("Roboto", 0, 14));
		id.setPreferredSize(new java.awt.Dimension(30, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
		jPanel1.add(id, gridBagConstraints);

		pw.setText("PW");
		pw.setFont(new java.awt.Font("Roboto", 0, 14));
		gridBagConstraints = new java.awt.GridBagConstraints();
		pw.setPreferredSize(new java.awt.Dimension(30, 30));
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
		jPanel1.add(pw, gridBagConstraints);

		idTextField.setFont(new java.awt.Font("���� ���", 0, 14)); // NOI18N
		idTextField.setPreferredSize(new java.awt.Dimension(180, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
		jPanel1.add(idTextField, gridBagConstraints);

		pwTextField.setFont(new java.awt.Font("���� ���", 0, 14)); // NOI18N
		pwTextField.setPreferredSize(new java.awt.Dimension(180, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
		jPanel1.add(pwTextField, gridBagConstraints);

		loginBtn.setFont(new java.awt.Font("���� ���", 0, 14)); // NOI18N
		loginBtn.setText("Login");
		loginBtn.setPreferredSize(new java.awt.Dimension(220, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
		loginBtn.addActionListener(this);
		jPanel1.add(loginBtn, gridBagConstraints);

		joinBtn.setText("join");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		joinBtn.addActionListener(this);
		jPanel1.add(joinBtn, gridBagConstraints);

		getContentPane().add(jPanel1);

		pack();
		setLocationRelativeTo(null);
	}                       


	public static void main(String args[]) {

		FlatLightLaf.registerCustomDefaultsSource("style");
		try {
			UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize flatlaf" );
		}


		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginFrame().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {

		if(arg0.getSource() == joinBtn){	// join button action
			JoinFrame join = new JoinFrame();
			join.setVisible(true);	 	
		}

		if(arg0.getSource() == loginBtn){	// login button action

			String userID = idTextField.getText();
			String userPassword = new String(pwTextField.getPassword());

			if(Login( userID,  userPassword)==1) // Login successful if ID and password match
			{
				JOptionPane.showMessageDialog(null, "welcome!");
				dispose();	// Login screen off

				// MainFrame���� �Ѿ�� ����, id ������ �����ϰų� Ȥ�� MainFrame���� �Ѱ������.
				MainFrame main = new MainFrame();
				main.setVisible(true);	// go to MainFrame
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ID or passward is wrong...");	// if ID and password not match
			}
		}	
	}

	private Connection conn; //�����ͺ��̽��� �����ϰ� ���ִ� �ϳ��� ��ü 
	private PreparedStatement pstmt;
	private ResultSet rs; //��� ������ ���� �� �ִ� �ϳ��� ��ü

	String UID;

	public int Login(String userID, String userPassword) {
		String SQL="SELECT password FROM users WHERE ID = ?";
		try {
			pstmt=conn.prepareStatement(SQL); //sql ������ �����ͺ��̽��� ����
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery(); //rs : ����� ���� �� �ִ� �ϳ��� ��ü. ���⿡ ���� ����� �־���
			if(rs.next()) { //rs.next() : ����� �����Ѵٸ� �ش� if�� ����
				if(rs.getString(1).equals(userPassword)) {
					UID=userID; //�α����� ������ ���̵� ���
					return 1; //�α��� ����
				}
				else
					return 0; // ��й�ȣ ����ġ
			}
			return -1; //���̵� ����
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2; //�����ͺ��̽� ����
	}


	// Variables declaration                 
	private javax.swing.JButton loginBtn;
	private javax.swing.JButton joinBtn;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel id;
	private javax.swing.JLabel pw;
	private javax.swing.JTextField idTextField;
	private javax.swing.JPasswordField pwTextField;
	// End of variables declaration                   
}
