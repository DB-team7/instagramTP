package instagramTP;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;

public class JoinFrame extends JFrame {

    public JoinFrame() {
        initComponents();
    }
  
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setExtendedState(JFrame.MAXIMIZED_BOTH);	// full screen
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(245, 245, 245));
        
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 80));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(470, 500));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("join in*gram");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        // NAME field
        jTextField1.setFont(new java.awt.Font("���� ���", 0, 14)); // NOI18N
        jTextField1.setText("NAME");
        jTextField1.setForeground(Color.GRAY);	
        jTextField1.addFocusListener(new FocusListener() {	// when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField1.getText().equals("")) {
					jTextField1.setText("NAME");
					jTextField1.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField1.getText().equals("NAME")) {
					jTextField1.setText("");
					jTextField1.setForeground(Color.BLACK);
				}
			}
		});
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(jTextField1, gridBagConstraints);

        // PHONE NUMBER field
        jTextField2.setFont(new java.awt.Font("���� ���", 0, 14)); // NOI18N
        jTextField2.setText("PHONE NUMBER");
        jTextField2.setForeground(Color.GRAY);
        jTextField2.addFocusListener(new FocusListener() {	// when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField2.getText().equals("")) {
					jTextField2.setText("PHONE NUMBER");
					jTextField2.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField2.getText().equals("PHONE NUMBER")) {
					jTextField2.setText("");
					jTextField2.setForeground(Color.BLACK);
				}
			}
		});
        jTextField2.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(jTextField2, gridBagConstraints);

        // EMAIL field
        jTextField3.setFont(new java.awt.Font("���� ���", 0, 14)); // NOI18N
        jTextField3.setText("EMAIL");
        jTextField3.setForeground(Color.GRAY);
        jTextField3.addFocusListener(new FocusListener() {	// when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField3.getText().equals("")) {
					jTextField3.setText("EMAIL");
					jTextField3.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField3.getText().equals("EMAIL")) {
					jTextField3.setText("");
					jTextField3.setForeground(Color.BLACK);
				}
			}
		});
        jTextField3.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(jTextField3, gridBagConstraints);

        // ID field
        jTextField4.setFont(new java.awt.Font("���� ���", 0, 14)); // NOI18N
        jTextField4.setText("ID");
        jTextField4.setForeground(Color.GRAY);
        jTextField4.addFocusListener(new FocusListener() {	// when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField4.getText().equals("")) {
					jTextField4.setText("ID");
					jTextField4.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField4.getText().equals("ID")) {
					jTextField4.setText("");
					jTextField4.setForeground(Color.BLACK);
				}
			}
		});
        jTextField4.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(jTextField4, gridBagConstraints);

        // PASSWORD field
        jTextField5.setFont(new java.awt.Font("���� ���", 0, 14)); // NOI18N
        jTextField5.setText("PASSWORD");
        jTextField5.setForeground(Color.GRAY);
        jTextField5.addFocusListener(new FocusListener() {	// when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField5.getText().equals("")) {
					jTextField5.setText("PASSWORD");
					jTextField5.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField5.getText().equals("PASSWORD")) {
					jTextField5.setText("");
					jTextField5.setForeground(Color.BLACK);
				}
			}
		});
        jTextField5.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(jTextField5, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("���� ���", 0, 14)); // NOI18N
        jButton1.setText("Join");
        jButton1.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }                

    // Variables declaration                    
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration                   
}