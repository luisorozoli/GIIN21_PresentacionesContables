/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import App.Router;
import Models.Presentaciones;
import Views.Presentaciones.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

/**
 *
 * @author rsilvente
 */
public class PresentacionesViewHandler implements ActionListener {
    Create create;
    Delete delete;
    Read read;
    Update update;
    
    /**
     * 
     * @return Devuelve la instancia de la ventana Create de las Presentaciones.
     */
    public Create getCreate() {
        return create;
    }

    /**
     * Crea la relación de la Ventana Create de las Presentaciones y define 
     * los eventos de esta.
     * @param create Instancia de la ventana Create de las Presentaciones.
     */
    public void setCreate(Create create) {
        this.create = create;
        this.create.btnConfirmar.addActionListener(this);
    }

    /**
     * 
     * @return Devuelve la instancia de la ventana Delete de las Presentaciones.
     */
    public Delete getDelete() {
        return delete;
    }

    /**
     * Crea la relacion de la Ventana Delete de las Presentaciones y define 
     * los eventos de esta.
     * @param delete Instancia de la ventena Delete de las Presentaciones.
     */
    public void setDelete(Delete delete) {
        this.delete = delete;
        this.delete.btnBorrar.addActionListener(this);
    }

    /**
     * 
     * @return Devuelve la instancia de la ventana Read de las Presentaciones.
     */
    public Read getRead() {
        return read;
    }

    /**
     * Crea la relacion de la ventana Read de las Presentaciones y define 
     * los eventos de esta.
     * @param read Instancia de la ventana Read de las Presentaciones.
     */
    public void setRead(Read read) {
        this.read = read;
        this.read.btnVolver.addActionListener(this);
    }

    /**
     * 
     * @return Devuelve la instancia de la ventana Update de las Presentaciones.
     */
    public Update getUpdate() {
        return update;
    }

    /**
     * Crea la relación de la ventana Update de las Presentaciones y define 
     * los eventos de esta.
     * @param update Instancia de la ventana Update de las Presentaciones.
     */
    public void setUpdate(Update update) {
        this.update = update;
        this.update.btnConfirmar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component component = (Component) e.getSource();
        if (component.getParent() == this.create) {
            if (component == this.create.btnConfirmar) {
                agregarElemento();
                Router.getRouter().navigateTo(this.create, 
                        Router.getRouter().getLastFrame());
            }
        } else if (component.getParent() == this.delete) {
            if (component == this.delete.btnBorrar) {
                eliminarElemento();
                Router.getRouter().navigateTo(this.delete, 
                        Router.getRouter().getLastFrame());
            }
        } else if (component.getParent() == this.read) {
            if (component == this.read.btnVolver) {
                leerElemento();
                Router.getRouter().navigateTo(this.read, 
                        Router.getRouter().getLastFrame());
            }
        } else if (component.getParent() == this.update) {
            if (component == this.update.btnConfirmar) {
                actualizarElemento();
                Router.getRouter().navigateTo(this.update, 
                        Router.getRouter().getLastFrame());
            }
        }
    }
    
    private void agregarElemento() {
        PresentacionesDAO dao = new PresentacionesDAO();
        
        dao.addElemet(
        new Presentaciones(
                new Timestamp(create.getOpenYear(), create.getOpenMonth(), create.getOpenDay(), 0, 0, 0, 0),
                (Models.Tipos.TipoDocumentacion) create.getjList1().getSelectedItem(),
                (Models.Usuarios) create.getjComboBox1().getSelectedItem()
        ));
    }

    private void eliminarElemento() {
        PresentacionesDAO dao = new PresentacionesDAO();
        
        Presentaciones elemento = (Presentaciones) delete.getjComboBox2().getSelectedItem();
        dao.deleteElement(elemento.getId());
    }
    
    private void leerElemento() {        
        Presentaciones elemento = (Presentaciones) read.getjComboBox2().getSelectedItem();
        
//        TODO
    }
    
    private void actualizarElemento() {
        PresentacionesDAO dao = new PresentacionesDAO();
        
        Presentaciones elemento = (Presentaciones) read.getjComboBox1().getSelectedItem();
        
//        TODO
        
        dao.updateElement(elemento);
    }
    
}
