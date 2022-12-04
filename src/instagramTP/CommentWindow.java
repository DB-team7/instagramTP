package instagramTP;

import java.sql.SQLException;

public class CommentWindow extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	public CommentWindow(Integer PID, String myUID) throws SQLException {
		initComponents(PID, myUID);
	}

	public void initComponents(Integer PID, String myUID) throws SQLException {
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

		// 댓글창임을 알려주는 라벨,패널
		infoPanel.setBackground(new java.awt.Color(245, 245, 245));
		infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

		infoLabel.setText(Integer.toString(ZinCyan.getCommentNumByPID(PID)) + " comments"); // 댓글 수 반영
		// infoLabel.setText("Comments"); //아니면 그냥 이렇게
		infoPanel.add(infoLabel);

		scrollBackPane.add(infoPanel);
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(10)); // 패널사이세로여백

		// 댓글 리스트 쫙

		CommentPanel[] cmtPanel = new CommentPanel[ZinCyan.getCommentNumByPID(PID)];
		Integer[] comments = new Integer[ZinCyan.getCommentNumByPID(PID)];
		comments = ZinCyan.getPIDsByUID(myUID);
		for (Integer i = 0; i < ZinCyan.getPostNum(myUID); i++) {
			// 게시글 post
			cmtPanel[i] = new CommentPanel(comments[i], myUID);
			scrollBackPane.add(cmtPanel[i]);
		}

		// 스크롤팬에 컨텐츠가 부족할 때 이상해보이는 거 고칠 예정
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(500)); // 우선은 여백만으로 해결

		scrollPane.setViewportView(scrollBackPane);
		getContentPane().add(scrollPane);

	}

	private javax.swing.JLabel infoLabel;
	private javax.swing.JPanel infoPanel;
	private javax.swing.JPanel scrollBackPane;
	public javax.swing.JScrollPane scrollPane;

}
