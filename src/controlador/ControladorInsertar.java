
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.Frm_Insertar;

/**
 *
 * @author ADMON
 */
public class ControladorInsertar implements ActionListener{
    Frm_Insertar vista = new Frm_Insertar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    public ControladorInsertar(Frm_Insertar vista, PaisVO pvo, PaisDAO pdao){
        this.vista = vista;
        this.pvo =pvo;
        this.pdao = pdao;
        
        vista.Btn_Aceptar.addActionListener(this);
        vista.Btn_Cancelar.addActionListener(this);
        
    }
    private void insertarPais(){
        pvo.setNombre_pais(vista.Txt_Pais.getText());
        pvo.setCapital_pais(vista.Txt_Capital.getText());
        pvo.setPoblacion_pais(Long.parseLong(vista.Txt_Poblacion.getText()));
        pdao.insertar(pvo);
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==vista.Btn_Aceptar){
            this.insertarPais();
            vista.jOp_Inserta.showMessageDialog(null, "Registro Insertado");
                   
        }
        if(ae.getSource()==vista.Btn_Cancelar){
            vista.dispose();
        }
    }
    
}
