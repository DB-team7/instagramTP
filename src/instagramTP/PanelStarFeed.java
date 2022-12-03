package instagramTP;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class PanelStarFeed extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

	public PanelStarFeed(String UID) throws SQLException {
		initComponents(UID);
	}

	private void initComponents(String UID) throws SQLException {

		scrollPane = new javax.swing.JScrollPane();
		ScrollBackPane = new javax.swing.JPanel();
		starPane = new javax.swing.JPanel();
		starLabel = new javax.swing.JLabel();

		setBackground(new java.awt.Color(245, 245, 245));
		setPreferredSize(new java.awt.Dimension(1000, 600));
		setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new java.awt.Dimension(470, 620));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 속도 증가
		scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0)); // 스크롤바 숨기기

		ScrollBackPane.setBackground(new java.awt.Color(245, 245, 245));
		ScrollBackPane.setLayout(new javax.swing.BoxLayout(ScrollBackPane, javax.swing.BoxLayout.Y_AXIS));

		// 여백으로 시작
		ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백

		// 인기글 피드임을 알려주는 패널
		starPane.setBackground(new java.awt.Color(245, 245, 245));
		starPane.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

		starLabel.setText("Star feed");
		starPane.add(starLabel);

		ScrollBackPane.add(starPane);
		ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백

		PostPanel[] postPanel = new PostPanel[ZinCyan.getStarPostNum()];
		Integer[] posts =  ZinCyan.getStarPost().clone();
		System.out.println(Arrays.toString(posts));
		for (Integer i = 0; i < ZinCyan.getStarPostNum(); i++) {
			// 게시글 post
			try {
				postPanel[i] = new PostPanel(posts[i], UID);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ScrollBackPane.add(postPanel[i]);
			ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백
		}

		scrollPane.setViewportView(ScrollBackPane);

		add(scrollPane);
	}

	// Variables declaration
	private javax.swing.JPanel ScrollBackPane;
	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JPanel starPane;
	private javax.swing.JLabel starLabel;
	// End of variables declaration
}
