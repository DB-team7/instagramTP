package instagramTP;


public class PanelSearch extends javax.swing.JPanel {

    /**
     * Creates new form PanelHomeFeed
     */
    public PanelSearch() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setPreferredSize(new java.awt.Dimension(470, 610));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel2.setPreferredSize(new java.awt.Dimension(10, 90));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        jTextField1.setBackground(new java.awt.Color(229, 229, 229));
        jTextField1.setText("Search friends and tags...");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jTextField1.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel2.add(jTextField1);

        jButton1.setBackground(new java.awt.Color(229, 229, 229));
        jButton1.setText("!");
        jButton1.setBorder(null);
        jButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel2.add(jButton1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(470, 610));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jPanel3);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1);
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
