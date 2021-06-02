
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Frm_Actualizar;
import vista.Frm_Insertar;
import vista.Frm_Menu;
import vista.Frm_Mostrar;


public class ControladorMenu implements ActionListener{
    Frm_Menu vMe = new Frm_Menu();
    Frm_Insertar vIn = new Frm_Insertar();
    Frm_Mostrar vMo = new Frm_Mostrar();
    Frm_Actualizar act = new Frm_Actualizar();
    
    public ControladorMenu(Frm_Menu vMe, Frm_Insertar vIn, Frm_Mostrar vMo, Frm_Actualizar act){
        
        this.vMe = vMe;
        this.vIn = vIn;
        this.vMo = vMo;
        this.act = act;
        
        vMe.btn_insertar.addActionListener(this);
        vMe.BtnMostrar.addActionListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== vMe.btn_insertar){
            vIn.setVisible(true);
            vIn.setLocationRelativeTo(null);
        }
        if(ae.getSource()== vMe.BtnMostrar){
            vMo.setVisible(true);
            vMo.setLocationRelativeTo(null);
        }
    }
    
    
    
    
   
    
    
    
    
    
}
