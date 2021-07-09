/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.animaciones;

import javax.swing.ImageIcon;
import ucr.ac.cr.spesv2.Vista.render.RenderImg;

/**
 *
 * @author jpcdl
 */
public class Linea {
    private int x,y,width,height;
    private ImageIcon img;
    private RenderImg render;
    private Double escala;
    
    public Linea(int x, int y, ImageIcon img) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.escala = 1.0;
        width = img.getIconWidth();
        height = img.getIconHeight();
        
        render = new RenderImg(img);
    }

    public Linea(int x, int y) {
        this.x = x;
        this.y = y;
        this.img = new javax.swing.ImageIcon(getClass().getResource("/img/linea.png"));
        this.escala = 1.0;
        width = img.getIconWidth();
        height = img.getIconHeight();
        render = new RenderImg(img);
    }

    public Double getEscala() {
        return escala;
    }

    public void setEscala(Double escala) {
        this.img = render.escalar(escala);
        width = img.getIconWidth();
        height = img.getIconHeight();
        this.escala = escala;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    void setLocation(int x, int y) {
        setX(x);
        setY(y);
    }
    public int getWidthOriginal(){
        return render.anchoOriginal;
    };
    
    
}
