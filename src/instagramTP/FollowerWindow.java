package instagramTP;

import java.io.IOException;
import java.sql.SQLException;

public class FollowerWindow extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FollowerWindow(String UID) throws SQLException {
		initComponents(UID);
	}

	public void initComponents(String UID) throws SQLException {

		scrollPane = new javax.swing.JScrollPane();
		scrollBackPane = new javax.swing.JPanel();
		infoPanel = new javax.swing.JPanel();
		infoLabel = new javax.swing.JLabel();

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

		infoLabel.setText(Integer.toString(ZinCyan.getFollowerNum(UID)) + " people are following " + UID); // 팔로우
		// infoLabel.setText("recyan__ is following 143 people"); //팔로잉
		infoPanel.add(infoLabel);

		scrollBackPane.add(infoPanel);
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(10)); // 패널사이세로여백

		Integer followerNum = ZinCyan.getFollowerNum(UID);
		String[] followers = new String[followerNum];
		followers = ZinCyan.getFollowers(UID);
		PersonPanel[] personPanel = new PersonPanel[followerNum];
		for (int i = 0; i < followerNum; i++) {
			// 팔로우/팔로잉 정보
			try {
				personPanel[i] = new PersonPanel(followers[i], UID);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
