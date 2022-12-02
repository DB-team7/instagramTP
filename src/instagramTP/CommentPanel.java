package instagramTP;

public class CommentPanel extends javax.swing.JPanel implements java.awt.event.ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CommentPanel() {
        initComponents();
    }
	
	private void initComponents() {
		
		setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(200, 200, 200)));
        
        profileImgLabel = new javax.swing.JLabel();
        IDBtn = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        likeBtn = new javax.swing.JButton();
		profileImg = new javax.swing.ImageIcon("images/basicProfilePhoto.png").getImage();
        
        profileImgLabel.setIcon(new javax.swing.ImageIcon(profileImg));
        profileImgLabel.setPreferredSize(new java.awt.Dimension(32, 32));
        
        IDBtn.setText("recyan__");	
        IDBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12));
        IDBtn.setForeground(new java.awt.Color(100, 100, 100));
        IDBtn.setBorder(null);
        IDBtn.setBackground(null);
        IDBtn.addActionListener(this);	// ID 클릭하면 그 사람 페이지로 (OtherPageWindow.java)
        
        nameLabel.setText("댓글내용댓글댓글멋지당~");
        nameLabel.setForeground(new java.awt.Color(30, 30, 30));
        
        likeBtn.setText("하트");
        likeBtn.setPreferredSize(new java.awt.Dimension(32, 32));
        
        // add components
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            	.addGap(15, 15, 15)
                .addComponent(profileImgLabel)
                .addGap(10, 10, 10)
                .addComponent(IDBtn)
                .addGap(10, 10, 10)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            	.addComponent(likeBtn)
            	.addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(profileImgLabel)
                    .addComponent(IDBtn)
                    .addComponent(nameLabel)
                    .addComponent(likeBtn))
                .addGap(10, 10, 10))
        );
        
	}
	
	@Override
    public void actionPerformed(java.awt.event.ActionEvent arg0) {
            // TODO Auto-generated method stub
            if(arg0.getSource() == IDBtn){
            	otherWindow = new OtherPageWindow();
            	otherWindow.setVisible(true);
            	java.awt.EventQueue.invokeLater(new Runnable() {
        	        public void run() {
        	        	otherWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0,0));	//스크롤 원점으로
        	        	otherWindow.setModal(true);
        	        }
        	    });
            }
    }
	
	private javax.swing.JLabel profileImgLabel;
	private java.awt.Image profileImg;
	private javax.swing.JButton IDBtn;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JButton likeBtn;
	private OtherPageWindow otherWindow;
	
}
