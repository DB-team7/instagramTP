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
        setIconImage(nullImg);	// �����ӹ� ������ �켱 ��������
	    setSize(1000, 600);
	    setLocationRelativeTo(null);
	    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);	//����ȵ�
	    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    
	    getContentPane().setBackground(new java.awt.Color(245, 245, 245));
	    getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);    
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new java.awt.Dimension(470, 560));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);	//��ũ�� �ӵ� ����
        scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0,0));	//��ũ�ѹ� �����
        
        scrollBackPane.setBackground(new java.awt.Color(245, 245, 245));
        scrollBackPane.setLayout(new javax.swing.BoxLayout(scrollBackPane, javax.swing.BoxLayout.Y_AXIS));
        
        // �������� ����
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
        
        // �ٸ� ��� ������
        otherDataPanel.setBackground(new java.awt.Color(255, 255, 255));
        //otherDataPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));	//���� ����
        //otherDataPanel.setPreferredSize(new java.awt.Dimension(470, 120));
        otherDataPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        idLabel.setText("recyan__");
        otherDataPanel.add(idLabel);

        nameLabel.setForeground(new java.awt.Color(142, 142, 142));
        nameLabel.setText("������");
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
        followToggleBtn.setText("follow");	// �⺻ ����: �� ����� �ȷο��ϰ� ������ unfollow, �ƴϸ� follow�� setText
        followToggleBtn.setSelected(false);	// �⺻ ����: �� ����� �ȷο��ϰ� ������ true, �ƴϸ� false
        followToggleBtn.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
              if(followToggleBtn.isSelected())
              {
            	  // follow ����
            	  followToggleBtn.setText("unfollow");	// ���� �ȷο� ���̴ϱ� �ٽ� ������ ���ȵȴٴ� ��
              }
              else
              {
            	  // unfollow ����
            	  followToggleBtn.setText("follow");	// ���� ���� �����ϱ� �ٽ� ������ �ȷο�ȴٴ� ��
              }
            }
          });
        otherDataPanel.add(followToggleBtn);
        
        blockToggleBtn.setText("block");	// �⺻ ����: �� ����� ��������� unblock, �ƴϸ� block���� setText
        blockToggleBtn.setSelected(false);	// �⺻ ����: �� ����� ��������� true, �ƴϸ� false
        blockToggleBtn.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
              if(blockToggleBtn.isSelected())
              {
            	  // block ����
            	  blockToggleBtn.setText("unblock");	// ���� ��� ���̴ϱ� �ٽ� ������ ��� �����ȴٴ� ��
              }
              else
              {
            	  // unblock(�������) ����
            	  blockToggleBtn.setText("follow");	// ���� ��� ���������ϱ� �ٽ� ������ ����ȴٴ� ��
              }
            }
          });
        otherDataPanel.add(blockToggleBtn);
        // �ǳʰǳ� ���� �������� ����Ǿ��� ���� ���ʿ� ���� �ʰ� �ϰų� follow,block ��ư�� �Ⱥ��̰� �ؾ� ��.
        

        scrollBackPane.add(otherDataPanel);
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
        
        // �Խñ� ��
        postNumPanel.setBackground(new java.awt.Color(245, 245, 245));
        postNumPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        postNumLabel.setText("4 Posts by recyan__");
        postNumPanel.add(postNumLabel);

        scrollBackPane.add(postNumPanel);
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
        
        // �Խñ� post
        PostPanel postPanel = new PostPanel();
        scrollBackPane.add(postPanel);
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
        //���ο����� �Խñ� ���� ������ �� ���� �־��ֱ�
        
        PostPanel postPanel2 = new PostPanel();
        scrollBackPane.add(postPanel2);
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
       
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
	    	if(arg0.getSource() == followerBtn){	// �ȷο�,�ȷ��� ��ư �ѱ�� data �ٸ���
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
