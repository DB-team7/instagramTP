package instagramTP;

public class FollowWindow extends javax.swing.JDialog{

	public FollowWindow() {
        initComponents();
    }

	public void initComponents() {
		 
		scrollPane = new javax.swing.JScrollPane();
		scrollBackPane = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        
        java.awt.Image nullImg = new javax.swing.ImageIcon("images/nullImage.png").getImage();
        setIconImage(nullImg);	// �����ӹ� ������ �켱 ��������
	    setSize(600, 600);
	    setLocationRelativeTo(null);
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
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(10));  //�гλ��̼��ο���
        
        // � ��ư�� ������ �� â������ ���� �ȷο�/�ȷ��� ǥ�ð� �޶�� ��
        infoPanel.setBackground(new java.awt.Color(245, 245, 245));
        infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        infoLabel.setText("116 people are following recyan__");	//�ȷο�
        //infoLabel.setText("recyan__ is following 143 people");	//�ȷ���
        infoPanel.add(infoLabel);

        scrollBackPane.add(infoPanel);
        scrollBackPane.add(javax.swing.Box.createVerticalStrut(10));  //�гλ��̼��ο���
        
        // �ȷο�/�ȷ��� ����
        PersonPanel personPanel = new PersonPanel();
        scrollBackPane.add(personPanel);
        
        // �߰� ����
        PersonPanel personPanel2 = new PersonPanel();
        scrollBackPane.add(personPanel2);
        PersonPanel personPanel3 = new PersonPanel();
        scrollBackPane.add(personPanel3);
        PersonPanel personPanel4 = new PersonPanel();
        scrollBackPane.add(personPanel4);
        PersonPanel personPanel5 = new PersonPanel();
        scrollBackPane.add(personPanel5);
        PersonPanel personPanel6 = new PersonPanel();
        scrollBackPane.add(personPanel6);
        PersonPanel personPanel7 = new PersonPanel();
        scrollBackPane.add(personPanel7);
        PersonPanel personPanel8 = new PersonPanel();
        scrollBackPane.add(personPanel8);
        PersonPanel personPanel9 = new PersonPanel();
        scrollBackPane.add(personPanel9);
        PersonPanel personPanel10 = new PersonPanel();
        scrollBackPane.add(personPanel10);
        PersonPanel personPanel11 = new PersonPanel();
        scrollBackPane.add(personPanel11);
        PersonPanel personPanel12 = new PersonPanel();
        scrollBackPane.add(personPanel12);

       
        scrollPane.setViewportView(scrollBackPane);
	    getContentPane().add(scrollPane);
	    
	}
	 
	private javax.swing.JLabel infoLabel;
	private javax.swing.JPanel infoPanel;
	private javax.swing.JPanel scrollBackPane;
	public javax.swing.JScrollPane scrollPane;
	
}
