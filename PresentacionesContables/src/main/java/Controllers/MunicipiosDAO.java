/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.ICRUD;
import Models.Municipios;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase mediante la que realizamos las operaciones de CRUD a la tabla de los
 * Municipios
 * @author rsilvente
 */
public class MunicipiosDAO implements ICRUD<Municipios> {

    /**
     * Método con el cual generamos un nuevo Municipio en la Base de Datos
     * @param element Instancia de la clase Municipio.
     */
    @Override
    public void addElemet(Municipios element) {
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.save(element);
            session.getTransaction().commit();
        }catch(RuntimeException e){
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        
    }

    /**
     * Método con el cual Actualizamos un Municipio en la Base de Datos.
     * @param element Instancia de la clase Municipio.
     */
    @Override
    public void updateElement(Municipios element) {
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try{
            trns = session.getTransaction();
            session.update(element);
            session.getTransaction().commit();
        } catch(RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    /**
     * Método mediante el cual Eliminaremos un Municipio de la Base de Datos.
     * @param id Identificador del Municipio seleccionado.
     */
    @Override
    public void deleteElement(int id) {
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try{
            trns = session.getTransaction();
            Municipios municipio = (Municipios) session.load(Municipios.class, id);
            session.delete(municipio);
            session.getTransaction().commit();
        } catch(RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    /**
     * Método con el que obtenemos un listado de los Municipios presentes 
     * en la Base de Datos.
     * @return Listado de los Municipios presentes en la Base de Datos.
     */
    @Override
    public List<Municipios> getAllElements() {
        List<Municipios> municipios = new ArrayList<Municipios>();
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try {
            trns = session.getTransaction();
            municipios = session.createQuery("from Municipios").list();
        } catch(RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return municipios;
    }

    /**
     * Método con el que obtendremos los datos de un Municipio en concreto.
     * @param id Identificador único del Muncipio que queremos obtener.
     * @return Devuelve el Municipio cuyo ID coincide con el ID indicado 
     * como parámetro de entrada.
     */
    @Override
    public Municipios getElementById(int id) {
        Municipios municipio = null;
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try {
            trns = session.getTransaction();
            String queryString = "from Municipios where id = :Id";
            Query query = session.createQuery(queryString);
            query.setInteger("Id", id);
            municipio = (Municipios) query.uniqueResult();
        }catch(RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return municipio;
    }
    
}
