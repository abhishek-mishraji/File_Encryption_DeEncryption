import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class back_image extends JFrame {
    private JPanel backgroundPanel;

    public back_image() {
        setTitle("Background Image Example");
        setSize(1920, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // create a panel with BorderLayout
        backgroundPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage image = ImageIO.read(new File("image.jpg"));
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        // add the panel to the frame
        add(backgroundPanel);

        setVisible(true);
    }

}
