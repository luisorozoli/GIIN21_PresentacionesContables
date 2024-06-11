/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Convocatorias;
import Interfaces.ICRUD;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase mediante la que realizaremos las operaciones CRUD a la tabla de las 
 * Convocatorias.
 * @author rsilvente
 */
public class ConvocatoriasDAO implements ICRUD<Convocatorias> {

    /**
     * Metodo con el cual generamos una nueva Convocatoria en la Base de Datos.
     * @param element Instancia de la clase Convocatorias.
     */
    @Override
    public void addElemet(Convocatorias element) {
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
     * Metodo con el cual Actualizamos una Convocatoria en la Base de Datos.
     * @param element Instancia de la clase Convocatorias.
     */
    @Override
    public void updateElement(Convocatorias element) {
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
     * Método mediante el cual eliminaremos una Convocatoria de la Base de 
     * Datos.
     * @param id Identificador de la Convocatoria seleccionada.
     */
    @Override
    public void deleteElement(int id) {
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try{
            trns = session.getTransaction();
            Convocatorias convocatoria = (Convocatorias) session.load(Convocatorias.class, id);
            session.delete(convocatoria);
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
     * Método con el que obtenemos un listado de las Convocatorias presentes 
     * en la Base de Datos.
     * @return Listado de las Convocatorias presentes en la Base de Datos.
     */
    @Override
    public List<Convocatorias> getAllElements() {
        List<Convocatorias> convocatorias = new ArrayList<Convocatorias>();
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try {
            trns = session.getTransaction();
            convocatorias = session.createQuery("from Convocatorias").list();
        } catch(RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return convocatorias;
    }

    /**
     * Método con el que obtendremos los datos de una Convocatoria en concreto.
     * @param id Identificador único de la Convocatoria que queremos obtener.
     * @return Devuelve la COnvocatoria cuyo ID coincide con el ID indicado 
     * como parámetro de entrada.
     */
    @Override
    public Convocatorias getElementById(int id) {
        Convocatorias convocatoria = null;
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try {
            trns = session.getTransaction();
            String queryString = "from Municipios where id = :Id";
            Query query = session.createQuery(queryString);
            query.setInteger("Id", id);
            convocatoria = (Convocatorias) query.uniqueResult();
        }catch(RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return convocatoria;
    }
    
    /**
     * Obtenemos el Id de una Convocatoria por su Nombre
     * @param nombre Nombre de la Convocatoria
     * @return Devuelve el identificador (ID) de la Convocatoria.
     */
    public int getElementIdByNombre(String nombre) {
        int convocatoria = 0;
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        
        try {
            trns = session.getTransaction();
            String queryString = "from Municipios where Nombre = :nombre";
            Query query = session.createQuery(queryString);
            query.setString("nombre", nombre);
            convocatoria = (int) query.uniqueResult();
        }catch(RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return convocatoria;
    }

}
