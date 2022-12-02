package instagramTP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements java.awt.event.ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String userID = null;

	public MainFrame(String UID) throws SQLException, IOException {
		initComponents(UID);
	}

	public void initComponents(String UID) throws SQLException, IOException {
		userID = UID;
		setTitle("In*gram");
		// setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // �̰ɷ� ��ü ȭ�� ��ü
		setLocationRelativeTo(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//        // ��ü ȭ��
//        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice device = graphics.getDefaultScreenDevice();
//        device.setFullScreenWindow(this);
//        //frame.setUndecorated(true);   //�ְԵǸ� ����. ���ҵ�

		headerPane = new JPanel();
		uploadBtn = new JButton();
		homeFeedBtn = new JButton();
		searchBtn = new JButton();
		starFeedBtn = new JButton();
		myPageBtn = new JButton();

		homeFeedPane = new PanelHomeFeed(UID);
		searchPane = new PanelSearch(UID);
		starFeedPane = new PanelStarFeed(UID);
		myPagePane = new PanelMyPage(UID);

		// headerPanel init
		headerPane.setBackground(Color.WHITE);
		headerPane.setPreferredSize(new Dimension(1000, 60));
		headerPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 12, 24));

		// header components init // ��ư ���� �̹��� �ֱ� ���� �ӽ÷�
		uploadBtn.setPreferredSize(new Dimension(24, 24));
		uploadBtn.setBackground(new Color(228, 113, 122)); // ���ε��ư-����
		uploadBtn.addActionListener(this);

		homeFeedBtn.setPreferredSize(new Dimension(24, 24));
		homeFeedBtn.setBackground(new Color(253, 253, 150)); // Ȩ�ǵ��ư-���
		homeFeedBtn.addActionListener(this);

		searchBtn.setPreferredSize(new Dimension(24, 24));
		searchBtn.setBackground(new Color(173, 223, 173)); // �˻���ư-�ʷ�
		searchBtn.addActionListener(this);

		starFeedBtn.setPreferredSize(new Dimension(24, 24));
		starFeedBtn.setBackground(new Color(119, 158, 203)); // �α��ǵ��ư-�Ķ�
		starFeedBtn.addActionListener(this);

		myPageBtn.setPreferredSize(new Dimension(24, 24));
		myPageBtn.setBackground(new Color(203, 153, 201)); // ������������ư-����
		myPageBtn.addActionListener(this);

		// add to headerPanel
		headerPane.add(uploadBtn);
		headerPane.add(homeFeedBtn);
		headerPane.add(searchBtn);
		headerPane.add(starFeedBtn);
		headerPane.add(myPageBtn);

		// add to MainFrame. ��� ��ư�� ���� �ٸ��� �߰�. �⺻�� homeFeedPane(PanelHomeFeed)
		getContentPane().add(headerPane, BorderLayout.NORTH);
		getContentPane().add(homeFeedPane, BorderLayout.CENTER);

	}

//	public static void main(String args[]) throws SQLException {
//		MainFrame frame = new MainFrame();
//		// frame.pack();//x
//		frame.setVisible(true);
//	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (arg0.getSource() == uploadBtn) {
			uploadWdw = new UploadWindow(userID);
			uploadWdw.setVisible(true);
			// uploadWdw.setModal(true); //�������� �ϴ� �ּ�
		}

		if (arg0.getSource() == homeFeedBtn) {
			getContentPane().removeAll();
			getContentPane().add(headerPane, BorderLayout.NORTH); // ��ư icon �ٲ�� �͵� �߰� ����
			getContentPane().add(homeFeedPane, BorderLayout.CENTER);
			getContentPane().setVisible(false);
			getContentPane().setVisible(true);
		}

		if (arg0.getSource() == searchBtn) {
			getContentPane().removeAll();
			getContentPane().add(headerPane, BorderLayout.NORTH); // ��ư icon �ٲ�� �͵� �߰� ����
			getContentPane().add(searchPane, BorderLayout.CENTER);
			getContentPane().setVisible(false);
			getContentPane().setVisible(true);
		}

		if (arg0.getSource() == starFeedBtn) {
			getContentPane().removeAll();
			getContentPane().add(headerPane, BorderLayout.NORTH); // ��ư icon �ٲ�� �͵� �߰� ����
			getContentPane().add(starFeedPane, BorderLayout.CENTER);
			getContentPane().setVisible(false);
			getContentPane().setVisible(true);
		}

		if (arg0.getSource() == myPageBtn) {
			getContentPane().removeAll();
			getContentPane().add(headerPane, BorderLayout.NORTH); // ��ư icon �ٲ�� �͵� �߰� ����
			getContentPane().add(myPagePane, BorderLayout.CENTER);
			getContentPane().setVisible(false);
			getContentPane().setVisible(true);
		}

	}

	private javax.swing.JPanel headerPane;
	private javax.swing.JButton uploadBtn;
	private javax.swing.JButton homeFeedBtn;
	private javax.swing.JButton searchBtn;
	private javax.swing.JButton starFeedBtn;
	private javax.swing.JButton myPageBtn;

	private PanelHomeFeed homeFeedPane;
	private PanelSearch searchPane;
	private PanelStarFeed starFeedPane;
	private PanelMyPage myPagePane;
	private UploadWindow uploadWdw;

}
