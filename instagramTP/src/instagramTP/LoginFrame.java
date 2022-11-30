package instagramTP;


import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class LoginFrame extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
        // 전체 화면
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(this);
        //아래 넷빈즈에서 수정못하는 setSize 지우기
        getContentPane().setBackground(new java.awt.Color(245, 245, 245));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        pw = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        pwTextField = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        joinBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 245, 245));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 80));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(470, 500));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("in*gram");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 40, 0);
        jPanel1.add(jLabel1, gridBagConstraints);
        
        id.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 40, 0);
        jPanel1.add(id, gridBagConstraints);
        
        pw.setText("PW");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 40, 0);
        jPanel1.add(pw, gridBagConstraints);

        idTextField.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        idTextField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(idTextField, gridBagConstraints);

        pwTextField.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        pwTextField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(pwTextField, gridBagConstraints);

        loginBtn.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        loginBtn.addActionListener(this);
        jPanel1.add(loginBtn, gridBagConstraints);

        joinBtn.setText("join");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        joinBtn.addActionListener(this);
        jPanel1.add(joinBtn, gridBagConstraints);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent arg0) {
    	
    	if(arg0.getSource() == joinBtn){	// join button action
    		JoinFrame join = new JoinFrame();
    		join.setVisible(true);	 	
    	}
    	
    	if(arg0.getSource() == loginBtn){	// login button action
    		
    		String id = idTextField.getText();
    		String pw = new String(pwTextField.getPassword());

			if(check(id, pw)) // Login successful if ID and password match
			{
				JOptionPane.showMessageDialog(null, "welcome!");
				dispose();	// Login screen off
				
				// MainFrame으로 넘어가기 전에, id 정보는 저장하거나 혹은 MainFrame으로 넘겨줘야함.
				MainFrame main = new MainFrame();
	    		main.setVisible(true);	// go to MainFrame
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ID or passward is wrong...");	// if ID and password not match
			}
    	}	
    }
    
    public boolean check(String id, String pw)
	{
		
		// login check
//		try{
//			String s;
//			String[] array;
//			BufferedReader bos = new BufferedReader(new FileReader("admin_list.txt"));
//			while((s=bos.readLine())!=null){
//				array=s.split("/");
//				if(id.equals(array[0]) && pw.equals(array[1]))
//				{
					return true;
//				}
//			}
//			bos.close();
//			
//		}catch (IOException E10){
//			E10.printStackTrace();
//		}
//		return false;
	}

    // Variables declaration - do not modify                     
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton joinBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel id;
    private javax.swing.JLabel pw;
    private javax.swing.JTextField idTextField;
    private javax.swing.JPasswordField pwTextField;
    // End of variables declaration                   
}
