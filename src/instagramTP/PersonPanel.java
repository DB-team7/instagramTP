package instagramTP;

import java.io.IOException;
import java.sql.SQLException;

public class PersonPanel extends javax.swing.JPanel implements java.awt.event.ActionListener {
	private static final long serialVersionUID = 1L;
	private static String UserID = null;
	private static String myUserID = null;

	public PersonPanel(String UID, String myUID) throws SQLException {
		initComponents(UID, myUID);
	}

	private void initComponents(String UID, String myUID) throws SQLException {

		UserID = UID;
		myUserID = myUID;

		setBackground(new java.awt.Color(255, 255, 255));
		setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(200, 200, 200)));
		// setPreferredSize(new java.awt.Dimension(100, 100));

		profileImgLabel = new javax.swing.JLabel();
		IDBtn = new javax.swing.JButton();
		nameLabel = new javax.swing.JLabel();
		profileImg = new javax.swing.ImageIcon("images/basicProfilePhoto.png").getImage();

		profileImgLabel.setIcon(new javax.swing.ImageIcon(profileImg));
		profileImgLabel.setPreferredSize(new java.awt.Dimension(32, 32));

		IDBtn.setText(UID);
		IDBtn.setBorder(null);
		IDBtn.setBackground(null);
		IDBtn.addActionListener(this); // ID 클릭하면 그 사람 페이지로 (OtherPageWindow.java)

		nameLabel.setText(ZinCyan.getUserNameByUID(UID));
		nameLabel.setForeground(new java.awt.Color(153, 153, 153));

		// add components
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(profileImgLabel)
						.addGap(10, 10, 10).addComponent(IDBtn).addGap(10, 10, 10).addComponent(nameLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
								.addComponent(profileImgLabel).addComponent(IDBtn).addComponent(nameLabel))
						.addGap(10, 10, 10)));

	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == IDBtn) {
			try {
				otherWindow = new OtherPageWindow(UserID, myUserID);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			otherWindow.setVisible(true);
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					otherWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0, 0));
					otherWindow.setModal(true);
				}
			});
		}
	}

	private javax.swing.JLabel profileImgLabel;
	private java.awt.Image profileImg;
	private javax.swing.JButton IDBtn;
	private javax.swing.JLabel nameLabel;
	private OtherPageWindow otherWindow;
}
