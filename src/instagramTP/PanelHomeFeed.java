package instagramTP;

import java.io.IOException;
import java.sql.SQLException;

public class PanelHomeFeed extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

	public PanelHomeFeed(String UID) throws SQLException, IOException {
		initComponents(UID);
	}

	private void initComponents(String UID) throws SQLException, IOException {

		scrollPane = new javax.swing.JScrollPane();
		ScrollBackPane = new javax.swing.JPanel();

		setBackground(new java.awt.Color(245, 245, 245));

		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // ��ũ�� �ӵ� ����
		scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0)); // ��ũ�ѹ� �����

		ScrollBackPane.setBackground(new java.awt.Color(245, 245, 245));
		ScrollBackPane.setLayout(new javax.swing.BoxLayout(ScrollBackPane, javax.swing.BoxLayout.Y_AXIS));

		// �������� ����
		ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // �гλ��̼��ο���

		PostPanel[] postPanel = new PostPanel[ZinCyan.getFolloweePostNum(UID)];
		Integer[] posts = new Integer[ZinCyan.getFolloweePostNum(UID)];
		posts = ZinCyan.getFolloweePID(UID);
		for (Integer i = 0; i < ZinCyan.getPostNum(UID); i++) {
			// �Խñ� post
			postPanel[i] = new PostPanel(posts[i], UID);
			ScrollBackPane.add(postPanel[i]);
			ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // �гλ��̼��ο���
		}

		scrollPane.setViewportView(ScrollBackPane);

		// add scrollPane in center
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(scrollPane, 470, 470, 470)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(scrollPane)
				);
	}                

	// Variables declaration
	private javax.swing.JPanel ScrollBackPane;
	private javax.swing.JScrollPane scrollPane;
	// End of variables declaration

}
