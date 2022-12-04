package instagramTP;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import com.formdev.flatlaf.FlatClientProperties;

public class PostPanel extends javax.swing.JPanel implements java.awt.event.ActionListener {

	private static final long serialVersionUID = 1L;
	private String postOwnerID = null;
	private String myUserID = null;
	private Integer postID = null;

	public PostPanel(int PID, String myUID) throws SQLException, IOException {
		initComponents(PID, myUID);
	}

	private void initComponents(int PID, String myUID) throws SQLException, IOException {

		myUserID = myUID;
		postID = PID;

		IDBtn = new javax.swing.JButton();
		moreBtn = new javax.swing.JButton();
		likePane = new javax.swing.JPanel();
		likeBtn = new javax.swing.JToggleButton();
		likeNumLabel = new javax.swing.JLabel();
		createdAtLabel = new javax.swing.JLabel();
		postTextArea = new javax.swing.JTextArea();
		commentPane = new javax.swing.JPanel();
		commentWindowBtn = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		postCommentBtn = new javax.swing.JButton();

		// load images
		heart = new ImageIcon("images/heart.png").getImage();
		heart_f = new ImageIcon("images/heart_filled.png").getImage();
		heart_p = new ImageIcon("images/heart_pressed1.png").getImage();
		heart_fp = new ImageIcon("images/heart_pressed2.png").getImage();
		comment = new ImageIcon("images/comment.png").getImage();
		comment_h = new ImageIcon("images/comment_hovered.png").getImage();

		// image to imageIcon
		heartI = new ImageIcon(heart.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		heartI_f = new ImageIcon(heart_f.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		heartI_p = new ImageIcon(heart_p.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		heartI_fp = new ImageIcon(heart_fp.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		commentI = new ImageIcon(comment.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		commentI_h = new ImageIcon(comment_h.getScaledInstance(30, 30, Image.SCALE_SMOOTH));

		setBackground(new java.awt.Color(255, 255, 255));
		putClientProperty(FlatClientProperties.STYLE, "arc: 30");

		Post post = ZinCyan.getPostbyPID(PID);
		postOwnerID = ZinCyan.getUserNamebyPID(PID);
		User postOwner = ZinCyan.getUserByUID(postOwnerID);

		Image img = new ImageIcon("images/basicProfilePhoto.png").getImage();
		if (postOwner.getInputStream() != null) {
			File tempFile = File.createTempFile(String.valueOf(postOwner.getInputStream().hashCode()), ".tmp");
			tempFile.deleteOnExit();
			Files.copy(postOwner.getInputStream(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			Path tempPath = tempFile.toPath();

			img = (new ImageIcon(tempPath.toString()).getImage()).getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		}
		profileImg = new ImagePanel(img);

		// profileImg.putClientProperty(FlatClientProperties.STYLE, "arc: 999"); // 동그랗게
		// 만들기 실패...

		IDBtn.setText(postOwnerID);
		IDBtn.setBorder(null);
		IDBtn.setBackground(null);
		IDBtn.addActionListener(this); // ID 클릭하면 그 사람 페이지로 (OtherPageWindow.java)

		// 본인 계정에서만 뜨게 세팅
		moreBtn.setBorder(null);
		moreBtn.setBackground(null);
		if (postOwnerID.equals(myUID)) {
			moreBtn.setFont(new java.awt.Font("Roboto", 1, 14));
			moreBtn.setText("...");
			moreBtn.addActionListener(this); // 게시글 수정, 삭제 창. 애초에 본인 게시글에만 이 버튼이 떠야 함
		}

		java.awt.Image nullImg = new javax.swing.ImageIcon("images/nullImage.png").getImage();
		if (post.getInputStream() != null) {
			File tempFile2 = File.createTempFile(String.valueOf(post.getInputStream().hashCode()), ".tmp");
			tempFile2.deleteOnExit();
			Files.copy(post.getInputStream(), tempFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
			Path tempPath = tempFile2.toPath();

			nullImg = (new ImageIcon(tempPath.toString()).getImage()).getScaledInstance(466, 466, Image.SCALE_SMOOTH);
		}
		imagePane = new ImagePanel(nullImg);

		// likePane
		likePane.setBackground(null);

		likeBtn.setBackground(null);
		likeBtn.setBorder(null);
		likeBtn.setPressedIcon(heartI_fp);
		if (ZinCyan.isLike(myUID, PID)) {
			likeBtn.setIcon(heartI_f); // 기본 설정: 이 글을 좋아요했으면 heartI_f(꽉찬하트), 아니면 heartI(빈하트)로 setIcon
			likeBtn.setSelected(true); // 기본 설정: 이 글을 좋아요했으면 true, 아니면 false
		} else {
			likeBtn.setIcon(heartI); // 기본 설정: 이 글을 좋아요했으면 heartI_f(꽉찬하트), 아니면 heartI(빈하트)로 setIcon
			likeBtn.setSelected(false); // 기본 설정: 이 글을 좋아요했으면 true, 아니면 false
		}

		likeBtn.addItemListener(new java.awt.event.ItemListener() {
			@Override
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				if (likeBtn.isSelected()) {
					likeBtn.setIcon(heartI_f); // 좋아요 누른 상태
					likeBtn.setPressedIcon(heartI_p);
					likeNumLabel.revalidate();
					likeNumLabel.repaint();
					try {
						ZinCyan.unLike(myUID, PID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					likeBtn.setIcon(heartI); // 좋아요 안한 상태
					likeBtn.setPressedIcon(heartI_fp);
					likeNumLabel.revalidate();
					likeNumLabel.repaint();
					try {
						ZinCyan.like(myUID, PID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		likeNumLabel.setText(ZinCyan.getLikeNum(PID));
		createdAtLabel.setText(ZinCyan.getTimeBack(PID));
		createdAtLabel.setForeground(Color.GRAY);

		javax.swing.GroupLayout likePaneLayout = new javax.swing.GroupLayout(likePane);
		likePane.setLayout(likePaneLayout);
		likePaneLayout.setHorizontalGroup(likePaneLayout.createSequentialGroup()
				.addComponent(createdAtLabel, 205, 205, 205) // (470/2) - (30/2) - W_GAP
				.addComponent(likeBtn, 30, 30, 30).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(likeNumLabel));
		likePaneLayout.setVerticalGroup(likePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
				.addComponent(createdAtLabel).addComponent(likeBtn).addComponent(likeNumLabel));

		// postTextArea
		postTextArea.setEditable(false);
		postTextArea.setBackground(null);
		postTextArea.setLineWrap(true);
		postTextArea.setMargin(null);
		postTextArea.setText(post.getContent());

		// commentPane
		commentPane.setBackground(null);
		commentPane.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));

		commentWindowBtn.setBorder(null);
		commentWindowBtn.setBackground(null);
		commentWindowBtn.setIcon(commentI);
		commentWindowBtn.setPressedIcon(commentI_h);
		commentWindowBtn.addActionListener(this);

		jTextField1.setText("leave a comment...");
		jTextField1.setBorder(null);
		jTextField1.setForeground(Color.GRAY);
		jTextField1.addFocusListener(new FocusListener() { // when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField1.getText().equals("")) {
					jTextField1.setText("leave a comment...");
					jTextField1.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField1.getText().equals("leave a comment...")) {
					jTextField1.setText("");
					jTextField1.setForeground(Color.BLACK);
				}
			}
		});

		postCommentBtn.setBorder(null);
		postCommentBtn.setBackground(null);
		postCommentBtn.setText("comment");
		postCommentBtn.setForeground(new Color(141, 196, 177));
		postCommentBtn.addActionListener(this);

		javax.swing.GroupLayout commentPaneLayout = new javax.swing.GroupLayout(commentPane);
		commentPane.setLayout(commentPaneLayout);
		commentPaneLayout
				.setHorizontalGroup(commentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
						.addGroup(commentPaneLayout.createSequentialGroup().addGap(W_GAP, W_GAP, W_GAP)
								.addComponent(commentWindowBtn, 30, 30, 30).addGap(W_GAP, W_GAP, W_GAP)
								.addComponent(jTextField1, 300, 300, 300)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(postCommentBtn).addGap(W_GAP, W_GAP, W_GAP)));
		commentPaneLayout.setVerticalGroup(commentPaneLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
				.addGroup(commentPaneLayout.createSequentialGroup().addGap(GAP, GAP, GAP)
						.addGroup(commentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(commentWindowBtn, 30, 30, 30).addComponent(jTextField1, 30, 30, 30)
								.addComponent(postCommentBtn, 30, 30, 30))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(W_GAP, W_GAP, W_GAP)
						.addComponent(profileImg, 32, 32, 32).addGap(8, 8, 8).addComponent(IDBtn)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(moreBtn).addGap(W_GAP, W_GAP, W_GAP))
				.addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addComponent(imagePane, 466, 466, 466)
						.addGap(2, 2, 2))
				.addGroup(layout.createSequentialGroup().addGap(W_GAP, W_GAP, W_GAP).addComponent(likePane)
						.addGap(W_GAP, W_GAP, W_GAP))
				.addGroup(layout.createSequentialGroup().addGap(W_GAP, W_GAP, W_GAP).addComponent(postTextArea)
						.addGap(W_GAP, W_GAP, W_GAP))
				.addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addComponent(commentPane).addGap(2, 2, 2)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
				.addGroup(layout.createSequentialGroup().addGap(H_GAP, H_GAP, H_GAP)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
								.addComponent(profileImg, 32, 32, 32).addComponent(IDBtn).addComponent(moreBtn))
						.addGap(GAP, GAP, GAP).addComponent(imagePane, 468, 468, 468).addGap(GAP, GAP, GAP)
						.addComponent(likePane).addGap(GAP, GAP, GAP).addComponent(postTextArea).addGap(GAP, GAP, GAP)
						.addComponent(commentPane).addGap(H_GAP, H_GAP, H_GAP)));
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == IDBtn) {
			try {
				System.out.println("아이디버튼 눌림");
				System.out.println(postOwnerID);
				System.out.println(myUserID);
				if (!postOwnerID.equals(myUserID)) {
					otherWindow = new OtherPageWindow(postOwnerID, myUserID);
					otherWindow.setVisible(true);
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}

			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					if (!postOwnerID.equals(myUserID)) {
						otherWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0, 0));
						otherWindow.setModal(true);
					}

				}
			});
		}

		if (arg0.getSource() == commentWindowBtn) {
			try {
				if (ZinCyan.getCommentNumByPID(postID) != 0) {
					cmtWindow = new CommentWindow(postID, myUserID);
					cmtWindow.setVisible(true);
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							cmtWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0, 0));
							cmtWindow.setModal(true);
						}
					});
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (arg0.getSource() == moreBtn) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						mdfyWindow = new ModifyWindow(postID);
					} catch (SQLException | IOException e) {
						e.printStackTrace();
					}
					mdfyWindow.setVisible(true);
					mdfyWindow.setModal(true);
				}
			});
		}

		if (arg0.getSource() == postCommentBtn) {
//			System.out.println("댓글왜안됨");
			Comment comment = new Comment();
			comment.setUID(myUserID);
			comment.setPID(postID);
			comment.setContent(jTextField1.getText());
			try {
				comment.setCreateDate(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				System.out.println("댓글");
				ZinCyan.initComment(comment);
			} catch (FileNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// Variables declaration
	private ImagePanel profileImg;
	private javax.swing.JPanel commentPane;
	private javax.swing.JButton commentWindowBtn;
	private javax.swing.JLabel createdAtLabel;
	private javax.swing.JButton IDBtn;
	private ImagePanel imagePane;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JToggleButton likeBtn;
	private javax.swing.JLabel likeNumLabel;
	private javax.swing.JPanel likePane;
	private javax.swing.JButton moreBtn;
	private javax.swing.JButton postCommentBtn;
	private javax.swing.JTextArea postTextArea;
	private OtherPageWindow otherWindow;
	private CommentWindow cmtWindow;
	private ModifyWindow mdfyWindow;

	Image heart;
	Image heart_f;
	Image heart_p;
	Image heart_fp;
	ImageIcon heartI;
	ImageIcon heartI_f;
	ImageIcon heartI_p;
	ImageIcon heartI_fp;
	Image comment;
	Image comment_h;
	ImageIcon commentI;
	ImageIcon commentI_h;

	final int GAP = 12;
	final int H_GAP = 18;
	final int W_GAP = 15;
	// End of variables declaration
}
