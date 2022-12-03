package instagramTP;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

public class PanelSearch extends javax.swing.JPanel {


	private static final long serialVersionUID = 1L;

	public PanelSearch(String UID) throws SQLException {
		initComponents(UID);
	}

	private void initComponents(String UID) throws SQLException {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		scrollPane = new javax.swing.JScrollPane();
		scrollBackPane = new javax.swing.JPanel();

		setBackground(new java.awt.Color(245, 245, 245));
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
        jTextField1.setText("Search friends...");
        jTextField1.setForeground(Color.GRAY);
        jTextField1.addFocusListener(new FocusListener() {	// when start typing, guide disappear
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField1.getText().equals("")) {
					jTextField1.setText("Search friends...");
					jTextField1.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField1.getText().equals("Search friends...")) {
					jTextField1.setText("");
					jTextField1.setForeground(Color.BLACK);
				}
			}
		});
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jTextField1.setPreferredSize(new java.awt.Dimension(400, 30));
        jPanel2.add(jTextField1);

		jButton1.setBackground(new java.awt.Color(229, 229, 229));
		jButton1.setText("!");
		jButton1.setBorder(null);
		jButton1.setPreferredSize(new java.awt.Dimension(30, 30));
		jPanel2.add(jButton1);

		jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

		scrollPane.setBackground(new java.awt.Color(255, 255, 255));
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new java.awt.Dimension(470, 620));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 속도 증가
		scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0)); // 스크롤바 숨기기

		scrollBackPane.setBackground(new java.awt.Color(255, 255, 255));
		scrollBackPane.setLayout(new javax.swing.BoxLayout(scrollBackPane, javax.swing.BoxLayout.Y_AXIS));
		scrollPane.setViewportView(scrollBackPane);

		// TODO: 검색 결과 구현 (다른 사람 정보)
		PersonPanel personPanel = new PersonPanel(UID,UID);
		scrollBackPane.add(personPanel);

		// 추가 예시
//		PersonPanel personPanel2 = new PersonPanel();
//		scrollBackPane.add(personPanel2);
//		PersonPanel personPanel3 = new PersonPanel();
//		scrollBackPane.add(personPanel3);
//		PersonPanel personPanel4 = new PersonPanel();
//		scrollBackPane.add(personPanel4);
//		PersonPanel personPanel5 = new PersonPanel();
//		scrollBackPane.add(personPanel5);
//		PersonPanel personPanel6 = new PersonPanel();
//		scrollBackPane.add(personPanel6);
//		PersonPanel personPanel7 = new PersonPanel();
//		scrollBackPane.add(personPanel7);
//		PersonPanel personPanel8 = new PersonPanel();
//		scrollBackPane.add(personPanel8);
//		PersonPanel personPanel9 = new PersonPanel();
//		scrollBackPane.add(personPanel9);
//		PersonPanel personPanel10 = new PersonPanel();
//		scrollBackPane.add(personPanel10);
//		PersonPanel personPanel11 = new PersonPanel();
//		scrollBackPane.add(personPanel11);
//		PersonPanel personPanel12 = new PersonPanel();
//		scrollBackPane.add(personPanel12);

		jPanel1.add(scrollPane, java.awt.BorderLayout.CENTER);
		add(jPanel1);
	}

	// Variables declaration
	private javax.swing.JButton jButton1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel scrollBackPane;
	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration
}
