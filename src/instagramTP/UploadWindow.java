package instagramTP;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UploadWindow extends javax.swing.JDialog implements java.awt.event.ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
//	Post post=new Post();

	/**
	 * Creates new form UploadWindow
	 */
	public UploadWindow(String UID) {
		initComponents(UID);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents(String UID) {
		userID = UID;

		// jFileChooser1 = new javax.swing.JFileChooser();
		jTextField1 = new javax.swing.JTextField();
		imageBtn = new javax.swing.JButton();
		uploadBtn = new javax.swing.JButton();

		java.awt.Image nullImg = new javax.swing.ImageIcon("images/nullImage.png").getImage();
		setIconImage(nullImg); // 프레임바 아이콘 우선 투명으로
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().setBackground(new java.awt.Color(245, 245, 245));
		getContentPane().setLayout(new java.awt.FlowLayout());

//        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users"));
//        jFileChooser1.setPreferredSize(new java.awt.Dimension(400, 400));
//        getContentPane().add(jFileChooser1);

		imageBtn.setText("upload image");
		imageBtn.setPreferredSize(new java.awt.Dimension(400, 400));
		imageBtn.setBackground(new java.awt.Color(255, 255, 255));
		imageBtn.setBorder(null);
		imageBtn.addActionListener(this);

		jTextField1.setText("Write anything to post...");
		jTextField1.setToolTipText("");
		jTextField1.setForeground(Color.GRAY);
		jTextField1.addFocusListener(new FocusListener() { // when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField1.getText().equals("")) {
					jTextField1.setText("Write anything to post...");
					jTextField1.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField1.getText().equals("Write anything to post...")) {
					jTextField1.setText("");
					jTextField1.setForeground(Color.BLACK);
				}
			}
		});
		jTextField1.setBorder(null);
		jTextField1.setPreferredSize(new java.awt.Dimension(400, 400));


		uploadBtn.setText("Upload post");
		uploadBtn.addActionListener(this);

		getContentPane().add(imageBtn);
		getContentPane().add(jTextField1);
		getContentPane().add(uploadBtn);

		pack();
	}

	String load() {
		javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
		fileChooser.setDialogTitle("파일 불러오기");
		// fileChooser.getsetDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//안됨
		fileChooser.setFileFilter(new FileNameExtensionFilter("jpeg", "jpg", "png", "bmp")); // 파일필터
		fileChooser.setMultiSelectionEnabled(false); // 다중 선택 불가
		int returnVal = fileChooser.showOpenDialog(this); // show openDialog

		if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) { // 파일을 선택하였을 때
			try {
				java.awt.image.BufferedImage img = ImageIO.read(fileChooser.getSelectedFile());
				java.awt.Image resizedImage = img.getScaledInstance(imageBtn.getWidth(), imageBtn.getHeight(),
						java.awt.Image.SCALE_SMOOTH);
				imageBtn.setIcon(new javax.swing.ImageIcon(resizedImage));
				imageBtn.setText(null);
				return fileChooser.getSelectedFile().toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		String src = new String();
		// TODO Auto-generated method stub
		if (arg0.getSource() == imageBtn) { // 버튼이자 이미지 보여주는 용도
			src = load();
		}

		if (arg0.getSource() == uploadBtn) { // 업로드
			Post post = new Post();
			post.setUID(userID);
			post.setContent(jTextField1.getText());
			try {
				post.setCreateDate(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
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
	private javax.swing.JTextField jTextField1;
	private javax.swing.JButton uploadBtn;
	// End of variables declaration
}
