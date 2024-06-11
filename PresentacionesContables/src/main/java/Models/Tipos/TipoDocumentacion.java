/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Tipos;

import javax.persistence.*;

/**
 * Clase la cual es usada para la definición de cada uno de los Tipos entre 
 * los que un documento se puede clasificar.
 * @author rsilvente
 */
@Entity
@Table(name="documentacion")
public class TipoDocumentacion {

    /**
     * Constructor de la clase Tipo Documentacion
     * @param Nombre Nombre de la Documentacion
     * @param Descripcion Descripción de la Documentacion
     */
    public TipoDocumentacion(String Nombre, String Descripcion) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }
    
    /**
     * Constructor de la clase Tipo Documentacion
     */
    public TipoDocumentacion() {
    }

    /**
     * @return Identificador único de la clase
     */
    public int getId() {
        return Id;
    }

    /**
     * @return Nombre del Tipo de Documentacion
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre {@link TipoDocumentacion#getNombre() }
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return Descripcion del Tipo de Documentacion
     */
    public String getDescripcion() {
        return Descripcion;
    }
    
    /**
     * @param Descripcion {@link TipoDocumentacion#getDescripcion() }
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "TipoDocumentacion{" + "Id=" + Id + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + '}';
    }
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;
    
    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="Descripcion")
    private String Descripcion;
}
