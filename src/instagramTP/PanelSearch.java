package instagramTP;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
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

		// load imageIcon
		search = new ImageIcon("images/search_hovered.png").getImage();
		searchI = new ImageIcon(search.getScaledInstance(30, 30, Image.SCALE_SMOOTH));

		setBackground(new java.awt.Color(245, 245, 245));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
		jPanel1.setLayout(new java.awt.BorderLayout());

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));
		jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
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
		jButton1.setIcon(searchI);
		jButton1.setBorder(null);
		jButton1.setPreferredSize(new java.awt.Dimension(30, 30));
		jPanel2.add(jButton1);

		jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

		scrollPane.setBackground(new java.awt.Color(255, 255, 255));
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 속도 증가
		scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0)); // 스크롤바 숨기기

		scrollBackPane.setBackground(new java.awt.Color(255, 255, 255));
		scrollBackPane.setLayout(new javax.swing.BoxLayout(scrollBackPane, javax.swing.BoxLayout.Y_AXIS));

		// TODO: 검색 결과 구현 (다른 사람 정보)
		PersonPanel personPanel = new PersonPanel(UID,UID);
		scrollBackPane.add(personPanel);
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(1000)); // default blank

		scrollPane.setViewportView(scrollBackPane);
		
		jPanel1.add(scrollPane, java.awt.BorderLayout.CENTER);

		// add jPanel1 in center
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jPanel1, 470, 470, 470)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGap(10)
				.addComponent(jPanel1)
				);
	}

	// Variables declaration
	private javax.swing.JButton jButton1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel scrollBackPane;
	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JTextField jTextField1;

	Image search; 
	ImageIcon searchI;
	// End of variables declaration
}
