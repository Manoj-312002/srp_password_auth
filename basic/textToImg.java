package basic;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class textToImg {

    public static void main(String[] args) throws Exception {
        // byte[] txt =
        // Base64.getDecoder().decode("oeeXRH1b6Y0q7UJAvOX/GRoY8m90bpD+1diJEhuEPZ8=");
        // String text = new String( txt , "ascii" );
        String text = "1fe355795ce746ec89e07e723670049\u6366";
        System.out.println(text);

        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 1);

        FontMetrics fm = g2d.getFontMetrics();
        g2d.setFont(font);

        int width = fm.stringWidth(text);
        int height = fm.getHeight();

        System.out.println(width + " " + height);

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2d.setColor(Color.BLACK);

        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();

        ImageIO.write(img, "jpg", new File("Text.jpg"));

    }
}