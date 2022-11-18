package instagramTP;


public class OtherPageWindow extends javax.swing.JDialog implements java.awt.event.ActionListener{

	
	 public OtherPageWindow() {
		 initComponents();
	 }
	
	 public void initComponents() {
		 
		scrollPane = new javax.swing.JScrollPane();
		scrollBackPane = new javax.swing.JPanel();
		otherDataPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        followerBtn = new javax.swing.JButton();
        followerNumLabel = new javax.swing.JLabel();
        followingBtn = new javax.swing.JButton();
        followingNumLabel = new javax.swing.JLabel();
        postNumPanel = new javax.swing.JPanel();
        postNumLabel = new javax.swing.JLabel();
        followToggleBtn = new javax.swing.JToggleButton();
        blockToggleBtn = new javax.swing.JToggleButton();
        
        java.awt.Image nullImg = new javax.swing.ImageIcon("images/nullImage.png").getImage();
        setIconImage(nullImg);	// 프레임바 아이콘 우선 투명으로
	    setSize(1000, 600);
	    setLocationRelativeTo(null);
	    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);	//절대안됨
	    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    
	    getContentPane().setBackground(new java.awt.Color(245, 245, 245));
	    getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);    
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new java.awt.Dimension(470, 560));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);	//스크롤 속도 증가
        scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0,0));	//스크롤바 숨기기
        
        scrollBackPane.setBackground(new java.awt.Color(245, 245, 245));
        scrollBackPane.setLayout(new javax.swing.BoxLayout(scrollBackPane, javax.swing.BoxLayout.Y_AXIS));
        
        // 여백으로 시작
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //패널사이세로여백
        
        // 다른 사람 정보란
        otherDataPanel.setBackground(new java.awt.Color(255, 255, 255));
        //otherDataPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));	//내부 여백
        //otherDataPanel.setPreferredSize(new java.awt.Dimension(470, 120));
        otherDataPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        idLabel.setText("recyan__");
        otherDataPanel.add(idLabel);

        nameLabel.setForeground(new java.awt.Color(142, 142, 142));
        nameLabel.setText("김지원");
        otherDataPanel.add(nameLabel);

        followerBtn.setText("follower");
        followerBtn.setBorder(null);
        followerBtn.setBackground(null);
        followerBtn.addActionListener(this);
        otherDataPanel.add(followerBtn);

        followerNumLabel.setText("116");
        otherDataPanel.add(followerNumLabel);

        followingBtn.setText("following");
        followingBtn.setBorder(null);
        followingBtn.setBackground(null);
        followingBtn.addActionListener(this);
        otherDataPanel.add(followingBtn);
        
        followingNumLabel.setText("143");
        otherDataPanel.add(followingNumLabel);
        
        //followToggleBtn.setBorder(null);
        //followToggleBtn.setBackground(null);
        followToggleBtn.setText("follow");	// 기본 설정: 이 사람을 팔로우하고 있으면 unfollow, 아니면 follow로 setText
        followToggleBtn.setSelected(false);	// 기본 설정: 이 사람을 팔로우하고 있으면 true, 아니면 false
        followToggleBtn.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
              if(followToggleBtn.isSelected())
              {
            	  // follow 상태
            	  followToggleBtn.setText("unfollow");	// 이제 팔로우 중이니까 다시 누르면 언팔된다는 뜻
              }
              else
              {
            	  // unfollow 상태
            	  followToggleBtn.setText("follow");	// 이제 언팔 했으니까 다시 누르면 팔로우된다는 뜻
              }
            }
          });
        otherDataPanel.add(followToggleBtn);
        
        blockToggleBtn.setText("block");	// 기본 설정: 이 사람을 블락했으면 unblock, 아니면 block으로 setText
        blockToggleBtn.setSelected(false);	// 기본 설정: 이 사람을 블락했으면 true, 아니면 false
        blockToggleBtn.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
              if(blockToggleBtn.isSelected())
              {
            	  // block 상태
            	  blockToggleBtn.setText("unblock");	// 이제 블락 중이니까 다시 누르면 블락 해제된다는 뜻
              }
              else
              {
            	  // unblock(블락안한) 상태
            	  blockToggleBtn.setText("follow");	// 이제 블락 해제했으니까 다시 누르면 블락된다는 뜻
              }
            }
          });
        otherDataPanel.add(blockToggleBtn);
        // 건너건너 본인 페이지로 연결되었을 때는 애초에 뜨지 않게 하거나 follow,block 버튼이 안보이게 해야 함.
        

        scrollBackPane.add(otherDataPanel);
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //패널사이세로여백
        
        // 게시글 수
        postNumPanel.setBackground(new java.awt.Color(245, 245, 245));
        postNumPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        postNumLabel.setText("4 Posts by recyan__");
        postNumPanel.add(postNumLabel);

        scrollBackPane.add(postNumPanel);
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //패널사이세로여백
        
        // 게시글 post
        PostPanel postPanel = new PostPanel();
        scrollBackPane.add(postPanel);
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //패널사이세로여백
        //세로여백은 게시글 끝날 때마다 꼭 같이 넣어주기
        
        PostPanel postPanel2 = new PostPanel();
        scrollBackPane.add(postPanel2);
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //패널사이세로여백
       
        scrollPane.setViewportView(scrollBackPane);
	    getContentPane().add(scrollPane);
	    
	}
	
//	public static void main(String args[]) {
//		
//		OtherPageWindow window = new OtherPageWindow();
//		window.setVisible(true);
//	        
////	    java.awt.EventQueue.invokeLater(new Runnable() {
////	        public void run() {
////	        	
////	        }
////	    });
//	}
	 
	 @Override
	    public void actionPerformed(java.awt.event.ActionEvent arg0) {
	            // TODO Auto-generated method stub
	    	if(arg0.getSource() == followerBtn){	// 팔로워,팔로잉 버튼 넘기는 data 다르게
	        	flwWindow = new FollowWindow();
	        	flwWindow.setVisible(true);
	        	java.awt.EventQueue.invokeLater(new Runnable() {
	    	        public void run() {
	    	        	flwWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0,0));
	    	        	flwWindow.setModal(true);
	    	        }
	    	    });
	        }
	    	
	        if(arg0.getSource() == followingBtn){
	        	flwWindow = new FollowWindow();
	          	flwWindow.setVisible(true);
	           	java.awt.EventQueue.invokeLater(new Runnable() {
	           		public void run() {
	        	       	flwWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0,0));
	        	       	flwWindow.setModal(true);
	                }
	        	});
	        }
	     
	    }
	 
	private javax.swing.JPanel otherDataPanel;
	private javax.swing.JButton followerBtn;
	private javax.swing.JLabel followerNumLabel;
    private javax.swing.JButton followingBtn;
	private javax.swing.JLabel followingNumLabel;
	private javax.swing.JLabel idLabel;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JLabel postNumLabel;
	private javax.swing.JPanel postNumPanel;
	private javax.swing.JToggleButton followToggleBtn;
	private javax.swing.JToggleButton blockToggleBtn;
	private javax.swing.JPanel scrollBackPane;
	public javax.swing.JScrollPane scrollPane;
	private FollowWindow flwWindow;
	
}
