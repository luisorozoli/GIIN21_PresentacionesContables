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
@Table(name="convocatoria")
public class Convocatorias {
    
    /**
     * Constructor de la clase Convocatoria
     * @param Nombre Nombre de la Convocatoria.
     * @param FechaApertura Fecha en la que se abrirá la Convocatoria {@link Timestamp}
     * @param FechaCierre Fecha de cierre de la Convocatoria {@link Timestamp}
     * @param EstadoApertura Estado de la Convocatoria {@link Boolean}
     * @param Documentacion {@link Models.Tipos.TipoDocumentacion}
     */
    public Convocatorias(String Nombre, Timestamp FechaApertura, Timestamp FechaCierre, boolean EstadoApertura, TipoDocumentacion Documentacion) {
        this.Nombre = Nombre;
        this.FechaApertura = FechaApertura;
        this.FechaCierre = FechaCierre;
        this.EstadoApertura = EstadoApertura;
        this.Documentacion = Documentacion;
    }
    
    /**
     * Constructor de la clase Convocatorias
     */
    public Convocatorias() {
    }

    /**
     * @return Identificador único de la clase.
     */
    public int getId() {
        return Id;
    }

    /**
     * @return Nombre de la Convocatoria.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre {@link Convocatorias#getNombre() }
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return Fecha en la que se abrirá la Convocatoria {@link Timestamp}
     */
    public Timestamp getFechaApertura() {
        return FechaApertura;
    }

    /**
     * @param FechaApertura {@link Convocatorias#getFechaApertura() }
     */
    public void setFechaApertura(Timestamp FechaApertura) {
        this.FechaApertura = FechaApertura;
    }

    /**
     * @return Fecha de cierre de la Convocatoria {@link Timestamp}
     */
    public Timestamp getFechaCierre() {
        return FechaCierre;
    }

    /**
     * @param FechaCierre {@link Convocatorias#getFechaCierre() }
     */
    public void setFechaCierre(Timestamp FechaCierre) {
        this.FechaCierre = FechaCierre;
    }

    /**
     * @return Estado de la Convocatoria {@link Boolean}
     */
    public boolean isEstadoApertura() {
        return EstadoApertura;
    }

    /**
     * @param EstadoApertura {@link Convocatorias#isEstadoApertura() }
     */
    public void setEstadoApertura(boolean EstadoApertura) {
        this.EstadoApertura = EstadoApertura;
    }

    /**
     * @return Instancia de {@link Models.Tipos.TipoDocumentacion}
     */
    public TipoDocumentacion getDocumentacion() {
        return Documentacion;
    }

    /**
     * @param Documentacion {@link Convocatorias#getDocumentacion() }
     */
    public void setDocumentacion(TipoDocumentacion Documentacion) {
        this.Documentacion = Documentacion;
    }

    @Override
    public String toString() {
        return "Convocatorias{" + "Id=" + Id + ", Nombre=" + Nombre + ", FechaApertura=" + FechaApertura + ", FechaCierre=" + FechaCierre + ", EstadoApertura=" + EstadoApertura + ", Documentacion=" + Documentacion + '}';
    }
    
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;
    
    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="Fecha_Apertura")
    private Timestamp FechaApertura;
    
    @Column(name="Fecha_Cierre")
    private Timestamp FechaCierre;
    
    @Column(name="Estado_Apertura")
    private boolean EstadoApertura;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="Id")
    private TipoDocumentacion Documentacion;
}
