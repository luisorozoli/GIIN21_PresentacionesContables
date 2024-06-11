/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import App.Router;
import Views.FiscalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rsilvente
 */
public class FiscalViewHandler implements ActionListener {

    FiscalView view;

    /**
     * Constructor de la vista.
     * @param view Instancia de la vista que va a ser manejada.
     */
    public FiscalViewHandler(FiscalView view) {
        this.view = view;

        for (var elem : this.view.botonesMunicipio) {
            elem.addActionListener(this);
        }

        for (var elem : this.view.botonesConvocatoria) {
            elem.addActionListener(this);
        }

        for (var elem : this.view.botonesPresentacion) {
            elem.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.botonesMunicipio[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getFiscal(), 
                    Router.getRouter().getMun_read());
        } else if (e.getSource() == this.view.botonesConvocatoria[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getFiscal(), 
                    Router.getRouter().getConv_read());
        } else if (e.getSource() == this.view.botonesPresentacion[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getFiscal(), 
                    Router.getRouter().getPres_read());
        }
    }

}
