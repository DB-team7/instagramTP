package instagramTP;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UploadWindow extends javax.swing.JDialog implements java.awt.event.ActionListener {
	
	private String src = null;
	private static final long serialVersionUID = 1L;
	private String userID;
//	Post post=new Post();

	public UploadWindow(String UID) {
		initComponents(UID);
	}

	private void initComponents(String UID) {
		userID = UID;

		contentArea = new javax.swing.JTextArea();
		imageBtn = new javax.swing.JButton();
		uploadBtn = new javax.swing.JButton();

		java.awt.Image nullImg = new javax.swing.ImageIcon("images/nullImage.png").getImage();
		setIconImage(nullImg); // 프레임바 아이콘 우선 투명으로
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().setBackground(new java.awt.Color(245, 245, 245));
		getContentPane().setLayout(new java.awt.FlowLayout());

		imageBtn.setText("upload image");
		imageBtn.setPreferredSize(new java.awt.Dimension(400, 400));
		imageBtn.setBackground(new java.awt.Color(255, 255, 255));
		imageBtn.setBorder(null);
		imageBtn.addActionListener(this);

		contentArea.setLineWrap(true);
		contentArea.setMargin(new Insets(30, 30, 30, 30));
		contentArea.setText("Write anything to post...");
		contentArea.setToolTipText("");
		contentArea.setForeground(Color.GRAY);
		contentArea.addFocusListener(new FocusListener() { // when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (contentArea.getText().equals("")) {
					contentArea.setText("Write anything to post...");
					contentArea.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (contentArea.getText().equals("Write anything to post...")) {
					contentArea.setText("");
					contentArea.setForeground(Color.BLACK);
				}
			}
		});
		contentArea.setBorder(null);
		contentArea.setPreferredSize(new java.awt.Dimension(400, 400));

		uploadBtn.setText("Upload post");
		uploadBtn.addActionListener(this);

		getContentPane().add(imageBtn);
		getContentPane().add(contentArea);
		getContentPane().add(uploadBtn);

		pack();
	}

	String load() {
		javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
		fileChooser.setDialogTitle("파일 불러오기");
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
			System.out.println(src);
		}

		if (arg0.getSource() == uploadBtn) { // 업로드
			Post post = new Post();
			post.setUID(userID);
			post.setContent(contentArea.getText());
			try {
				post.setCreateDate(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				System.out.println(src);
				ZinCyan.initPost(post, src);
			} catch (FileNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose(); // 창닫기
		}
	}

	// Variables declaration
	// private javax.swing.JFileChooser jFileChooser1;
	private javax.swing.JButton imageBtn;
	private javax.swing.JTextArea contentArea;
	private javax.swing.JButton uploadBtn;
	// End of variables declaration
}
