/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import App.Router;
import Views.AdministradorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rsilvente
 */
public class AdministradorViewHandler implements ActionListener {

    AdministradorView view;

    /**
     * Constructor.
     * @param view Instancia de la vista que va a ser manejada.
     */
    public AdministradorViewHandler(AdministradorView view) {
        this.view = view;

        // Usuarios Buttons
        for (var elem : this.view.botonesUsuario) {
            elem.addActionListener(this);
        }

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
        if (e.getSource() == this.view.botonesUsuario[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getUser_create());
        } else if (e.getSource() == this.view.botonesUsuario[1]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getUser_delete());
        } else if (e.getSource() == this.view.botonesUsuario[2]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getUser_update());
        } else if (e.getSource() == this.view.botonesUsuario[3]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getUser_read());
        } else if (e.getSource() == this.view.botonesMunicipio[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getMun_create());
        } else if (e.getSource() == this.view.botonesMunicipio[1]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getMun_delete());
        } else if (e.getSource() == this.view.botonesMunicipio[2]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getMun_update());
        } else if (e.getSource() == this.view.botonesMunicipio[3]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getMun_read());
        } else if (e.getSource() == this.view.botonesConvocatoria[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getConv_create());
        } else if (e.getSource() == this.view.botonesConvocatoria[1]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getConv_delete());
        } else if (e.getSource() == this.view.botonesConvocatoria[2]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getConv_update());
        } else if (e.getSource() == this.view.botonesConvocatoria[3]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getConv_read());
        } else if (e.getSource() == this.view.botonesPresentacion[0]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getPres_create());
        } else if (e.getSource() == this.view.botonesPresentacion[1]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getPres_delete());
        } else if (e.getSource() == this.view.botonesPresentacion[2]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getPres_update());
        } else if (e.getSource() == this.view.botonesPresentacion[3]) {
            Router.getRouter().navigateTo(Router.getRouter().getAdmin(), 
                    Router.getRouter().getPres_read());
        }
    }

}
