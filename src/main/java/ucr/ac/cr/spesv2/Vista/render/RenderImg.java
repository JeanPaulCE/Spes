/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.render;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jpcdl
 */
public class RenderImg {
    public final int anchoOriginal;
    private int altoOriginal;
    private Image lineaimg;
    
    public RenderImg(ImageIcon img) {
       lineaimg = img.getImage();
       anchoOriginal = img.getIconWidth();
       altoOriginal = img.getIconHeight();
    }

    public ImageIcon escalar(ImageIcon imagen, double porcentajeX) {//relacion es un porsentaje sobre la imagen original
        Image texturaOriginal = imagen.getImage();
        
        System.out.println(anchoOriginal+" "+porcentajeX);
        System.out.println("ucr.ac.cr.spesv2.Vista.render.RenderImg.escalar()");
        System.out.println(anchoOriginal+" * "+porcentajeX+" = "+(int) ((double)anchoOriginal * (double)porcentajeX));
        
        Image texturaMostrada = texturaOriginal.getScaledInstance((int) ((double)anchoOriginal * (double)porcentajeX), (int) altoOriginal, Image.SCALE_DEFAULT);
        ImageIcon resultado;
        resultado = new ImageIcon(texturaMostrada);
        return resultado;
    }
    
     public ImageIcon escalar(double porcentajeX) {//relacion es un porsentaje sobre la imagen original
         //System.out.println((int)(anchoOriginal * (double)porcentajeX));
         //System.out.println(anchoOriginal);
        Image texturaOriginal = lineaimg;
        
//        System.out.println(anchoOriginal+" "+porcentajeX);
//        System.out.println("ucr.ac.cr.spesv2.Vista.render.RenderImg.escalar()");
//        System.out.println(anchoOriginal+" * "+porcentajeX+" = "+(int) ((double)anchoOriginal * (double)porcentajeX));
        
        Image texturaMostrada = texturaOriginal.getScaledInstance((int) (anchoOriginal * (double)porcentajeX), (int) altoOriginal, Image.SCALE_AREA_AVERAGING);
        
        ImageIcon resultado = new ImageIcon(texturaMostrada);
        
         System.out.println(resultado.getIconWidth()+"---"+texturaOriginal.getWidth(null));
        return resultado;
    }

}
