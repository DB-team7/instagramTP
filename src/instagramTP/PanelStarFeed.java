package instagramTP;

import java.awt.Color;
import java.awt.Insets;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import com.formdev.flatlaf.ui.FlatLineBorder;

public class PanelStarFeed extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

	public PanelStarFeed(String UID) throws SQLException {
		initComponents(UID);
	}

	private void initComponents(String UID) throws SQLException {

		scrollPane = new javax.swing.JScrollPane();
		ScrollBackPane = new javax.swing.JPanel();
		starPane = new javax.swing.JPanel();
		starLabel = new javax.swing.JLabel();

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

		// 인기글 피드임을 알려주는 패널
		starPane.setBackground(new Color(245, 245, 245));
		starPane.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(141, 196, 177)));
		starPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		starLabel.setText("Star feed");
		starLabel.setForeground(new Color(120, 170, 150));
		starLabel.setPreferredSize(new java.awt.Dimension(70, 30));
		starPane.add(starLabel);

		ScrollBackPane.add(starPane);
		ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백

		PostPanel[] postPanel = new PostPanel[ZinCyan.getStarPostNum()];
		Integer[] posts =  ZinCyan.getStarPost().clone();
		System.out.println(Arrays.toString(posts));
		for (Integer i = 0; i < ZinCyan.getStarPostNum(); i++) {
			// 게시글 post
			try {
				postPanel[i] = new PostPanel(posts[i], UID);
				postPanel[i].setBorder(new FlatLineBorder(new Insets(0, 0, 0, 0), new Color(141, 196, 177), 1, 30));
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ScrollBackPane.add(postPanel[i]);
			ScrollBackPane.add(javax.swing.Box.createVerticalStrut(30)); // 패널사이세로여백
		}
		ScrollBackPane.add(javax.swing.Box.createVerticalStrut(1000)); // default blank

		scrollPane.setViewportView(ScrollBackPane);

		// add scrollPane in center
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(scrollPane, 470, 470, 470)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(scrollPane)
				);
	}

	// Variables declaration
	private javax.swing.JPanel ScrollBackPane;
	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JPanel starPane;
	private javax.swing.JLabel starLabel;
	// End of variables declaration
}
