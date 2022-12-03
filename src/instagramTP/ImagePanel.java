package instagramTP;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	Image img;

	public ImagePanel(Image postImage) {
		this.img = postImage;
	}

	public void paint(Graphics g) {

		g.drawImage(img, 0, 0, null);
	}

}