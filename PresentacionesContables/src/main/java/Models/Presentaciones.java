/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.Tipos.TipoDocumentacion;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 *
 * @author rsilvente
 */
@Entity
@Table(name="convocatorias")
public class Presentaciones {

    /**
     * Constructor de la clase Presentaciones.
     * @param FechaPresentacion Fecha en la cual se realiza la presentación.
     * @param tipoDocumentacion {@link Models.Tipos.TipoDocumentacion}
     * @param usuarios {@link Models.Usuarios}
     */
    public Presentaciones(Timestamp FechaPresentacion, TipoDocumentacion tipoDocumentacion, Usuarios usuarios) {
        this.FechaPresentacion = FechaPresentacion;
        this.tipoDocumentacion = tipoDocumentacion;
        this.usuarios = usuarios;
    }
    
    /**
     * Constructor de la clase Presentaciones
     */
    public Presentaciones() {
    }

    /**
     * @return Identificador único de la clase.
     */
    public int getId() {
        return Id;
    }

    /**
     * @return Fecha en la cual se realiza la presentación.
     */
    public Timestamp getFechaPresentacion() {
        return FechaPresentacion;
    }

    /**
     * @param FechaPresentacion {@link Presentaciones#getFechaPresentacion() }
     */
    public void setFechaPresentacion(Timestamp FechaPresentacion) {
        this.FechaPresentacion = FechaPresentacion;
    }

    /**
     * @return Instancia de TipoDocumentacion {@link Models.Tipos.TipoDocumentacion}
     */
    public TipoDocumentacion getTipoDocumentacion() {
        return tipoDocumentacion;
    }

    /**
     * @param tipoDocumentacion {@link Presentaciones#getTipoDocumentacion() }
     */
    public void setTipoDocumentacion(TipoDocumentacion tipoDocumentacion) {
        this.tipoDocumentacion = tipoDocumentacion;
    }

    /**
     * @return Instancia de Usuarios {@link Models.Usuarios}
     */
    public Usuarios getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios {@link Presentaciones#getUsuarios() }
     */
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Presentaciones{" + "Id=" + Id + ", FechaPresentacion=" + FechaPresentacion + ", tipoDocumentacion=" + tipoDocumentacion + ", usuarios=" + usuarios + '}';
    }
    
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;
    
    @Column(name="fecha_presentacion")
    private Timestamp FechaPresentacion;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id")
    private TipoDocumentacion tipoDocumentacion;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id")
    private Usuarios usuarios;
}
