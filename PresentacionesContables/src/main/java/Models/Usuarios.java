/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.Tipos.TipoUsuario;
import javax.persistence.*;

/**
 *
 * @author rsilvente
 */
@Entity
@Table(name="usuarios")
public class Usuarios {

    /**
     * Constructor de la clase Usuarios.
     * @param Nombre Nombre del usuario.
     * @param Clave Contraseña del usuario.
     * @param TipoUsuario {@link Models.Tipos.TipoUsuario}
     */
    public Usuarios(String Nombre, String Clave, TipoUsuario TipoUsuario) {
        this.Nombre = Nombre;
        this.Clave = Clave;
        this.TipoUsuario = TipoUsuario;
    }
    
    /**
     * Constructor de la clase Usuarios
     */
    public Usuarios() {
    }
    
    /**
     * @return Identificador único de la clase.
     */
    public int getId() {
        return Id;
    }

    /**
     * @return Nombre del Usuario
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre {@link Usuarios#getNombre() }
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return Contraseña del Usuario
     */
    public String getClave() {
        return Clave;
    }

    /**
     * @param Clave {@link Usuarios#getClave() }
     */
    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    /**
     * @return Tipo de Usuario al que pertenece el Usuario
     */
    public TipoUsuario getTipoUsuario() {
        return TipoUsuario;
    }

    /**
     * @param TipoUsuario {@link Usuarios#getTipoUsuario() }
     */
    public void setTipoUsuario(TipoUsuario TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "Id=" + Id + ", Nombre=" + Nombre + ", Clave=" + Clave + ", TipoUsuario=" + TipoUsuario + '}';
    }
    
    @Id                     // Se trata de la clave primaria.
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")      // Indicamos la columna a la que está enlazado.
    private int Id;
    
    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="Clave")
    private String Clave;
    
    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="Id")
    private TipoUsuario TipoUsuario;
    
}
