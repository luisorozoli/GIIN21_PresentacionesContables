/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import javax.swing.JFrame;

/**
 *
 * @author rsilvente
 */
public class Router {

    // Views de Usuarios
    private Views.AdministradorView admin = null;
    private Views.CuentadanteView cuentadante = null;
    private Views.FiscalGeneralView fiscalGeneral = null;
    private Views.FiscalView fiscal = null;
    private Views.LoginView login = null;

    // Views de Control
    private Views.Convocatorias.Create conv_create = null;
    private Views.Convocatorias.Delete conv_delete = null;
    private Views.Convocatorias.Read conv_read = null;
    private Views.Convocatorias.Update conv_update = null;
    private Views.Municipios.Create mun_create = null;
    private Views.Municipios.Delete mun_delete = null;
    private Views.Municipios.Read mun_read = null;
    private Views.Municipios.Update mun_update = null;
    private Views.Presentaciones.Create pres_create = null;
    private Views.Presentaciones.Delete pres_delete = null;
    private Views.Presentaciones.Read pres_read = null;
    private Views.Presentaciones.Update pres_update = null;
    private Views.Usuarios.Create user_create = null;
    private Views.Usuarios.Delete user_delete = null;
    private Views.Usuarios.Read user_read = null;
    private Views.Usuarios.Update user_update = null;
    
    private JFrame lastFrame = null;
    
    private static Router miRouter;

    /**
     * Permite obtener el controlador de la Navegación de la aplicación. En 
     * el caso de que no exista ninguna instancia de este, es generada.
     * @return Devuelve el controlador de la navegación de la aplicación.
     */
    public static Router getRouter() {
        if (miRouter == null) {
            miRouter = new Router();
        }
        
        return miRouter;
    }
    
    private Router() {
        this.login = new Views.LoginView();
        this.login.setVisible(true);
        this.login.setLocationRelativeTo(null);
    }

    /**
     * Método el cual genera todas las instancias necesarias para el correcto 
     * funcionamiento de la aplicación por parte del Administrador.
     */
    public void generatedViewsForAdmin() {
        this.admin = new Views.AdministradorView();
        Handler.getHandler().createAdministradorHandler(admin);

        // Convocatorias
        this.conv_create = new Views.Convocatorias.Create();
        Handler.getHandler().createConvocatorias_C(conv_create);
        this.conv_delete = new Views.Convocatorias.Delete();
        Handler.getHandler().createConvocatorias_D(conv_delete);
        this.conv_read = new Views.Convocatorias.Read();
        Handler.getHandler().createConvocatorias_R(conv_read);
        this.conv_update = new Views.Convocatorias.Update();
        Handler.getHandler().createConvocatorias_U(conv_update);

        // Municipios
        this.mun_create = new Views.Municipios.Create();
        Handler.getHandler().createMunicipios_C(mun_create);
        this.mun_delete = new Views.Municipios.Delete();
        Handler.getHandler().createMunicipios_D(mun_delete);
        this.mun_read = new Views.Municipios.Read();
        Handler.getHandler().createMunicipios_R(mun_read);
        this.mun_update = new Views.Municipios.Update();
        Handler.getHandler().createMunicipios_U(mun_update);

        // Presentaciones
        this.pres_create = new Views.Presentaciones.Create();
        Handler.getHandler().createPresentaciones_C(pres_create);
        this.pres_delete = new Views.Presentaciones.Delete();
        Handler.getHandler().createMunicipios_D(mun_delete);
        this.pres_read = new Views.Presentaciones.Read();
        Handler.getHandler().createMunicipios_R(mun_read);
        this.pres_update = new Views.Presentaciones.Update();
        Handler.getHandler().createPresentaciones_U(pres_update);

        // Usuarios
        this.user_create = new Views.Usuarios.Create();
        Handler.getHandler().createUsuarios_C(user_create);
        this.user_delete = new Views.Usuarios.Delete();
        Handler.getHandler().createUsuarios_D(user_delete);
        this.user_read = new Views.Usuarios.Read();
        Handler.getHandler().createUsuarios_R(user_read);
        this.user_update = new Views.Usuarios.Update();
        Handler.getHandler().createUsuarios_U(user_update);
    }

    /**
     * Método el cual genera todas las instancias necesarias para el correcto 
     * funcionamiento de la aplicación por parte del Cuentadante.
     */
    public void generatedViewsForCuentadante() {
        this.cuentadante = new Views.CuentadanteView();
        Handler.getHandler().createCuentadanteHandler(cuentadante);

        this.mun_read = new Views.Municipios.Read();
        Handler.getHandler().createMunicipios_R(mun_read);

        this.conv_read = new Views.Convocatorias.Read();
        Handler.getHandler().createConvocatorias_R(conv_read);

        this.pres_read = new Views.Presentaciones.Read();
        Handler.getHandler().createPresentaciones_R(pres_read);
    }

    /**
     * Método el cual genera todas las instancias necesarias para el correcto 
     * funcionamiento de la aplicación por parte del FiscalGeneral.
     */
    public void generatedViewsForFiscalGeneral() {
        this.fiscalGeneral = new Views.FiscalGeneralView();
        Handler.getHandler().createFiscalGeneralHandler(fiscalGeneral);

        this.conv_create = new Views.Convocatorias.Create();
        Handler.getHandler().createConvocatorias_C(conv_create);
        this.conv_delete = new Views.Convocatorias.Delete();
        Handler.getHandler().createConvocatorias_D(conv_delete);
        this.conv_read = new Views.Convocatorias.Read();
        Handler.getHandler().createConvocatorias_R(conv_read);
        this.conv_update = new Views.Convocatorias.Update();
        Handler.getHandler().createConvocatorias_U(conv_update);

        this.mun_read = new Views.Municipios.Read();
        Handler.getHandler().createMunicipios_R(mun_read);

        this.pres_read = new Views.Presentaciones.Read();
        Handler.getHandler().createPresentaciones_R(pres_read);
        this.pres_update = new Views.Presentaciones.Update();
        Handler.getHandler().createPresentaciones_U(pres_update);
    }

