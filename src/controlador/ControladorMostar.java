package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.Frm_Actualizar;
import vista.Frm_Mostrar;

public class ControladorMostar implements ActionListener, MouseListener, WindowListener {

    Frm_Mostrar vista = new Frm_Mostrar();
    Frm_Actualizar act = new Frm_Actualizar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorMostar(Frm_Mostrar vista, Frm_Actualizar act, PaisVO pvo, PaisDAO pdao) {
        this.vista = vista;
        this.pvo = pvo;
        this.pdao = pdao;
        this.act = act;
        vista.addWindowListener(this);
        vista.Btn_Mostrar.addActionListener(this);
        vista.TblMostrar.addMouseListener(this);
        vista.Btn_Salir.addActionListener(this);
    }

    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre del pais");
        m.addColumn("Capital");
        m.addColumn("poblacion ");
        for (PaisVO pvo : pdao.consultarTabla()) {
            m.addRow(new Object[]{pvo.getId_pais(), pvo.getNombre_pais(),
                pvo.getCapital_pais(), pvo.getPoblacion_pais()});
        }
        vista.TblMostrar.setModel(m);

    }



    @Override
    public void windowOpened(WindowEvent we) {
        this.mostrar();
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
    public void actionPerformed(ActionEvent ae) {
        this.mostrar();
        if (ae.getSource()==vista.Btn_Salir){
            vista.dispose();
    }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int seleccion = vista.TblMostrar.getSelectedRow();
        act.Txt_IdPais.setText(String.valueOf(vista.TblMostrar.getValueAt(seleccion, 0)));
        act.Txt_Pais.setText(String.valueOf(vista.TblMostrar.getValueAt(seleccion, 1)));
        act.Txt_Capital.setText(String.valueOf(vista.TblMostrar.getValueAt(seleccion, 2)));
        act.Txt_Poblacion.setText(String.valueOf(vista.TblMostrar.getValueAt(seleccion, 3)));
        act.setVisible(true);
       // this.tablaMouseClicked(me);
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
