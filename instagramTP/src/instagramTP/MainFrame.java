package instagramTP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame{
	
    public void init() {
        setTitle("In*gram");	
        setResizable(false);
        setLocationRelativeTo(null);
        
        // 전체 화면
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(this);
        //frame.setUndecorated(true);   //넣게되면 위로
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    public static void main(String args[]) {
    	MainFrame frame = new MainFrame();
        JPanel headerPane = new JPanel();
        JButton uploadBtn = new JButton();
        JButton homeFeedBtn = new JButton();
        JButton searchBtn = new JButton();
        JButton starFeedBtn = new JButton();
        JButton myPageBtn = new JButton();
        
        PanelHomeFeed homeFeedPane = new PanelHomeFeed();
        PanelSearch serchPane = new PanelSearch();
        PanelMyPage myPagePane = new PanelMyPage();
        
        // headerPanel init
        headerPane.setBackground(Color.WHITE);
        headerPane.setPreferredSize(new Dimension(1000, 60));
        headerPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 12, 24));
        // header components init	// 버튼 색은 이미지 넣기 전에 임시로
        uploadBtn.setPreferredSize(new Dimension(24, 24));
        uploadBtn.setBackground(new Color(228,113,122));	//업로드버튼-빨강
        homeFeedBtn.setPreferredSize(new Dimension(24, 24));
        homeFeedBtn.setBackground(new Color(253,253,150));	//홈피드버튼-노랑
        searchBtn.setPreferredSize(new Dimension(24, 24));
        searchBtn.setBackground(new Color(173,223,173));	//검색버튼-초록
        starFeedBtn.setPreferredSize(new Dimension(24, 24));
        starFeedBtn.setBackground(new Color(119,158,203));	//인기피드버튼-파랑
        myPageBtn.setPreferredSize(new Dimension(24, 24));
        myPageBtn.setBackground(new Color(203,153,201));	//마이페이지버튼-보라
        // add to headerPanel
        headerPane.add(uploadBtn);
        headerPane.add(homeFeedBtn);
        headerPane.add(searchBtn);
        headerPane.add(starFeedBtn);
        headerPane.add(myPageBtn);
        
        // add to MainFrame (panels) -> 헤더 버튼에 따라 다르게 뜨게. 기본은 PanelHomeFeed
        frame.getContentPane().add(headerPane, BorderLayout.NORTH);
        //frame.getContentPane().add(homeFeedPane, BorderLayout.CENTER);
        frame.getContentPane().add(serchPane, BorderLayout.CENTER);
        //frame.getContentPane().add(myPagePane, BorderLayout.CENTER);
        
        frame.pack();
        frame.init();
    }
}
