package instagramTP;

import javax.imageio.ImageIO;

public class PanelMyPage extends javax.swing.JPanel implements java.awt.event.ActionListener{

    public PanelMyPage() {
        initComponents();
    }
                         
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        ScrollBackPane = new javax.swing.JPanel();
        MyDataPanel = new javax.swing.JPanel();
        imageBtn = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        followerBtn = new javax.swing.JButton();
        followerNumLabel = new javax.swing.JLabel();
        followingBtn = new javax.swing.JButton();
        followingNumLabel = new javax.swing.JLabel();
        postNumPanel = new javax.swing.JPanel();
        postNumLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);    
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new java.awt.Dimension(470, 620));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);	//��ũ�� �ӵ� ����
        scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0,0));	//��ũ�ѹ� �����
        
        ScrollBackPane.setBackground(new java.awt.Color(245, 245, 245));
        ScrollBackPane.setLayout(new javax.swing.BoxLayout(ScrollBackPane, javax.swing.BoxLayout.Y_AXIS));
        
        // �������� ����
        ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
        
        // �� ������
        MyDataPanel.setBackground(new java.awt.Color(255, 255, 255));
        //MyDataPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));	//���� ����
        //MyDataPanel.setPreferredSize(new java.awt.Dimension(470, 120));
        MyDataPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        imageBtn.setPreferredSize(new java.awt.Dimension(60, 60));
        imageBtn.setBackground(new java.awt.Color(255, 255, 255));
        imageBtn.setBorder(null);
        imageBtn.addActionListener(this);	
     
        javax.swing.ImageIcon profileImg = new javax.swing.ImageIcon("images/basicProfilePhoto.png");
        imageBtn.setIcon(profileImg);	// ���� ������ ���� �߰� �ϱ�
        
        MyDataPanel.add(imageBtn);
        
        idLabel.setText("recyan__");
        MyDataPanel.add(idLabel);

        nameLabel.setForeground(new java.awt.Color(142, 142, 142));
        nameLabel.setText("������");
        MyDataPanel.add(nameLabel);

        followerBtn.setText("follower");
        followerBtn.setBorder(null);
        followerBtn.setBackground(null);
        followerBtn.addActionListener(this);
        MyDataPanel.add(followerBtn);

        followerNumLabel.setText("116");
        MyDataPanel.add(followerNumLabel);

        followingBtn.setText("following");
        followingBtn.setBorder(null);
        followingBtn.setBackground(null);
        followingBtn.addActionListener(this);
        MyDataPanel.add(followingBtn);
        
        followingNumLabel.setText("143");
        MyDataPanel.add(followingNumLabel);

        ScrollBackPane.add(MyDataPanel);
        ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
        
        // �Խñ� ��
        postNumPanel.setBackground(new java.awt.Color(245, 245, 245));
        postNumPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        postNumLabel.setText("4 Posts by recyan__");
        postNumPanel.add(postNumLabel);

        ScrollBackPane.add(postNumPanel);
        ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
        
        // �Խñ� post
        PostPanel postPanel = new PostPanel();
        ScrollBackPane.add(postPanel);
        ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
        //���ο����� �Խñ� ���� ������ �� ���� �־��ֱ�
        
        PostPanel postPanel2 = new PostPanel();
        ScrollBackPane.add(postPanel2);
        ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
       
        scrollPane.setViewportView(ScrollBackPane);

        add(scrollPane);
    }                      

    @Override
    public void actionPerformed(java.awt.event.ActionEvent arg0) {
            // TODO Auto-generated method stub
    	if(arg0.getSource() == imageBtn){	//��ư���� �̹��� �����ִ� �뵵
    		javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
            fileChooser.setDialogTitle("New profile photo");
            fileChooser.setMultiSelectionEnabled(false);	// ���� ���� �Ұ�
            int returnVal = fileChooser.showOpenDialog(this); // show openDialog 
            
            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) { // ������ �����Ͽ��� ��
            	// ���� ���� ���� �κ�
//                try{
//                	java.awt.image.BufferedImage img = ImageIO.read(fileChooser.getSelectedFile());
//                	java.awt.Image resizedImage = 
//                		    img.getScaledInstance(imageBtn.getWidth(), imageBtn.getHeight(), java.awt.Image.SCALE_SMOOTH);
//                    
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
            }
        }
    	
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

    // Variables declaration                 
    private javax.swing.JPanel MyDataPanel;
    private javax.swing.JButton imageBtn;
    private javax.swing.JPanel ScrollBackPane;
    private javax.swing.JButton followerBtn;
    private javax.swing.JLabel followerNumLabel;
    private javax.swing.JButton followingBtn;
    private javax.swing.JLabel followingNumLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel postNumLabel;
    private javax.swing.JPanel postNumPanel;
    private FollowWindow flwWindow;
    // End of variables declaration                   
}
