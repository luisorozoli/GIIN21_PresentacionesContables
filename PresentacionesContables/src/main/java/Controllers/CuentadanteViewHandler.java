/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import App.Router;
import Views.CuentadanteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rsilvente
 */
public class CuentadanteViewHandler implements ActionListener {

    CuentadanteView view;

    /**
     * Constructor del Handler.
     * @param view Instancia de la vista manejada.
     */
    public CuentadanteViewHandler(CuentadanteView view) {
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
            Router.getRouter().navigateTo(Router.getRouter().getCuentadante(),
                    Router.getRouter().getUser_read());
        } else if (e.getSource() == this.view.botonesConvocatoria[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getCuentadante(),
                    Router.getRouter().getConv_read());
        } else if (e.getSource() == this.view.botonesPresentacion[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getCuentadante(),
                    Router.getRouter().getPres_create());
        } else if (e.getSource() == this.view.botonesPresentacion[1]) {
            Router.getRouter().navigateTo(Router.getRouter().getCuentadante(),
                    Router.getRouter().getPres_update());
        }
    }

}
