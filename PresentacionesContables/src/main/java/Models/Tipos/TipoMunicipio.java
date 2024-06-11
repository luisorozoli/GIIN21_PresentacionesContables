/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Tipos;

import javax.persistence.*;

/**
 * Esta clase sirve para definir los diferentes Tipos de Municipios en los que 
 * pueden ser clasificados cada uno de los Municipios.
 * @author rsilvente
 */
@Entity
@Table(name="tipo_municipio")
public class TipoMunicipio {

    /**
     * Constructor de la clase Tipo Municipio
     * @param Nombre Nombre del Tipo de Muniipio
     * @param Descipcion 
     */
    public TipoMunicipio(String Nombre, String Descipcion) {
        this.Nombre = Nombre;
        this.Descipcion = Descipcion;
    }
    
    public TipoMunicipio() {
    }

    /**
     * @return Identificador único de la clase.
     */
    public int getId() {
        return Id;
    }

    /**
     * @return Nombre del Tipo de Municipio
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre {@link TipoMunicipio#getNombre() }
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return Descripcion del Tipo de Municipio
     */
    public String getDescipcion() {
        return Descipcion;
    }

    /**
     * @param Descipcion {@link TipoMunicipio#getDescipcion() }
     */
    public void setDescipcion(String Descipcion) {
        this.Descipcion = Descipcion;
    }
    
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;
    
    @Column(name="Nombre")
    private String Nombre;
    
    @Column(name="Descripcion")
    private String Descipcion;
}
