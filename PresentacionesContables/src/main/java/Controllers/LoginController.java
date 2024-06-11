/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import App.Router;
import Models.Usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Views.*;

/**
 *
 * @author rsilvente
 */
public class LoginController implements ActionListener {

    LoginView login;
    Usuarios user;

    /**
     * Constructor de la vista.
     * @param login Instancia de la vista que va a ser manejada.
     */
    public LoginController(LoginView login) {
        user = null;

        this.login = login;

        this.login.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.btnLogin) {
            if (checkCredencials(this.login.txtUsername.getText(),
                    new String(this.login.txtPassword.getPassword()))
                    ) {
                
                this.login.setVisible(false);
                
                switch (user.getTipoUsuario().getNombre()) {
                    case "Administrador":
                        Router.getRouter().generatedViewsForAdmin();
                        break;
                    case "FiscalGeneral":
                        Router.getRouter().generatedViewsForFiscalGeneral();
                        break;
                    case "Fiscal":
                        Router.getRouter().generatedViewsForFiscal();
                        break;
                    default:
                        Router.getRouter().generatedViewsForCuentadante();
                        break;
                }
            }
        }
    }

    private boolean checkCredencials(String username, String password) {
        user = UsuariosDAO.getElementByUsername(username);

        if (user == null) {
            return false;
        }

        if (username.equals(user.getNombre()) && password.equals(user.getClave())) {
            System.out.println("Las credenciales son correctas.");
            return true;
        }

        return false;
    }

}
