/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import App.Router;
import Models.Convocatorias;
import Views.Convocatorias.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

/**
 * 
 * @author rsilvente
 */
public class ConvocatoriasViewHandler implements ActionListener {
    Create create;
    Delete delete;
    Read read;
    Update update;
    
    /**
     * 
     * @return Devuelve la instancia de la ventana Create de las Convocatorias.
     */
    public Create getCreate() {
        return create;
    }

    /**
     * Crea la relación de la Ventana Create de las Convocatorias y define 
     * los eventos de esta.
     * @param create Instancia de la ventana Create de las Convocatorias.
     */
    public void setCreate(Create create) {
        this.create = create;
        this.create.btnConfirmar.addActionListener(this);
    }

    /**
     * 
     * @return Devuelve la instancia de la ventana Delete de las Convocatorias.
     */
    public Delete getDelete() {
        return delete;
    }

    /**
     * Crea la relacion de la Ventana Delete de las Convocatorias y define 
     * los eventos de esta.
     * @param delete Instancia de la ventena Delete de las Convocatorias.
     */
    public void setDelete(Delete delete) {
        this.delete = delete;
        this.delete.btnBorrar.addActionListener(this);
    }

    /**
     * 
     * @return Devuelve la instancia de la ventana Read de las Convocatorias.
     */
    public Read getRead() {
        return read;
    }

    /**
     * Crea la relacion de la ventana Read de las Convocatorias y define 
     * los eventos de esta.
     * @param read Instancia de la ventana Read de las Convocatorias.
     */
    public void setRead(Read read) {
        this.read = read;
        this.read.btnVolver.addActionListener(this);
    }

    /**
     * 
     * @return Devuelve la instancia de la ventana Update de las Convocatorias.
     */
    public Update getUpdate() {
        return update;
    }

    /**
     * Crea la relación de la ventana Update de las Convocatorias y define 
     * los eventos de esta.
     * @param update Instancia de la ventana Update de las Convocatorias.
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
        ConvocatoriasDAO dao = new ConvocatoriasDAO();
        
        dao.addElemet(
        new Convocatorias(
                create.getjTextField1().getText(),
                new Timestamp(create.getOpenYear(), create.getOpenMonth(), create.getOpenDay(), 0, 0, 0, 0),
                new Timestamp(create.getCloseYear(), create.getCloseMonth(), create.getCloseDay(), 0, 0, 0, 0),
                create.getjRadioButton1().isSelected(),
                new Models.Tipos.TipoDocumentacion()
        ));
    }

    private void eliminarElemento() {
        ConvocatoriasDAO dao = new ConvocatoriasDAO();
        
        Convocatorias elemento = (Convocatorias) delete.getListConvocatorias().getSelectedItem();
        dao.deleteElement(elemento.getId());
    }
    
    private void leerElemento() {        
        Convocatorias elemento = (Convocatorias) read.getjComboBox1().getSelectedItem();
        
        read.getjTextField1().setText(elemento.getNombre());
        read.getjTextField2().setText("Tiempo 1");
        read.getjTextField3().setText("Tiempo 2");
        read.getjRadioButton1().setSelected(elemento.isEstadoApertura());
    }
    
    private void actualizarElemento() {
        ConvocatoriasDAO dao = new ConvocatoriasDAO();
        
        Convocatorias elemento = (Convocatorias) read.getjComboBox1().getSelectedItem();
        
        elemento.setNombre(update.getjTextField1().getText());
        elemento.setFechaApertura(new Timestamp(update.getOpenYear(), update.getOpenMonth(), update.getOpenDay(), 0, 0, 0, 0));
        elemento.setFechaCierre(new Timestamp(update.getCloseYear(), update.getCloseMonth(), update.getCloseDay(), 0, 0, 0, 0));
        elemento.setEstadoApertura(update.getjRadioButton1().isSelected());
        
        dao.updateElement(elemento);
    }
    
}
