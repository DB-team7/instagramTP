package instagramTP;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.imageio.ImageIO;

public class UploadWindow extends javax.swing.JDialog implements java.awt.event.ActionListener {

    public UploadWindow() {
        initComponents();
    }
                      
    private void initComponents() {
    	
    	//jFileChooser1 = new javax.swing.JFileChooser();
        jTextField1 = new javax.swing.JTextField();
        imageBtn = new javax.swing.JButton();
        uploadBtn = new javax.swing.JButton();
    	
    	java.awt.Image nullImg = new javax.swing.ImageIcon("images/nullImage.png").getImage();
        setIconImage(nullImg);	// �����ӹ� ������ �켱 ��������
	    setSize(1000, 600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    
	    getContentPane().setBackground(new java.awt.Color(245, 245, 245));
        getContentPane().setLayout(new java.awt.FlowLayout());
        
       
//        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users"));
//        jFileChooser1.setPreferredSize(new java.awt.Dimension(400, 400));
//        getContentPane().add(jFileChooser1);
        
        imageBtn.setText("upload image");
        imageBtn.setPreferredSize(new java.awt.Dimension(400, 400));
        imageBtn.setBackground(new java.awt.Color(255, 255, 255));
        imageBtn.setBorder(null);
        imageBtn.addActionListener(this);	

        jTextField1.setText("Write anything to post...");
        jTextField1.setToolTipText("");
        jTextField1.setForeground(Color.GRAY);
        jTextField1.addFocusListener(new FocusListener() {	// when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField1.getText().equals("")) {
					jTextField1.setText("Write anything to post...");
					jTextField1.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField1.getText().equals("Write anything to post...")) {
					jTextField1.setText("");
					jTextField1.setForeground(Color.BLACK);
				}
			}
		});
        jTextField1.setBorder(null);
        jTextField1.setPreferredSize(new java.awt.Dimension(400, 400));
        
        uploadBtn.setText("Upload post");
        uploadBtn.addActionListener(this);
        
        getContentPane().add(imageBtn);
        getContentPane().add(jTextField1);
        getContentPane().add(uploadBtn);

        pack();
    }                       
    
    void load(){
    	javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("���� �ҷ�����");
        //fileChooser.getsetDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//�ȵ�
        //fileChooser.setFileFilter(new FileNameExtensionFilter("RAW File", "raw")); // ��������
        fileChooser.setMultiSelectionEnabled(false);	// ���� ���� �Ұ�
        int returnVal = fileChooser.showOpenDialog(this); // show openDialog 
        
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) { // ������ �����Ͽ��� ��
            try{
            	java.awt.image.BufferedImage img = ImageIO.read(fileChooser.getSelectedFile());
            	java.awt.Image resizedImage = 
            		    img.getScaledInstance(imageBtn.getWidth(), imageBtn.getHeight(), java.awt.Image.SCALE_SMOOTH);
                imageBtn.setIcon(new javax.swing.ImageIcon(resizedImage));
                imageBtn.setText(null);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
 
    @Override
    public void actionPerformed(java.awt.event.ActionEvent arg0) {
            // TODO Auto-generated method stub
    	if(arg0.getSource() == imageBtn){	//��ư���� �̹��� �����ִ� �뵵
        	load();
        }
    	
    	if(arg0.getSource() == uploadBtn){	//���ε�
        	dispose();	//â�ݱ�
        }
    }

    // Variables declaration                   
    //private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JButton imageBtn;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton uploadBtn;
    // End of variables declaration                   
}