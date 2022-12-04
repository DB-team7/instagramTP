package instagramTP;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class JoinFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public JoinFrame() {
		initComponents();
	}

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		joinButton = new javax.swing.JButton();

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(245, 245, 245));
		getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 80));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setPreferredSize(new java.awt.Dimension(470, 500));
		jPanel1.setLayout(new java.awt.GridBagLayout());

		jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 18));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("join in*gram");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
		jPanel1.add(jLabel1, gridBagConstraints);

		// NAME field
		jTextField1.setText("NAME");
		jTextField1.setForeground(Color.GRAY);
		jTextField1.addFocusListener(new FocusListener() { // when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField1.getText().equals("")) {
					jTextField1.setText("NAME");
					jTextField1.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField1.getText().equals("NAME")) {
					jTextField1.setText("");
					jTextField1.setForeground(Color.BLACK);
				}
			}
		});
		jTextField1.setPreferredSize(new java.awt.Dimension(200, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
		jPanel1.add(jTextField1, gridBagConstraints);

		// PHONE NUMBER field
		jTextField2.setText("PHONE NUMBER");
		jTextField2.setForeground(Color.GRAY);
		jTextField2.addFocusListener(new FocusListener() { // when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField2.getText().equals("")) {
					jTextField2.setText("PHONE NUMBER");
					jTextField2.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField2.getText().equals("PHONE NUMBER")) {
					jTextField2.setText("");
					jTextField2.setForeground(Color.BLACK);
				}
			}
		});
		jTextField2.setPreferredSize(new java.awt.Dimension(200, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
		jPanel1.add(jTextField2, gridBagConstraints);

		// EMAIL field
		jTextField3.setText("EMAIL");
		jTextField3.setForeground(Color.GRAY);
		jTextField3.addFocusListener(new FocusListener() { // when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField3.getText().equals("")) {
					jTextField3.setText("EMAIL");
					jTextField3.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField3.getText().equals("EMAIL")) {
					jTextField3.setText("");
					jTextField3.setForeground(Color.BLACK);
				}
			}
		});
		jTextField3.setPreferredSize(new java.awt.Dimension(200, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
		jPanel1.add(jTextField3, gridBagConstraints);

		// ID field
		jTextField4.setText("ID");
		jTextField4.setForeground(Color.GRAY);
		jTextField4.addFocusListener(new FocusListener() { // when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField4.getText().equals("")) {
					jTextField4.setText("ID");
					jTextField4.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField4.getText().equals("ID")) {
					jTextField4.setText("");
					jTextField4.setForeground(Color.BLACK);
				}
			}
		});
		jTextField4.setPreferredSize(new java.awt.Dimension(200, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
		jPanel1.add(jTextField4, gridBagConstraints);

		// PASSWORD field
		jTextField5.setText("PASSWORD");
		jTextField5.setForeground(Color.GRAY);
		jTextField5.addFocusListener(new FocusListener() { // when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField5.getText().equals("")) {
					jTextField5.setText("PASSWORD");
					jTextField5.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField5.getText().equals("PASSWORD")) {
					jTextField5.setText("");
					jTextField5.setForeground(Color.BLACK);
				}
			}
		});
		jTextField5.setPreferredSize(new java.awt.Dimension(200, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
		jPanel1.add(jTextField5, gridBagConstraints);

		joinButton.setText("Join");
		joinButton.setPreferredSize(new java.awt.Dimension(200, 30));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
		joinButton.addActionListener(this);
		jPanel1.add(joinButton, gridBagConstraints);

		getContentPane().add(jPanel1);

		pack();
		setLocationRelativeTo(null);
	}

	public void actionPerformed(java.awt.event.ActionEvent arg0) {

		// 회원가입
		if (arg0.getSource() == joinButton) { // join button action
			try {
				if (ZinCyan.isUser(jTextField4.getText())) {
					// 중복이 있음
					JOptionPane.showMessageDialog(null, "중복 아이디입니다", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				} else { // 중복이 아니면 업데이트
					try {
						if (jTextField4.getText().equals(""))
							JOptionPane.showMessageDialog(null, "아이디를 입력해주세요", "ERROR_MESSAGE",
									JOptionPane.ERROR_MESSAGE);
						if (jTextField1.getText().equals(""))
							JOptionPane.showMessageDialog(null, "이름을 입력해주세요", "ERROR_MESSAGE",
									JOptionPane.ERROR_MESSAGE);
						if (jTextField2.getText().equals(""))
							JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요", "ERROR_MESSAGE",
									JOptionPane.ERROR_MESSAGE);
						if (jTextField3.getText().equals(""))
							JOptionPane.showMessageDialog(null, "이메일을 입력해주세요", "ERROR_MESSAGE",
									JOptionPane.ERROR_MESSAGE);

						String pattern2 = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
						String str2 = jTextField3.getText();
						if (Pattern.matches(pattern2, str2)) {
							System.out.println("올바른 이메일 형식입니다. ");
						} else {
							JOptionPane.showMessageDialog(null, "올바른 이메일 형식이 아닙니다.", "ERROR_MESSAGE",
									JOptionPane.ERROR_MESSAGE);
						}

						if (jTextField5.getText().equals(""))
							JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요", "ERROR_MESSAGE",
									JOptionPane.ERROR_MESSAGE);

						User user = new User();
						user.setUserID(jTextField4.getText()); // ID
						user.setUserName(jTextField1.getText());// name
						user.setUserPhoneNum(jTextField2.getText());// phone_num
						user.setUserEmail(jTextField3.getText());// email
						user.setUserPassword(jTextField5.getText());// password

						ZinCyan.initUser(user, null);

						JOptionPane.showMessageDialog(null, "Join successful!");
						dispose(); // join screen off

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton joinButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	// End of variables declaration
}
