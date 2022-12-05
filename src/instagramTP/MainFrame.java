package instagramTP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements java.awt.event.ActionListener {

	private static final long serialVersionUID = 1L;
	private static String userID = null;

	public MainFrame(String UID) throws SQLException, IOException {
		initComponents(UID);
	}

	public void initComponents(String UID) throws SQLException, IOException {
		userID = UID;
		//		setTitle("In*gram");

		// set minimum size of frame(window)
		double magn = 1080 / Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		double minX = 570 * magn;
		double minY = 620 * magn;
		setMinimumSize(new Dimension((int) minX, (int) minY));

		setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
		setLocationRelativeTo(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		headerPane = new JPanel();
		jLabel1 = new JLabel();
		uploadBtn = new JButton();
		homeFeedBtn = new JButton();
		searchBtn = new JButton();
		starFeedBtn = new JButton();
		myPageBtn = new JButton();

		// load images
		upload = new ImageIcon("images/upload.png").getImage();
		home = new ImageIcon("images/home.png").getImage();
		search = new ImageIcon("images/search.png").getImage();
		star = new ImageIcon("images/star.png").getImage();
		mypage = new ImageIcon("images/mypage.png").getImage();

		upload_f = new ImageIcon("images/upload_filled.png").getImage();
		home_f = new ImageIcon("images/home_filled.png").getImage();
		search_f = new ImageIcon("images/search_filled.png").getImage();
		star_f = new ImageIcon("images/star_filled.png").getImage();
		mypage_f = new ImageIcon("images/mypage_filled.png").getImage();

		upload_h = new ImageIcon("images/upload_hovered.png").getImage();
		home_h = new ImageIcon("images/home_hovered.png").getImage();
		search_h = new ImageIcon("images/search_hovered.png").getImage();
		star_h = new ImageIcon("images/star_hovered.png").getImage();
		mypage_h = new ImageIcon("images/mypage_hovered.png").getImage();

		// image to imageIcon
		uploadI = new ImageIcon(upload.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		homeI = new ImageIcon(home.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		searchI = new ImageIcon(search.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		starI = new ImageIcon(star.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		mypageI = new ImageIcon(mypage.getScaledInstance(30, 30, Image.SCALE_SMOOTH));

		uploadI_f = new ImageIcon(upload_f.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		homeI_f = new ImageIcon(home_f.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		searchI_f = new ImageIcon(search_f.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		starI_f = new ImageIcon(star_f.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		mypageI_f = new ImageIcon(mypage_f.getScaledInstance(30, 30, Image.SCALE_SMOOTH));

		uploadI_h = new ImageIcon(upload_h.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		homeI_h = new ImageIcon(home_h.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		searchI_h = new ImageIcon(search_h.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		starI_h = new ImageIcon(star_h.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
		mypageI_h = new ImageIcon(mypage_h.getScaledInstance(30, 30, Image.SCALE_SMOOTH));

		// headerPanel init
		headerPane.setBackground(Color.WHITE);
		headerPane.setPreferredSize(new Dimension(1000, 60));
		//		headerPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 12, 24));
		javax.swing.GroupLayout headerPaneLayout = new javax.swing.GroupLayout(headerPane);
		headerPane.setLayout(headerPaneLayout);
		headerPaneLayout
		.setHorizontalGroup(headerPaneLayout.createSequentialGroup()
				.addGap(20, 20, 20)
				.addComponent(jLabel1)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(uploadBtn)
				.addGap(10, 10, 10)
				.addComponent(homeFeedBtn)
				.addGap(10, 10, 10)
				.addComponent(searchBtn)
				.addGap(10, 10, 10)
				.addComponent(starFeedBtn)
				.addGap(10, 10, 10)
				.addComponent(myPageBtn)
				.addGap(20, 20, 20));
		headerPaneLayout.setVerticalGroup(headerPaneLayout.createSequentialGroup()
				.addGap(15, 15, 15)
				.addGroup(headerPaneLayout.createParallelGroup()
						.addComponent(jLabel1).addComponent(uploadBtn).addComponent(homeFeedBtn)
						.addComponent(searchBtn).addComponent(starFeedBtn).addComponent(myPageBtn)));

		jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 20));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("in*gram");

		// header components init // 버튼 색은 이미지 넣기 전에 임시로
		uploadBtn.setPreferredSize(new Dimension(30, 30));
		uploadBtn.setBorder(null);
		uploadBtn.setIcon(uploadI);
		uploadBtn.setRolloverIcon(uploadI_h);
		uploadBtn.addActionListener(this);

		homeFeedBtn.setPreferredSize(new Dimension(30, 30));
		homeFeedBtn.setBorder(null);
		homeFeedBtn.setIcon(homeI_f);
		homeFeedBtn.setRolloverIcon(homeI_h);
		homeFeedBtn.addActionListener(this);

		searchBtn.setPreferredSize(new Dimension(30, 30));
		searchBtn.setBorder(null);
		searchBtn.setIcon(searchI);
		searchBtn.setRolloverIcon(searchI_h);
		searchBtn.addActionListener(this);

		starFeedBtn.setPreferredSize(new Dimension(30, 30));
		starFeedBtn.setBorder(null);
		starFeedBtn.setIcon(starI);
		starFeedBtn.setRolloverIcon(starI_h);
		starFeedBtn.addActionListener(this);

		myPageBtn.setPreferredSize(new Dimension(30, 30));
		myPageBtn.setBorder(null);
		myPageBtn.setIcon(mypageI);
		myPageBtn.setRolloverIcon(mypageI_h);
		myPageBtn.addActionListener(this);

		// add to headerPanel
		//		headerPane.add(jLabel1);
		//		headerPane.add(uploadBtn);
		//		headerPane.add(homeFeedBtn);
		//		headerPane.add(searchBtn);
		//		headerPane.add(starFeedBtn);
		//		headerPane.add(myPageBtn);

		// add to MainFrame. 헤더 버튼에 따라 다르게 뜨게. 기본은 homeFeedPane(PanelHomeFeed)
		getContentPane().add(headerPane, BorderLayout.NORTH);

		homeFeedPane = new PanelHomeFeed(UID);
		getContentPane().add(homeFeedPane, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (arg0.getSource() == uploadBtn) {
			uploadWdw = new UploadWindow(userID);
			uploadWdw.setVisible(true);
		}

		if (arg0.getSource() == homeFeedBtn) {
			getContentPane().removeAll();
			getContentPane().add(headerPane, BorderLayout.NORTH);
			try {
				homeFeedPane = new PanelHomeFeed(userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getContentPane().add(homeFeedPane, BorderLayout.CENTER);
			getContentPane().setVisible(false);
			homeFeedBtn.setIcon(homeI_f);
			searchBtn.setIcon(searchI);
			starFeedBtn.setIcon(starI);
			myPageBtn.setIcon(mypageI);
			getContentPane().setVisible(true);
		}

		if (arg0.getSource() == searchBtn) {
			getContentPane().removeAll();
			getContentPane().add(headerPane, BorderLayout.NORTH);
			try {
				searchPane = new PanelSearch(userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getContentPane().add(searchPane, BorderLayout.CENTER);
			getContentPane().setVisible(false);
			homeFeedBtn.setIcon(homeI);
			searchBtn.setIcon(searchI_f);
			starFeedBtn.setIcon(starI);
			myPageBtn.setIcon(mypageI);
			getContentPane().setVisible(true);
		}

		if (arg0.getSource() == starFeedBtn) {
			getContentPane().removeAll();
			getContentPane().add(headerPane, BorderLayout.NORTH);
			try {
				starFeedPane = new PanelStarFeed(userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//			} catch (IOException e) {
				//				// TODO Auto-generated catch block
				//				e.printStackTrace();
			}
			getContentPane().add(starFeedPane, BorderLayout.CENTER);
			getContentPane().setVisible(false);
			homeFeedBtn.setIcon(homeI);
			searchBtn.setIcon(searchI);
			starFeedBtn.setIcon(starI_f);
			myPageBtn.setIcon(mypageI);
			getContentPane().setVisible(true);
		}

		if (arg0.getSource() == myPageBtn) {
			getContentPane().removeAll();
			getContentPane().add(headerPane, BorderLayout.NORTH);
			try {
				myPagePane = new PanelMyPage(userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getContentPane().add(myPagePane, BorderLayout.CENTER);
			getContentPane().setVisible(false);
			homeFeedBtn.setIcon(homeI);
			searchBtn.setIcon(searchI);
			starFeedBtn.setIcon(starI);
			myPageBtn.setIcon(mypageI_f);
			getContentPane().setVisible(true);
		}

	}

	private javax.swing.JPanel headerPane;
	private javax.swing.JLabel jLabel1;
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

	Image upload;
	Image upload_f;
	Image upload_h;
	Image home;
	Image home_f;
	Image home_h;
	Image search;
	Image search_f;
	Image search_h;
	Image star;
	Image star_f;
	Image star_h;
	Image mypage;
	Image mypage_f;
	Image mypage_h;

	ImageIcon uploadI;
	ImageIcon uploadI_f;
	ImageIcon uploadI_h;
	ImageIcon homeI;
	ImageIcon homeI_f;
	ImageIcon homeI_h;
	ImageIcon searchI;
	ImageIcon searchI_f;
	ImageIcon searchI_h;
	ImageIcon starI;
	ImageIcon starI_f;
	ImageIcon starI_h;
	ImageIcon mypageI;
	ImageIcon mypageI_f;
	ImageIcon mypageI_h;

}
