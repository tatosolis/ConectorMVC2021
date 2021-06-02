
package conectormvc2021;

import controlador.ControladorActualizar;
import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import controlador.ControladorMostar;
import modelo.Conector;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.Frm_Actualizar;
import vista.Frm_Insertar;
import vista.Frm_Menu;
import vista.Frm_Mostrar;

/**
 *
 * @author ADMON
 */
public class ConectorMVC2021 {

  
    public static void main(String[] args) {
        
        //Vistas
        Frm_Menu m = new Frm_Menu();
        Frm_Insertar fi = new Frm_Insertar();
        Frm_Mostrar mo = new Frm_Mostrar();
        Frm_Actualizar act = new Frm_Actualizar();
        
        
        //Acceso a datos
        PaisVO pvo = new PaisVO();
        PaisDAO pdao = new PaisDAO();
        
        //Controladores
        ControladorMenu cm = new ControladorMenu(m, fi, mo, act);
        ControladorInsertar ci = new ControladorInsertar(fi, pvo, pdao);
        ControladorMostar cmo = new ControladorMostar(mo, act, pvo, pdao);
        ControladorActualizar cat = new ControladorActualizar(act, pvo, pdao);
        
        
        m.setVisible(true);
        m.setLocationRelativeTo(m);
        
        
        
        
        

    }
    
}
