/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.ICRUD;
import Models.Presentaciones;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase mediante la que realizamos las operaciones de CRUD a la tabla de las 
 * Presentaciones.
 * @author rsilvente
 */
public class PresentacionesDAO implements ICRUD<Presentaciones>{

    /**
     * Método con el cual generamos una nueva Presentacion en la Base de Datos.
     * @param element Instancia de la clase Presentacion
     */
    @Override
    public void addElemet(Presentaciones element) {
       Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(element);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
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
     * Método con el cual Actualizamos una Presentacion en la Base de Datos.
     * @param element Instancia de la clase Presentacion.
     */
    @Override
    public void updateElement(Presentaciones element) {
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();

        try {
            trns = session.getTransaction();
            session.update(element);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
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
     * Método mediante el cual Eliminaremos una Presentacion de la Base de 
     * Datos.
     * @param id Identificador de la Presentacion seleccionada.
     */
    @Override
    public void deleteElement(int id) {
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try{
            trns = session.getTransaction();
            Presentaciones presentacion = (Presentaciones) session.load(Presentaciones.class, id);
            session.delete(presentacion);
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
     * Método con el que obtendremos un listado de las Presentaciones presentes 
     * en la Base de Datos.
     * @return Listado de las Presentaciones presentes en la Base de Datos.
     */
    @Override
    public List<Presentaciones> getAllElements() {
        List<Presentaciones> presentaciones = new ArrayList<Presentaciones>();
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try {
            trns = session.getTransaction();
            presentaciones = session.createQuery("from Presentaciones").list();
        } catch(RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return presentaciones;
    }

    /**
     * Método con el que obtendremos los datos de una Presentación en concreto.
     * @param id Identificador único de la Presentación que queremos obtener.
     * @return Devuelve la Presentación cuyo ID coincide con el ID indicado 
     * como parámetro de entrada.
     */
    @Override
    public Presentaciones getElementById(int id) {
        Presentaciones presentacion = null;
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try {
            trns = session.getTransaction();
            String queryString = "from Municipios where id = :Id";
            Query query = session.createQuery(queryString);
            query.setInteger("Id", id);
            presentacion = (Presentaciones) query.uniqueResult();
        }catch(RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return presentacion;
    }
    
}
