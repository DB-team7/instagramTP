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
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);	//��ũ�� �ӵ� ����
        scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0,0));	//��ũ�ѹ� �����
        
        ScrollBackPane.setBackground(new java.awt.Color(245, 245, 245));
        ScrollBackPane.setLayout(new javax.swing.BoxLayout(ScrollBackPane, javax.swing.BoxLayout.Y_AXIS));

        // �������� ����
        ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30));  //�гλ��̼��ο���
        
        // �α�� �ǵ����� �˷��ִ� �г�
        starPane.setBackground(new java.awt.Color(245, 245, 245));
        starPane.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        starLabel.setText("Star feed");
        starPane.add(starLabel);

        ScrollBackPane.add(starPane);
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


    // Variables declaration   
    private javax.swing.JPanel ScrollBackPane;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel starPane;
    private javax.swing.JLabel starLabel;
    // End of variables declaration                   
}
