/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.render;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author jpcdl
 */
public class GestionCeldas extends DefaultTableCellRenderer {



    //se definen por defecto los tipos de datos a usar
    private Font normal = new Fuentes().fuente(Fuentes.montserratLight, 0,new RenderEscala(1920).escalarCordenada(21));

    //etiqueta que almacenará el icono a mostrar
    private JLabel label = new JLabel();


    public GestionCeldas() {

    }

    /**
     * Constructor explicito con el tipo de dato que tendrá la celda
     *
     * @param tipo
     */


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

        /*
		 * Este metodo controla toda la tabla, podemos obtener el valor que contiene
		 * definir que celda está seleccionada, la fila y columna al tener el foco en ella.
		 * 
		 * cada evento sobre la tabla invocará a este metodo
         */
        //definimos colores por defecto
        
        Color colorFondoPorDefecto = new Color(241, 241, 241);
        //Font fuenteMonsterrar = new Font();

        /*
         * Si la celda del evento es la seleccionada se asigna el fondo por defecto para la selección
         */
        
        if (row % 2 != 0) {
            this.setBackground(colorFondoPorDefecto);
            
        } else {
            //Para las que no están seleccionadas se pinta el fondo de las celdas de blanco
            this.setBackground(Color.white);
        }
        if(selected){
            this.setBackground(new Color(201, 201, 201));
        }
        if(selected){
            this.setBackground(new Color(201, 201, 201));
        }
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setText( (String) value );
        this.setFont(normal);  
        this.setForeground(new Color(112,112,112));

        return this;

    }
}
