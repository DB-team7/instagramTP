package instagramTP;


public class PanelStarFeed extends javax.swing.JPanel {

    public PanelStarFeed() {
        initComponents();
    }
                       
    private void initComponents() {

    	scrollPane = new javax.swing.JScrollPane();
        ScrollBackPane = new javax.swing.JPanel();
        starPane = new javax.swing.JPanel();
        starLabel = new javax.swing.JLabel();
        
        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);    
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new java.awt.Dimension(470, 620));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);	//스크롤 속도 증가
        scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0,0));	//스크롤바 숨기기
        
        ScrollBackPane.setBackground(new java.awt.Color(245, 245, 245));
        ScrollBackPane.setLayout(new javax.swing.BoxLayout(ScrollBackPane, javax.swing.BoxLayout.Y_AXIS));

        // 여백으로 시작
        ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //패널사이세로여백
        
        // 인기글 피드임을 알려주는 패널
        starPane.setBackground(new java.awt.Color(245, 245, 245));
        starPane.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        starLabel.setText("Star feed");
        starPane.add(starLabel);

        ScrollBackPane.add(starPane);
        ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //패널사이세로여백
        
        // 게시글 post
        PostPanel postPanel = new PostPanel();
        ScrollBackPane.add(postPanel);
        ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //패널사이세로여백
        //세로여백은 게시글 끝날 때마다 꼭 같이 넣어주기
        
        PostPanel postPanel2 = new PostPanel();
        ScrollBackPane.add(postPanel2);
        ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //패널사이세로여백
       
        scrollPane.setViewportView(ScrollBackPane);

        add(scrollPane);
    }                        


    // Variables declaration   
    private javax.swing.JPanel ScrollBackPane;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel starPane;
    private javax.swing.JLabel starLabel;
    // End of variables declaration                   
}
