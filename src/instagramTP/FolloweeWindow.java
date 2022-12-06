package instagramTP;

import java.io.IOException;
import java.sql.SQLException;

public class FolloweeWindow extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FolloweeWindow(String UID) throws SQLException, IOException {
		initComponents(UID);
	}

	public void initComponents(String UID) throws SQLException, IOException {

		scrollPane = new javax.swing.JScrollPane();
		scrollBackPane = new javax.swing.JPanel();
		infoPanel = new javax.swing.JPanel();
		infoLabel = new javax.swing.JLabel();

		java.awt.Image nullImg = new javax.swing.ImageIcon("images/nullImage.png").getImage();
		setIconImage(nullImg); // 프레임바 아이콘 우선 투명으로
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().setBackground(new java.awt.Color(245, 245, 245));
		getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new java.awt.Dimension(470, 560));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 속도 증가
		scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0)); // 스크롤바 숨기기

		scrollBackPane.setBackground(new java.awt.Color(245, 245, 245));
		scrollBackPane.setLayout(new javax.swing.BoxLayout(scrollBackPane, javax.swing.BoxLayout.Y_AXIS));

		// 여백으로 시작
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(10)); // 패널사이세로여백

		// 어떤 버튼을 눌러서 뜬 창인지에 따라 팔로우/팔로잉 표시가 달라야 함
		infoPanel.setBackground(new java.awt.Color(245, 245, 245));
		infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

		//		infoLabel.setText("116 people are following recyan__"); // 팔로우
		infoLabel.setText(UID + " is following " + Integer.toString(ZinCyan.getFolloweeNum(UID)) + " people(s)"); // 팔로잉
		infoPanel.add(infoLabel);

		scrollBackPane.add(infoPanel);
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(10)); // 패널사이세로여백

		Integer followeeNum = ZinCyan.getFolloweeNum(UID);
		String[] followees = new String[followeeNum];
		followees = ZinCyan.getFollowees(UID);
		PersonPanel[] personPanel = new PersonPanel[followeeNum];
		for (int i = 0; i < followeeNum; i++) {
			// 팔로우/팔로잉 정보
			personPanel[i] = new PersonPanel(followees[i], UID);
			scrollBackPane.add(personPanel[i]);
		}
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(1000)); // default blank

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

	private javax.swing.JLabel infoLabel;
	private javax.swing.JPanel infoPanel;
	private javax.swing.JPanel scrollBackPane;
	public javax.swing.JScrollPane scrollPane;

}
