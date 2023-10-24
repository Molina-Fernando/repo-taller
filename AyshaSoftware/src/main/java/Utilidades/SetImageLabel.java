package Utilidades;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase de utilidad para establecer una imagen en un componente JLabel.
 * 
 * Esta clase proporciona un método estático para asignar una imagen a un JLabel
 * y ajustar automáticamente su tamaño para que encaje en el componente.
 */

public class SetImageLabel {
    
    /**
     * Establece una imagen en un JLabel y ajusta su tamaño para que encaje en el componente.
     *
     * @param jLabel1 El JLabel en el que se mostrará la imagen.
     * @param root    La ruta de la imagen en el sistema de archivos.
     */

    public static void setImageLabel(JLabel jLabel1, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(icon);
    }
}
