/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 * Clase usada para generar y controlar la instanciación de los manejadores de
 * cada una de las Vistas de la aplicación.
 * @author rsilvente
 */
public class Handler {

    private Controllers.AdministradorViewHandler admin = null;
    private Controllers.ConvocatoriasViewHandler conv = null;
    private Controllers.CuentadanteViewHandler cuent = null;
    private Controllers.FiscalGeneralViewHandler fisGen = null;
    private Controllers.FiscalViewHandler fis = null;
    private Controllers.MunicipiosViewHandler mun = null;
    private Controllers.PresentacionesViewHandler pres = null;
    private Controllers.UsuariosViewHandler user = null;
    private Controllers.LoginController login = null;

    private static Handler miHandler;

    /**
     * Permite obtener el Handler de las ventanas de la aplicación. En el caso 
     * de que no exista instancia de dicho Handler, se genera una.
     * @return El Handler de la aplicación.
     */
    public static Handler getHandler() {
        if (miHandler == null) {
            miHandler = new Handler();
        }
        return miHandler;
    }

    private Handler() {
        conv = new Controllers.ConvocatoriasViewHandler();
        mun = new Controllers.MunicipiosViewHandler();
        pres = new Controllers.PresentacionesViewHandler();
        user = new Controllers.UsuariosViewHandler();
    }

    /**
     * Genera la instancia del manejador de la ventana del Administador.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createAdministradorHandler(Views.AdministradorView view) {
        admin = new Controllers.AdministradorViewHandler(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana del Cuentadante.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createCuentadanteHandler(Views.CuentadanteView view) {
        cuent = new Controllers.CuentadanteViewHandler(view);
    }

    /**
     * * Genera la instancia del manejador de la ventana del Fiscal General.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createFiscalGeneralHandler(Views.FiscalGeneralView view) {
        fisGen = new Controllers.FiscalGeneralViewHandler(view);
    }

    /**
     * Genera la instancia del manejador de la ventana del Fiscal.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createFiscal(Views.FiscalView view) {
        fis = new Controllers.FiscalViewHandler(view);
    }

    /**
     * Genera la instancia del manejador de la ventana de Login.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createLogin(Views.LoginView view) {
        login = new Controllers.LoginController(view);
    }

    /**
     * Genera la instancia del manejador de la ventana de Creacion de 
     * Convocatorias.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createConvocatorias_C(Views.Convocatorias.Create view) {
        conv.setCreate(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Eliminar 
     * Convocatorias.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createConvocatorias_D(Views.Convocatorias.Delete view) {
        conv.setDelete(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Leer los datos de 
     * una Convocatoria.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createConvocatorias_R(Views.Convocatorias.Read view) {
        conv.setRead(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Actualizar los 
     * datos de una Convocatoria.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createConvocatorias_U(Views.Convocatorias.Update view) {
        conv.setUpdate(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Crear un nuevo 
     * Municipio.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createMunicipios_C(Views.Municipios.Create view) {
        mun.setCreate(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Eliminar un  
     * Municipio.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createMunicipios_D(Views.Municipios.Delete view) {
        mun.setDelete(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Leer los datos 
     * de un Municipio.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createMunicipios_R(Views.Municipios.Read view) {
        mun.setRead(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Actualizar los 
     * datos de un Municipio.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createMunicipios_U(Views.Municipios.Update view) {
        mun.setUpdate(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Crear una nueva 
     * Presentación.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createPresentaciones_C(Views.Presentaciones.Create view) {
        pres.setCreate(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Eliminar una
     * Presentacion.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createPresentaciones_D(Views.Presentaciones.Delete view) {
        pres.setDelete(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Leer una 
     * Presentacion.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createPresentaciones_R(Views.Presentaciones.Read view) {
        pres.setRead(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Actualizar una 
     * Presentacion.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createPresentaciones_U(Views.Presentaciones.Update view) {
        pres.setUpdate(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Crear un nuevo 
     * Usuario.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createUsuarios_C(Views.Usuarios.Create view) {
        user.setCreate(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Eliminar un 
     * Usuario.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createUsuarios_D(Views.Usuarios.Delete view) {
        user.setDelete(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Leer los datos  
     * de un Usuario.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createUsuarios_R(Views.Usuarios.Read view) {
        user.setRead(view);
    }
    
    /**
     * Genera la instancia del manejador de la ventana para Actualizar los 
     * datos de un Usuario.
     * @param view Vista sobre la que actua el Handler.
     */
    public void createUsuarios_U(Views.Usuarios.Update view) {
        user.setUpdate(view);
    }

}
