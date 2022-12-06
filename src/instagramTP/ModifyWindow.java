package instagramTP;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ModifyWindow extends javax.swing.JDialog implements java.awt.event.ActionListener {
	private static final long serialVersionUID = 1L;
	private String src = null;
	private static Post thisPost = null;

	public ModifyWindow(Integer PID) throws SQLException, IOException {
		initComponents(PID);
	}

	private void initComponents(Integer PID) throws SQLException, IOException {

		GridBagConstraints gridBagConstraints;
		jPanel1 = new javax.swing.JPanel();
		jTextField1 = new javax.swing.JTextArea();
		imageBtn = new javax.swing.JButton();
		modifyBtn = new javax.swing.JButton();
		deleteBtn = new javax.swing.JButton();

		thisPost = ZinCyan.getPostbyPID(PID);
		java.awt.Image nullImg = new ImageIcon("images/nullImage.png").getImage();
		if (thisPost.getInputStream() != null) {
			File tempFile = File.createTempFile(String.valueOf(thisPost.getInputStream().hashCode()), ".tmp");
			tempFile.deleteOnExit();
			Files.copy(thisPost.getInputStream(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			Path tempPath = tempFile.toPath();

			nullImg = new ImageIcon(tempPath.toString()).getImage();
		}

		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().setBackground(new java.awt.Color(245, 245, 245));
		getContentPane().setLayout(new java.awt.FlowLayout());

		jPanel1.setBackground(new java.awt.Color(245, 245, 245));
		jPanel1.setPreferredSize(new java.awt.Dimension(400, 600));
		jPanel1.setLayout(new java.awt.GridBagLayout());

		imageBtn.setIcon(new ImageIcon(nullImg.getScaledInstance(320, 320, Image.SCALE_SMOOTH)));
		imageBtn.setPreferredSize(new java.awt.Dimension(400, 400));
		imageBtn.setLayout(new BorderLayout());
		javax.swing.JLabel lab = new javax.swing.JLabel("modify image");
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		imageBtn.add(lab, BorderLayout.SOUTH);
		imageBtn.setBackground(new java.awt.Color(255, 255, 255));
		imageBtn.setBorder(null);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 0.4;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 5);
		imageBtn.addActionListener(this);
		jPanel1.add(imageBtn, gridBagConstraints);

		jTextField1.setLineWrap(true);
		jTextField1.setText(thisPost.getContent()); // 원래 업로드 되었던 text로 setText
		jTextField1.setToolTipText("");
		jTextField1.setBorder(null);
		jTextField1.setPreferredSize(new java.awt.Dimension(400, 100));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 5);
		jPanel1.add(jTextField1, gridBagConstraints);

		modifyBtn.setText("Modify post"); // modify해서 다시 업로드
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.05;
//		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
		modifyBtn.addActionListener(this);
		jPanel1.add(modifyBtn, gridBagConstraints);

		deleteBtn.setText("Delete post");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.05;
//		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
		deleteBtn.addActionListener(this);
		jPanel1.add(deleteBtn, gridBagConstraints);

		getContentPane().add(jPanel1);

		setLocationRelativeTo(null);
		pack();
	}

	String load() {
		javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
		fileChooser.setDialogTitle("파일 불러오기");
		// fileChooser.getsetDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//안됨
//		fileChooser.setFileFilter(new FileNameExtensionFilter("jpg", "png", "jpeg", "bmp")); // 파일필터
		fileChooser.setMultiSelectionEnabled(false); // 다중 선택 불가
		int returnVal = fileChooser.showOpenDialog(this); // show openDialog

		if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) { // 파일을 선택하였을 때
			try {
				BufferedImage img = ImageIO.read(fileChooser.getSelectedFile());
				java.awt.Image resizedImage = img.getScaledInstance(imageBtn.getWidth(), imageBtn.getHeight(),
						java.awt.Image.SCALE_SMOOTH);
				imageBtn.setIcon(new javax.swing.ImageIcon(resizedImage));
				imageBtn.setText(null);
				System.out.println(fileChooser.getSelectedFile().toString());
				return fileChooser.getSelectedFile().toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("img not selected");
			return null;

		}
		return null;
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		if (arg0.getSource() == imageBtn) { // 버튼이자 이미지 보여주는 용도
			src = load();
		}

		if (arg0.getSource() == modifyBtn) { // 수정해서 업로드
			thisPost.setContent(jTextField1.getText());
			try {
				ZinCyan.modPost(thisPost, src);
			} catch (FileNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			dispose(); // 창닫기
		}

		if (arg0.getSource() == deleteBtn) { // 삭제
			try {
				ZinCyan.delPost(thisPost.getPID());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dispose(); // 창닫기
		}
	}

	// Variables declaration - do not modify
	// private javax.swing.JFileChooser jFileChooser1;
	private javax.swing.JButton imageBtn;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextArea jTextField1;
	private javax.swing.JButton modifyBtn;
	private javax.swing.JButton deleteBtn;
	// End of variables declaration
}
