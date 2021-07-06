/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.render;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author jpcdl
 */
public class RenderEscala {

    private float escala;
    public int ancho;
    public int alto;

    public RenderEscala(int escalaOriginal) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        ancho = (int) ((size.getWidth() * 90) / 100);
        alto = (int) ((size.getHeight() * 90) / 100);
        escala = ((100 * ancho) / escalaOriginal);
//        System.out.println(alto+" "+ancho);
//        System.out.println(escala);

    }

    public ImageIcon escalarImageIcon(ImageIcon input) {
        Image image = input.getImage();
        int altoImg = (int) ((image.getHeight(null) * escala) / 100);
        int anchoImg = (int) ((image.getWidth(null) * escala) / 100);

        ImageIcon img = new ImageIcon(image.getScaledInstance(anchoImg, altoImg, Image.SCALE_AREA_AVERAGING));
//        System.out.println(image.getHeight(null) +""+image.getWidth(null));
//        System.out.println(altoImg+" "+anchoImg);
//        System.out.println("ucr.ac.cr.spes.vista.render.RenderEscala.escalarImageIcon()");
        return img;
    }

    public ImageIcon escalarImageIcon(ImageIcon input, int _escala) {
        Image image = input.getImage();
        int altoImg = (int) ((image.getHeight(null) * _escala) / 100);
        int anchoImg = (int) ((image.getWidth(null) * _escala) / 100);

        ImageIcon img = new ImageIcon(image.getScaledInstance(anchoImg, altoImg, Image.SCALE_AREA_AVERAGING));
//        System.out.println(image.getHeight(null) +""+image.getWidth(null));
//        System.out.println(altoImg+" "+anchoImg);
//        System.out.println("ucr.ac.cr.spes.vista.render.RenderEscala.escalarImageIcon()");
        return img;
    }

    public int escalarCordenada(int cordenada) {
//        System.out.println("---"+((int)((cordenada*escala)/100))+" "+(cordenada*escala)/100);
        return (int) ((cordenada * escala) / 100);
    }

}
