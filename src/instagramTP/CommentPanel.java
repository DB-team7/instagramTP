package instagramTP;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class CommentPanel extends javax.swing.JPanel implements java.awt.event.ActionListener {

	private static final long serialVersionUID = 1L;
	private static String myUserID = null;
	private static Integer commentID = null;

	public CommentPanel(Integer CID, String myUID) throws SQLException {
		initComponents(CID, myUID);
	}

	private void initComponents(Integer CID, String myUID) throws SQLException {
		commentID = CID;
		myUserID = myUID;

		setBackground(new java.awt.Color(255, 255, 255));
		setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(200, 200, 200)));

		profileImgLabel = new javax.swing.JLabel();
		IDBtn = new javax.swing.JButton();
		nameLabel = new javax.swing.JLabel();
		likeBtn = new javax.swing.JToggleButton();
		profileImg = new javax.swing.ImageIcon("images/basicProfilePhoto.png").getImage();

		// load images
		heart = new ImageIcon("images/heart.png").getImage();
		heart_f = new ImageIcon("images/heart_filled.png").getImage();
		heart_p = new ImageIcon("images/heart_pressed1.png").getImage();
		heart_fp = new ImageIcon("images/heart_pressed2.png").getImage();

		// image to imageIcon
		heartI = new ImageIcon(heart.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		heartI_f = new ImageIcon(heart_f.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		heartI_p = new ImageIcon(heart_p.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		heartI_fp = new ImageIcon(heart_fp.getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		profileImgLabel.setIcon(new javax.swing.ImageIcon(profileImg));
		profileImgLabel.setPreferredSize(new java.awt.Dimension(32, 32));
		
		Comment comment = ZinCyan.getCommentbyCID(CID);
		
		IDBtn.setText(comment.getUID());
		IDBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12));
		IDBtn.setForeground(new java.awt.Color(100, 100, 100));
		IDBtn.setBorder(null);
		IDBtn.setBackground(null);
		IDBtn.addActionListener(this); // ID 클릭하면 그 사람 페이지로 (OtherPageWindow.java)

		nameLabel.setText(comment.getContent());
		nameLabel.setForeground(new java.awt.Color(30, 30, 30));

		likeBtn.setPreferredSize(new java.awt.Dimension(20, 20));
		likeBtn.setBackground(null);
		likeBtn.setBorder(null);
		likeBtn.setPressedIcon(heartI_fp);
		if (ZinCyan.isLike(myUserID, CID)) {
			likeBtn.setIcon(heartI_f); // 기본 설정: 이 댓글을 좋아요했으면 heartI_f(꽉찬하트), 아니면 heartI(빈하트)로 setIcon
			likeBtn.setSelected(true); // 기본 설정: 이 댓글을 좋아요했으면 true, 아니면 false
		} else {
			likeBtn.setIcon(heartI); // 기본 설정: 이 댓글을 좋아요했으면 heartI_f(꽉찬하트), 아니면 heartI(빈하트)로 setIcon
			likeBtn.setSelected(false); // 기본 설정: 이 댓글을 좋아요했으면 true, 아니면 false
		}
		
		likeBtn.addItemListener(new java.awt.event.ItemListener() {
			@Override
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				if (likeBtn.isSelected()) {
					try {
						ZinCyan.likeComment(myUserID, CID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					likeBtn.setIcon(heartI_f); // 좋아요 누른 상태
					likeBtn.setPressedIcon(heartI_p);
				} else {
					ZinCyan.unLikeComment(myUserID, CID);
					likeBtn.setIcon(heartI); // 좋아요 안한 상태
					likeBtn.setPressedIcon(heartI_fp);
				}
			}
		});

		// add components
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(profileImgLabel)
						.addGap(10, 10, 10).addComponent(IDBtn).addGap(10, 10, 10).addComponent(nameLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(likeBtn).addGap(10, 10, 10)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
								.addComponent(profileImgLabel).addComponent(IDBtn).addComponent(nameLabel)
								.addComponent(likeBtn))
						.addGap(10, 10, 10)));

	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == IDBtn) {
			try {
				otherWindow = new OtherPageWindow(ZinCyan.getUIDByCommentID(commentID), myUserID);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			otherWindow.setVisible(true);
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					otherWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0, 0)); // 스크롤 원점으로
					otherWindow.setModal(true);
				}
			});
		}
	}

	private javax.swing.JLabel profileImgLabel;
	private java.awt.Image profileImg;
	private javax.swing.JButton IDBtn;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JToggleButton likeBtn;
	private OtherPageWindow otherWindow;

	Image heart;
	Image heart_f;
	Image heart_p;
	Image heart_fp;
	ImageIcon heartI;
	ImageIcon heartI_f;
	ImageIcon heartI_p;
	ImageIcon heartI_fp;
}
