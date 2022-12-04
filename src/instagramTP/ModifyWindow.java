package instagramTP;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import javax.imageio.ImageIO;

public class ModifyWindow extends javax.swing.JDialog implements java.awt.event.ActionListener {
	private static final long serialVersionUID = 1L;
	private String src = null;
	private static Post thisPost = null;

	public ModifyWindow(Integer PID) throws SQLException, IOException {
		initComponents(PID);
	}

	private void initComponents(Integer PID) throws SQLException, IOException {

		// jFileChooser1 = new javax.swing.JFileChooser();
		jTextField1 = new javax.swing.JTextField();
		imageBtn = new javax.swing.JButton();
		modifyBtn = new javax.swing.JButton();
		deleteBtn = new javax.swing.JButton();

		thisPost = ZinCyan.getPostbyPID(PID);
		java.awt.Image nullImg = new javax.swing.ImageIcon("images/nullImage.png").getImage();
		if (thisPost.getInputStream() != null) {
			File tempFile = File.createTempFile(String.valueOf(thisPost.getInputStream().hashCode()), ".tmp");
			tempFile.deleteOnExit();
			Files.copy(thisPost.getInputStream(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			Path tempPath = tempFile.toPath();

			nullImg = new javax.swing.ImageIcon(tempPath.toString()).getImage();
		}

		setIconImage(nullImg); // 프레임바 아이콘 우선 투명으로
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().setBackground(new java.awt.Color(245, 245, 245));
		getContentPane().setLayout(new java.awt.FlowLayout());

		imageBtn.setText("modify image"); // 원래 업로드 되었던 이미지로 setIcon
		imageBtn.setPreferredSize(new java.awt.Dimension(400, 400));
		imageBtn.setBackground(new java.awt.Color(255, 255, 255));
		imageBtn.setBorder(null);
		imageBtn.addActionListener(this);

		jTextField1.setText(thisPost.getContent()); // 원래 업로드 되었던 text로 setText
		jTextField1.setToolTipText("");
		jTextField1.setBorder(null);
		jTextField1.setPreferredSize(new java.awt.Dimension(400, 400));

		modifyBtn.setText("Modify post"); // modify해서 다시 업로드
		modifyBtn.addActionListener(this);

		deleteBtn.setText("Delete post");
		deleteBtn.addActionListener(this);

		getContentPane().add(imageBtn);
		getContentPane().add(jTextField1);
		getContentPane().add(modifyBtn);
		getContentPane().add(deleteBtn);

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
				// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		if (arg0.getSource() == imageBtn) { // 버튼이자 이미지 보여주는 용도
			src = load();
		}

		if (arg0.getSource() == modifyBtn) { // 수정해서 업로드
			try {
				ZinCyan.modPost(thisPost, src);
			} catch (FileNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose(); // 창닫기
		}

		if (arg0.getSource() == deleteBtn) { // 삭제
			try {
				ZinCyan.delPost(thisPost.getPID());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose(); // 창닫기
		}
	}

	// Variables declaration - do not modify
	// private javax.swing.JFileChooser jFileChooser1;
	private javax.swing.JButton imageBtn;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JButton modifyBtn;
	private javax.swing.JButton deleteBtn;
	// End of variables declaration
}
