
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.Frm_Actualizar;
import vista.Frm_Mostrar;


public class ControladorActualizar implements ActionListener, WindowListener, MouseListener{
    
    Frm_Actualizar act = new Frm_Actualizar();
    //Frm_Mostrar mos = new Frm_Mostrar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    public ControladorActualizar(Frm_Actualizar act,  PaisVO pvo, PaisDAO pdao ){
        this.act = act;
       // this.mos = mos;
        this.pvo = pvo;
        this.pdao = pdao;
        act.Btn_Guardar.addActionListener(this);
        act.Btn_Cancelar.addActionListener(this);
        act.Btn_Eliminar.addActionListener(this);
        act.addWindowListener(this);
        
    }
    
     private void actualizarPais(){
        pvo.setId_pais(Integer.parseInt(act.Txt_IdPais.getText()));
        pvo.setNombre_pais(act.Txt_Pais.getText());
        pvo.setCapital_pais(act.Txt_Capital.getText());
        pvo.setPoblacion_pais(Long.parseLong(act.Txt_Poblacion.getText()));
        pdao.actualizar(pvo);
       
    }
     
     private void eliminarPais(){
          pvo.setId_pais(Integer.parseInt(act.Txt_IdPais.getText()));
          pdao.eliminar(pvo);
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==act.Btn_Guardar){
            try {
                this.actualizarPais();
                act.Jop.showMessageDialog(null, "Registro Actualizado");
                
            } catch (Exception e) {
                act.Jop.showMessageDialog(null, "Registro no Actualizado");
            }
            
           
        }
        if(ae.getSource()==act.Btn_Eliminar){
            try {
                this.eliminarPais();
                act.Jop.showMessageDialog(null, "Registro Eliminado");
                
            } catch (Exception e) {
                act.Jop.showMessageDialog(null, "Registro no Eliminado");
            }
        }
        
        if(ae.getSource()==act.Btn_Cancelar){
            act.dispose();
        }
            
        
        
    }

    @Override
    public void windowOpened(WindowEvent we) {
        this.actualizarPais();
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
