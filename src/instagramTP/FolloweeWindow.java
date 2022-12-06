package instagramTP;

import java.io.IOException;
import java.sql.SQLException;

public class FolloweeWindow extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FolloweeWindow(String UID) throws SQLException, IOException {
		initComponents(UID);
	}

	public void initComponents(String UID) throws SQLException, IOException {

		scrollPane = new javax.swing.JScrollPane();
		scrollBackPane = new javax.swing.JPanel();
		infoPanel = new javax.swing.JPanel();
		infoLabel = new javax.swing.JLabel();

		java.awt.Image nullImg = new javax.swing.ImageIcon("images/nullImage.png").getImage();
		setIconImage(nullImg); // �����ӹ� ������ �켱 ��������
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().setBackground(new java.awt.Color(245, 245, 245));
		getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new java.awt.Dimension(470, 560));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // ��ũ�� �ӵ� ����
		scrollPane.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0)); // ��ũ�ѹ� �����

		scrollBackPane.setBackground(new java.awt.Color(245, 245, 245));
		scrollBackPane.setLayout(new javax.swing.BoxLayout(scrollBackPane, javax.swing.BoxLayout.Y_AXIS));

		// �������� ����
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(10)); // �гλ��̼��ο���

		// � ��ư�� ������ �� â������ ���� �ȷο�/�ȷ��� ǥ�ð� �޶�� ��
		infoPanel.setBackground(new java.awt.Color(245, 245, 245));
		infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

		//		infoLabel.setText("116 people are following recyan__"); // �ȷο�
		infoLabel.setText(UID + " is following " + Integer.toString(ZinCyan.getFolloweeNum(UID)) + " people(s)"); // �ȷ���
		infoPanel.add(infoLabel);

		scrollBackPane.add(infoPanel);
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(10)); // �гλ��̼��ο���

		Integer followeeNum = ZinCyan.getFolloweeNum(UID);
		String[] followees = new String[followeeNum];
		followees = ZinCyan.getFollowees(UID);
		PersonPanel[] personPanel = new PersonPanel[followeeNum];
		for (int i = 0; i < followeeNum; i++) {
			// �ȷο�/�ȷ��� ����
			personPanel[i] = new PersonPanel(followees[i], UID);
			scrollBackPane.add(personPanel[i]);
		}
		scrollBackPane.add(javax.swing.Box.createVerticalStrut(1000)); // default blank

		scrollPane.setViewportView(scrollBackPane);

		// add scrollPane in center
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
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

	private javax.swing.JLabel infoLabel;
	private javax.swing.JPanel infoPanel;
	private javax.swing.JPanel scrollBackPane;
	public javax.swing.JScrollPane scrollPane;

}
