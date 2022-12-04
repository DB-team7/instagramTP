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
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 속도 증가
		scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0)); // 스크롤바 숨기기

		scrollBackPane.setBackground(new Color(245, 245, 245));
		scrollBackPane.setLayout(new javax.swing.BoxLayout(scrollBackPane, javax.swing.BoxLayout.Y_AXIS));

		// 여백으로 시작
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백

		// 다른 사람 정보란
		otherDataPanel.setBackground(new Color(255, 255, 255));
		// otherDataPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24,
		// 24, 24)); //내부 여백
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
			followToggleBtn.setText("unfollow"); // 기본 설정: 이 사람을 팔로우하고 있으면 unfollow, 아니면 follow로 setText
			followToggleBtn.setSelected(true); // 기본 설정: 이 사람을 팔로우하고 있으면 true, 아니면 false
		} else {
			followToggleBtn.setText("follow"); // 기본 설정: 이 사람을 팔로우하고 있으면 unfollow, 아니면 follow로 setText
			followToggleBtn.setSelected(false); // 기본 설정: 이 사람을 팔로우하고 있으면 true, 아니면 false
		}

		followToggleBtn.addItemListener(new java.awt.event.ItemListener() {
			@Override
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				if (followToggleBtn.isSelected()) {
					// follow 상태
					followToggleBtn.setText("unfollow"); // 이제 팔로우 중이니까 다시 누르면 언팔된다는 뜻
					try {
						ZinCyan.unFollow(UID, myUID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					// unfollow 상태
					followToggleBtn.setText("follow"); // 이제 언팔 했으니까 다시 누르면 팔로우된다는 뜻
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

		blockToggleBtn.setText("block"); // 기본 설정: 이 사람을 블락했으면 unblock, 아니면 block으로 setText
		blockToggleBtn.setSelected(false); // 기본 설정: 이 사람을 블락했으면 true, 아니면 false
		blockToggleBtn.addItemListener(new java.awt.event.ItemListener() {
			@Override
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				if (blockToggleBtn.isSelected()) {
					// block 상태
					blockToggleBtn.setText("unblock"); // 이제 블락 중이니까 다시 누르면 블락 해제된다는 뜻
				} else {
					// unblock(블락안한) 상태
					blockToggleBtn.setText("follow"); // 이제 블락 해제했으니까 다시 누르면 블락된다는 뜻
				}
			}
		});
		otherDataPanel.add(blockToggleBtn);
		// 건너건너 본인 페이지로 연결되었을 때는 애초에 뜨지 않게 하거나 follow,block 버튼이 안보이게 해야 함.

		scrollBackPane.add(otherDataPanel);
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백

		// 게시글 수
		postNumPanel.setBackground(new Color(245, 245, 245));
		postNumPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));

		postNumLabel.setText(Integer.toString(ZinCyan.getPostNum(UID)) + " Posts by " + UID);
		postNumPanel.add(postNumLabel);

		scrollBackPane.add(postNumPanel);
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백

		PostPanel[] postPanel = new PostPanel[ZinCyan.getPostNum(UID)];
		Integer[] posts = new Integer[ZinCyan.getPostNum(UID)];
		posts = ZinCyan.getPIDsByUID(UID);
		for (Integer i = 0; i < ZinCyan.getPostNum(UID); i++) {
			// 게시글 post
			postPanel[i] = new PostPanel(posts[i], myUID);
			postPanel[i].setBorder(new FlatLineBorder(new Insets(0, 0, 0, 0), Color.LIGHT_GRAY, 1, 30));
			scrollBackPane.add(postPanel[i]);
			scrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백
		}
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(1000)); // 패널사이세로여백
		
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
		if (arg0.getSource() == followerBtn) { // 팔로워,팔로잉 버튼 넘기는 data 다르게
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
