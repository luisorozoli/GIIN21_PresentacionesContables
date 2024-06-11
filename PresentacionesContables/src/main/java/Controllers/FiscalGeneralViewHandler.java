/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import App.Router;
import Views.FiscalGeneralView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rsilvente
 */
public class FiscalGeneralViewHandler implements ActionListener {

    FiscalGeneralView view;

    /**
     * Constructor de la vista.
     * @param view Instancia de la vista que va a ser manejada.
     */
    public FiscalGeneralViewHandler(FiscalGeneralView view) {
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
            Router.getRouter().navigateTo(Router.getRouter().getFiscalGeneral(), 
                    Router.getRouter().getMun_read());
        } else if (e.getSource() == this.view.botonesConvocatoria[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getFiscalGeneral(), 
                    Router.getRouter().getConv_create());
        } else if (e.getSource() == this.view.botonesConvocatoria[1]) {
            Router.getRouter().navigateTo(Router.getRouter().getFiscalGeneral(), 
                    Router.getRouter().getConv_delete());
        } else if (e.getSource() == this.view.botonesConvocatoria[2]) {
            Router.getRouter().navigateTo(Router.getRouter().getFiscalGeneral(), 
                    Router.getRouter().getConv_update());
        } else if (e.getSource() == this.view.botonesConvocatoria[3]) {
            Router.getRouter().navigateTo(Router.getRouter().getFiscalGeneral(), 
                    Router.getRouter().getConv_read());
        } else if (e.getSource() == this.view.botonesPresentacion[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getFiscalGeneral(), 
                    Router.getRouter().getPres_update());
        } else if (e.getSource() == this.view.botonesPresentacion[1]) {
            Router.getRouter().navigateTo(Router.getRouter().getFiscalGeneral(), 
                    Router.getRouter().getPres_read());
        }
    }

}
