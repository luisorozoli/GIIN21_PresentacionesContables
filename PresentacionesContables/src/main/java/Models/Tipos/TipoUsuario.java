/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Tipos;

import javax.persistence.*;

/**
 * Esta clase sirve para definir cada uno de los Tipos de Usuarios a traves de 
 * los cuales se manejan los permisos en la aplicación.
 * @author rsilvente
 */
@Entity
@Table(name="tipo_usuario")
public class TipoUsuario {

    /**
     * Constructor de Tipo de Usuario
     * @param Nombre Nombre identificativo del Tipo de Usuario.
     * @param Descripcion Descripción del Tipo de Usuario.
     */
    public TipoUsuario(String Nombre, String Descripcion) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }
    
    /**
     * Constructor del Tipo de Usuario
     */
    public TipoUsuario() {
    }

    /**
     * @return Identificador único de la clase
     */
    public int getId() {
        return Id;
    }

    /**
     * @return Nombre del Tipo de Usuario
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre {@link TipoUsuario#getNombre() }
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return Descripcion del Tipo de Usuario
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion {@link TipoUsuario#getDescripcion() }
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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