    /**
     * Método el cual genera todas las instancias necesarias para el correcto 
     * funcionamiento de la aplicación por parte del Fiscal.
     */
    public void generatedViewsForFiscal() {
        this.fiscal = new Views.FiscalView();
        Handler.getHandler().createFiscal(fiscal);

        this.mun_read = new Views.Municipios.Read();
        Handler.getHandler().createMunicipios_R(mun_read);

        this.conv_read = new Views.Convocatorias.Read();
        Handler.getHandler().createConvocatorias_R(conv_read);

        this.pres_read = new Views.Presentaciones.Read();
        Handler.getHandler().createPresentaciones_R(pres_read);
    }

    /**
     * Método cuyo objetivo es realizar el cambio de la ventana en al que se 
     * encuentra el usuario (Actual) a la ventana definida como Objetivo.
     * @param actual Ventana desde la que se inicia la navegación.
     * @param destino Ventana a la cual se quiere navegar.
     */
    public void navigateTo(JFrame actual, JFrame destino) {
        actual.setVisible(false);
        lastFrame = actual;
        destino.setVisible(true);
    }

    /**
     * 
     * @return Devuelve la ventana de Administrador.
     */
    public Views.AdministradorView getAdmin() {
        return admin;
    }

    /**
     * 
     * @return Devuelve la ventana de Cuentadante.
     */
    public Views.CuentadanteView getCuentadante() {
        return cuentadante;
    }

    /**
     * 
     * @return Devuelve la ventana de Fiscal General.
     */
    public Views.FiscalGeneralView getFiscalGeneral() {
        return fiscalGeneral;
    }

    /**
     * 
     * @return Devuelve la ventana de Fiscal.
     */
    public Views.FiscalView getFiscal() {
        return fiscal;
    }

    /**
     * 
     * @return Devuelve la ventana de Login.
     */
    public Views.LoginView getLogin() {
        return login;
    }

    /**
     * 
     * @return Devuelve la ventana de Crear una Convocatoria.
     */
    public Views.Convocatorias.Create getConv_create() {
        return conv_create;
    }

    /**
     * 
     * @return Devuelve la ventana de Eliminar una Convocatoria.
     */
    public Views.Convocatorias.Delete getConv_delete() {
        return conv_delete;
    }

    /**
     * 
     * @return Devuelve la ventana para Leer una Convocatoria.
     */
    public Views.Convocatorias.Read getConv_read() {
        return conv_read;
    }

    /**
     * 
     * @return Devuelve la ventana para Actualizar una Convocatoria.
     */
    public Views.Convocatorias.Update getConv_update() {
        return conv_update;
    }
    
    /**
     * 
     * @return Devuelve la ventana para Crear un Municipio.
     */
    public Views.Municipios.Create getMun_create() {
        return mun_create;
    }

    /**
     * 
     * @return Devuelve la ventana para Eliminar un Municipio.
     */
    public Views.Municipios.Delete getMun_delete() {
        return mun_delete;
    }

    /**
     * 
     * @return Devuelve la ventana para Leer un Municipio.
     */
    public Views.Municipios.Read getMun_read() {
        return mun_read;
    }

    /**
     * 
     * @return Devuelve la ventana para Actualizar un Municipio.
     */
    public Views.Municipios.Update getMun_update() {
        return mun_update;
    }

    /**
     * 
     * @return Devuelve la ventana para Crear una Presentacion.
     */
    public Views.Presentaciones.Create getPres_create() {
        return pres_create;
    }

    /**
     * 
     * @return Devuelve la ventana para Eliminar una Presentacion.
     */
    public Views.Presentaciones.Delete getPres_delete() {
        return pres_delete;
    }

    /**
     * 
     * @return Devuelve la ventana para Leer una Presentacion.
     */
    public Views.Presentaciones.Read getPres_read() {
        return pres_read;
    }

    /**
     * 
     * @return Devuelve la ventana para Actualizar una Presentacion.
     */
    public Views.Presentaciones.Update getPres_update() {
        return pres_update;
    }

    /**
     * 
     * @return Devuelve la ventana para Crear un Usuario.
     */
    public Views.Usuarios.Create getUser_create() {
        return user_create;
    }
    
    /**
     * 
     * @return Devuelve la ventana para Eliminar un Usuario.
     */
    public Views.Usuarios.Delete getUser_delete() {
        return user_delete;
    }

    /**
     * 
     * @return Devuelve la ventana Leer un Usuario.
     */
    public Views.Usuarios.Read getUser_read() {
        return user_read;
    }

    /**
     * 
     * @return Devuelve la ventana para Actualizar un Usuario.
     */
    public Views.Usuarios.Update getUser_update() {
        return user_update;
    }
    
    /**
     * 
     * @return Devuelve la última ventana desde la que se ha iniciado la 
     * navegación.
     */
    public JFrame getLastFrame() {
        return lastFrame;
    }

}
