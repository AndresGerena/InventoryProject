package Images;

import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Escala {
    public void escalarLabel(JLabel label, String rutaImagen){
        label.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(rutaImagen)).getImage()
                .getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
             
    }

    public void escalarLabel(JButton butlogout, String imagescerrarsesionpng) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}