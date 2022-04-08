import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;
import java.awt.image.*;

import javax.imageio.ImageIO;

public class byteRpr {
    public static void main(String[] args) throws Exception {
        BufferedImage bImage = ImageIO.read(new File("Text.png"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "png", bos );
        byte [] data = bos.toByteArray();
        byte[] txt = Base64.getDecoder().decode("oeeXRH1b6Y0q7UJAvOX/GRoY8m90bpD+1diJEhuEPZ8=");
        
        for( int i = 0 , j = 0; i < data.length; i++ , j++ ){
            j %= 32;
            data[i] ^= txt[j];
        }
      
        ByteArrayInputStream input_stream= new ByteArrayInputStream(data);
        BufferedImage final_buffered_image = ImageIO.read(input_stream);
        ImageIO.write(final_buffered_image , "jpg", new File("final_file.jpg") );

        // ImageIO.write( optI , "png", new File("outputImage.png"));

    }
}
