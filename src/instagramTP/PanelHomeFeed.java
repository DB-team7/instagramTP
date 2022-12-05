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

		setBackground(new Color(245, 245, 245));

		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 속도 증가
		scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0)); // 스크롤바 숨기기

		ScrollBackPane.setBackground(new Color(245, 245, 245));
		ScrollBackPane.setLayout(new javax.swing.BoxLayout(ScrollBackPane, javax.swing.BoxLayout.Y_AXIS));

		// 여백으로 시작
		ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백

		PostPanel[] postPanel = new PostPanel[ZinCyan.getFolloweePostNum(UID)];
		Integer[] posts = new Integer[ZinCyan.getFolloweePostNum(UID)];
		posts = ZinCyan.getFolloweePID(UID);
		for (Integer i = 0; i < ZinCyan.getFolloweePostNum(UID); i++) {
			// 게시글 post
			postPanel[i] = new PostPanel(posts[i], UID);
			postPanel[i].setBorder(new FlatLineBorder(new Insets(0, 0, 0, 0), Color.LIGHT_GRAY, 1, 30));
			ScrollBackPane.add(postPanel[i]);
			ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백
		}
		ScrollBackPane.add(javax.swing.Box.createVerticalStrut(1000)); // default blank

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
