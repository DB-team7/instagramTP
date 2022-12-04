package instagramTP;

import java.awt.Color;
import java.awt.Insets;
import java.io.IOException;
import java.sql.SQLException;

import com.formdev.flatlaf.ui.FlatLineBorder;

public class OtherPageWindow extends javax.swing.JDialog implements java.awt.event.ActionListener {

	private static final long serialVersionUID = 1L;
	private static String userID = null;
	public OtherPageWindow(String UID, String myUID) throws SQLException, IOException {
		initComponents(UID, myUID);
	}

	public void initComponents(String UID, String myUID) throws SQLException, IOException {

		userID=UID;
		scrollPane = new javax.swing.JScrollPane();
		scrollBackPane = new javax.swing.JPanel();
		otherDataPanel = new javax.swing.JPanel();
		idLabel = new javax.swing.JLabel();
		nameLabel = new javax.swing.JLabel();
		followerBtn = new javax.swing.JButton();
		followerNumLabel = new javax.swing.JLabel();
		followingBtn = new javax.swing.JButton();
		followingNumLabel = new javax.swing.JLabel();
		postNumPanel = new javax.swing.JPanel();
		postNumLabel = new javax.swing.JLabel();
		followToggleBtn = new javax.swing.JToggleButton();
		blockToggleBtn = new javax.swing.JToggleButton();

		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // ��ũ�� �ӵ� ����
		scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0)); // ��ũ�ѹ� �����

		scrollBackPane.setBackground(new Color(245, 245, 245));
		scrollBackPane.setLayout(new javax.swing.BoxLayout(scrollBackPane, javax.swing.BoxLayout.Y_AXIS));

		// �������� ����
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // �гλ��̼��ο���

		// �ٸ� ��� ������
		otherDataPanel.setBackground(new Color(255, 255, 255));
		// otherDataPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24,
		// 24, 24)); //���� ����
		otherDataPanel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));

		User thisUser = ZinCyan.getUserByUID(UID);

		idLabel.setText(thisUser.getUserID());
		otherDataPanel.add(idLabel);

		nameLabel.setForeground(Color.GRAY);
		nameLabel.setText(thisUser.getUserName());
		otherDataPanel.add(nameLabel);

		followerBtn.setText("follower");
		followerBtn.setBorder(null);
		followerBtn.setBackground(null);
		followerBtn.addActionListener(this);
		otherDataPanel.add(followerBtn);

		followerNumLabel.setText(Integer.toString(ZinCyan.getFollowerNum(UID)));
		otherDataPanel.add(followerNumLabel);

		followingBtn.setText("following");
		followingBtn.setBorder(null);
		followingBtn.setBackground(null);
		followingBtn.addActionListener(this);
		otherDataPanel.add(followingBtn);

		followingNumLabel.setText(Integer.toString(ZinCyan.getFolloweeNum(UID)));
		otherDataPanel.add(followingNumLabel);

		// followToggleBtn.setBorder(null);
		// followToggleBtn.setBackground(null);
		if (ZinCyan.isFollow(UID, myUID)) {
			followToggleBtn.setText("unfollow"); // �⺻ ����: �� ����� �ȷο��ϰ� ������ unfollow, �ƴϸ� follow�� setText
			followToggleBtn.setSelected(true); // �⺻ ����: �� ����� �ȷο��ϰ� ������ true, �ƴϸ� false
		} else {
			followToggleBtn.setText("follow"); // �⺻ ����: �� ����� �ȷο��ϰ� ������ unfollow, �ƴϸ� follow�� setText
			followToggleBtn.setSelected(false); // �⺻ ����: �� ����� �ȷο��ϰ� ������ true, �ƴϸ� false
		}

		followToggleBtn.addItemListener(new java.awt.event.ItemListener() {
			@Override
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				if (followToggleBtn.isSelected()) {
					// follow ����
					followToggleBtn.setText("unfollow"); // ���� �ȷο� ���̴ϱ� �ٽ� ������ ���ȵȴٴ� ��
					try {
						ZinCyan.unFollow(UID, myUID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					// unfollow ����
					followToggleBtn.setText("follow"); // ���� ���� �����ϱ� �ٽ� ������ �ȷο�ȴٴ� ��
					try {
						ZinCyan.follow(UID, myUID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		otherDataPanel.add(followToggleBtn);

		blockToggleBtn.setText("block"); // �⺻ ����: �� ����� ��������� unblock, �ƴϸ� block���� setText
		blockToggleBtn.setSelected(false); // �⺻ ����: �� ����� ��������� true, �ƴϸ� false
		blockToggleBtn.addItemListener(new java.awt.event.ItemListener() {
			@Override
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				if (blockToggleBtn.isSelected()) {
					// block ����
					blockToggleBtn.setText("unblock"); // ���� ��� ���̴ϱ� �ٽ� ������ ��� �����ȴٴ� ��
				} else {
					// unblock(�������) ����
					blockToggleBtn.setText("follow"); // ���� ��� ���������ϱ� �ٽ� ������ ����ȴٴ� ��
				}
			}
		});
		otherDataPanel.add(blockToggleBtn);
		// �ǳʰǳ� ���� �������� ����Ǿ��� ���� ���ʿ� ���� �ʰ� �ϰų� follow,block ��ư�� �Ⱥ��̰� �ؾ� ��.

		scrollBackPane.add(otherDataPanel);
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // �гλ��̼��ο���

		// �Խñ� ��
		postNumPanel.setBackground(new Color(245, 245, 245));
		postNumPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

		postNumLabel.setText(Integer.toString(ZinCyan.getPostNum(UID)) + " Posts by " + UID);
		postNumPanel.add(postNumLabel);

		scrollBackPane.add(postNumPanel);
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // �гλ��̼��ο���

		PostPanel[] postPanel = new PostPanel[ZinCyan.getPostNum(UID)];
		Integer[] posts = new Integer[ZinCyan.getPostNum(UID)];
		posts = ZinCyan.getPIDsByUID(UID);
		for (Integer i = 0; i < ZinCyan.getPostNum(UID); i++) {
			// �Խñ� post
			postPanel[i] = new PostPanel(posts[i], myUID);
			postPanel[i].setBorder(new FlatLineBorder(new Insets(0, 0, 0, 0), Color.LIGHT_GRAY, 1, 30));
			scrollBackPane.add(postPanel[i]);
			scrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // �гλ��̼��ο���
		}
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(1000)); // �гλ��̼��ο���
		
		scrollPane.setViewportView(scrollBackPane);

		// add scrollPane in center
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(scrollPane, 470, 470, 470)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(scrollPane)
				);

	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == followerBtn) { // �ȷο�,�ȷ��� ��ư �ѱ�� data �ٸ���
			try {
				flwWindow = new FollowerWindow(userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flwWindow.setVisible(true);
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					flwWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0, 0));
					flwWindow.setModal(true);
				}
			});
		}

		if (arg0.getSource() == followingBtn) {
			try {
				fleWindow = new FolloweeWindow(userID);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fleWindow.setVisible(true);
			java.awt.EventQueue.invokeLater(new Runnable() {

				public void run() {
					fleWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0, 0));
					fleWindow.setModal(true);
				}
			});
		}

	}

	private javax.swing.JPanel otherDataPanel;
	private javax.swing.JButton followerBtn;
	private javax.swing.JLabel followerNumLabel;
	private javax.swing.JButton followingBtn;
	private javax.swing.JLabel followingNumLabel;
	private javax.swing.JLabel idLabel;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JLabel postNumLabel;
	private javax.swing.JPanel postNumPanel;
	private javax.swing.JToggleButton followToggleBtn;
	private javax.swing.JToggleButton blockToggleBtn;
	private javax.swing.JPanel scrollBackPane;
	public javax.swing.JScrollPane scrollPane;
	private FollowerWindow flwWindow;
	private FolloweeWindow fleWindow;

}
