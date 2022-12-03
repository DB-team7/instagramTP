package instagramTP;

import java.awt.Color;
import java.awt.Insets;
import java.io.IOException;
import java.sql.SQLException;

import com.formdev.flatlaf.ui.FlatLineBorder;

public class PanelHomeFeed extends javax.swing.JPanel {

	
	private static final long serialVersionUID = 1L;

	public PanelHomeFeed(String UID) throws SQLException, IOException {
		initComponents(UID);
	}

	private void initComponents(String UID) throws SQLException, IOException {

		scrollPane = new javax.swing.JScrollPane();
		ScrollBackPane = new javax.swing.JPanel();

		setBackground(new java.awt.Color(245, 245, 245));
		setPreferredSize(new java.awt.Dimension(1000, 600));
		setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new java.awt.Dimension(470, 620));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // ��ũ�� �ӵ� ����
		scrollPane.getVerticalScrollBar().setAlignmentY(TOP_ALIGNMENT);
		scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0)); // ��ũ�ѹ� �����

		ScrollBackPane.setBackground(new java.awt.Color(245, 245, 245));
		ScrollBackPane.setLayout(new javax.swing.BoxLayout(ScrollBackPane, javax.swing.BoxLayout.Y_AXIS));

		// �������� ����
		ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // �гλ��̼��ο���

		PostPanel[] postPanel = new PostPanel[ZinCyan.getPostNum(UID)];
		Integer[] posts = new Integer[ZinCyan.getPostNum(UID)];
		posts = ZinCyan.getPIDsByUID(UID);
		for (Integer i = 0; i < ZinCyan.getPostNum(UID); i++) {
			// �Խñ� post
			postPanel[i] = new PostPanel(posts[i], UID);
			postPanel[i].setBorder(new FlatLineBorder(new Insets(0, 0, 0, 0), Color.LIGHT_GRAY, 1, 30));
			ScrollBackPane.add(postPanel[i]);
			ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // �гλ��̼��ο���
		}
//		// �Խñ� post
//		PostPanel postPanel1 = new PostPanel(0);
//		ScrollBackPane.add(postPanel1);
//		ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // �гλ��̼��ο���
//		// ���ο����� �Խñ� ���� ������ �� ���� �־��ֱ�
//
//		PostPanel postPanel2 = new PostPanel(1);
//		ScrollBackPane.add(postPanel2);
//		ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // �гλ��̼��ο���

		scrollPane.setViewportView(ScrollBackPane);

		add(scrollPane);
	}

	// Variables declaration
	private javax.swing.JPanel ScrollBackPane;
	private javax.swing.JScrollPane scrollPane;
	// End of variables declaration
}
