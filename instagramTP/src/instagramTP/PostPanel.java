package instagramTP;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatLineBorder;

public class PostPanel extends javax.swing.JPanel implements java.awt.event.ActionListener{

    public PostPanel() {
        initComponents();
    }
                        
    private void initComponents() {

    	IDBtn = new javax.swing.JButton();
        moreBtn = new javax.swing.JButton();
        imagePane = new javax.swing.JPanel();
        likePane = new javax.swing.JPanel();
        likeBtn = new javax.swing.JToggleButton();
        likeNumLabel = new javax.swing.JLabel();
        createdAtLabel = new javax.swing.JLabel();
        postTextArea = new javax.swing.JTextArea();
        commentPane = new javax.swing.JPanel();
        commentWindowBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        postCommentBtn = new javax.swing.JButton();
        
        // load images
        heart = new ImageIcon("images/heart.png").getImage();
        heart_f = new ImageIcon("images/heart_filled.png").getImage();
        heart_p = new ImageIcon("images/heart_pressed1.png").getImage();
        heart_fp = new ImageIcon("images/heart_pressed2.png").getImage();
        
        // image to imageIcon
        heartI = new ImageIcon(heart.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        heartI_f = new ImageIcon(heart_f.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        heartI_p = new ImageIcon(heart_p.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        heartI_fp = new ImageIcon(heart_fp.getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        setBackground(new java.awt.Color(255, 255, 255));
        putClientProperty( FlatClientProperties.STYLE, "arc: 30" );

        IDBtn.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        IDBtn.setText("recyan__");
        IDBtn.setBorder(null);
        IDBtn.setBackground(null);
        IDBtn.addActionListener(this);	// ID 클릭하면 그 사람 페이지로 (OtherPageWindow.java)

        moreBtn.setBackground(null);
        moreBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); 
        moreBtn.setText("...");
        moreBtn.setBorder(null);
        moreBtn.addActionListener(this);	// 게시글 수정, 삭제 창. 애초에 본인 게시글에만 이 버튼이 떠야 함

        imagePane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout imagePaneLayout = new javax.swing.GroupLayout(imagePane);
        imagePane.setLayout(imagePaneLayout);
        imagePaneLayout.setHorizontalGroup(
            imagePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagePaneLayout.setVerticalGroup(
            imagePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );

        likePane.setBackground(null);
        likePane.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
        likePane.setLayout(new java.awt.BorderLayout());

        likeBtn.setBackground(null);
        likeBtn.setBorder(null);
        likeBtn.setPressedIcon(heartI_fp);
        likeBtn.setIcon(heartI);	// 기본 설정: 이 글을 좋아요했으면 heartI_f(꽉찬하트), 아니면 heartI(빈하트)로 setIcon
        likeBtn.setSelected(false);	// 기본 설정: 이 글을 좋아요했으면 true, 아니면 false
        likeBtn.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
              if(likeBtn.isSelected())
              {
            	  likeBtn.setIcon(heartI_f);	// 좋아요 누른 상태
            	  likeBtn.setPressedIcon(heartI_p);
              }
              else
              {
            	  likeBtn.setIcon(heartI);	// 좋아요 안한 상태
            	  likeBtn.setPressedIcon(heartI_fp);
              }
            }
          });
        likePane.add(likeBtn, java.awt.BorderLayout.CENTER);

        likeNumLabel.setText("nnn people liked");
        likePane.add(likeNumLabel, java.awt.BorderLayout.EAST);

        createdAtLabel.setText("21시간 전");
        likePane.add(createdAtLabel, java.awt.BorderLayout.WEST);

        postTextArea.setEditable(false);
        postTextArea.setBackground(null);
        postTextArea.setColumns(20);
        postTextArea.setRows(5);
        postTextArea.setText("글내용 글내용 글내용 ~ \n글내용!\n");
        postTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));

        commentPane.setBackground(null);

        commentWindowBtn.setBackground(null);
        commentWindowBtn.setText("댓");
        commentWindowBtn.addActionListener(this);

        jTextField1.setText("leave a comment...");
        jTextField1.setForeground(Color.GRAY);
        jTextField1.addFocusListener(new FocusListener() {	// when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField1.getText().equals("")) {
					jTextField1.setText("leave a comment...");
					jTextField1.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField1.getText().equals("leave a comment...")) {
					jTextField1.setText("");
					jTextField1.setForeground(Color.BLACK);
				}
			}
		});

        postCommentBtn.setBackground(null);
        postCommentBtn.setText("comment");

        javax.swing.GroupLayout commentPaneLayout = new javax.swing.GroupLayout(commentPane);
        commentPane.setLayout(commentPaneLayout);
        commentPaneLayout.setHorizontalGroup(
            commentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commentWindowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(postCommentBtn)
                .addContainerGap())
        );
        commentPaneLayout.setVerticalGroup(
            commentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commentPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(commentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commentWindowBtn)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postCommentBtn))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(IDBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(moreBtn)
                .addGap(12, 12, 12))
            .addComponent(imagePane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(likePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(postTextArea)
            .addComponent(commentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDBtn)
                    .addComponent(moreBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(likePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(commentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        	        	otherWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0,0));
        	        	otherWindow.setModal(true);
        	        }
        	    });
            }
            
            if(arg0.getSource() == commentWindowBtn){
            	cmtWindow = new CommentWindow();
            	cmtWindow.setVisible(true);
            	java.awt.EventQueue.invokeLater(new Runnable() {
        	        public void run() {
        	        	cmtWindow.scrollPane.getViewport().setViewPosition(new java.awt.Point(0,0));
        	        	cmtWindow.setModal(true);
        	        }
        	    });
            }
            
            if(arg0.getSource() == moreBtn){
            	java.awt.EventQueue.invokeLater(new Runnable() {
        	        public void run() {
        	        	mdfyWindow = new ModifyWindow();
                    	mdfyWindow.setVisible(true);
        	        	mdfyWindow.setModal(true);
        	        }
        	    });
            }
    }

    // Variables declaration                    
    private javax.swing.JPanel commentPane;
    private javax.swing.JButton commentWindowBtn;
    private javax.swing.JLabel createdAtLabel;
	private javax.swing.JButton IDBtn;
    private javax.swing.JPanel imagePane;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton likeBtn;
    private javax.swing.JLabel likeNumLabel;
    private javax.swing.JPanel likePane;
    private javax.swing.JButton moreBtn;
    private javax.swing.JButton postCommentBtn;
    private javax.swing.JTextArea postTextArea;
    private OtherPageWindow otherWindow;
    private CommentWindow cmtWindow;
    private ModifyWindow mdfyWindow;
    
    Image heart; Image heart_f; Image heart_p; Image heart_fp;
    ImageIcon heartI; ImageIcon heartI_f; ImageIcon heartI_p; ImageIcon heartI_fp;
    // End of variables declaration                   
}
