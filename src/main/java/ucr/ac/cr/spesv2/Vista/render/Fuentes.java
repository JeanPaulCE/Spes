/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.render;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author jpcdl
 */
public class Fuentes {
    private Font typografia;

    /**
     *referencia a el nombre de la tipografia completo
     */
    public final static String montserratItalic = "Montserrat-Italic.otf";
    public final static String montserratLight = "Montserrat-Light.otf";
    public final static String montserratLightItalic = "Montserrat-LightItalic.otf";
    public final static String montserratRegular = "Montserrat-Regular.otf";
    
    public Font fuente(String fontName, int estilo, float size){
        
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("./src/main/resources/typografias/"+fontName));
            typografia = Font.createFont(Font.TRUETYPE_FONT, is);
            typografia = typografia.deriveFont(estilo,size);
        } catch (FontFormatException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.toString());
            System.out.println("ucr.ac.cr.spes.vista.render.Fuentes.fuente() \n INACEPTABLE!!!!!!!!!!!!!! \n ESTOY TRABAJANDO");
            typografia = new Font("Arial",Font.PLAIN,14);
            
        }
        return typografia;
        
    }
    
    
    
}
