/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.ICRUD;
import Models.Usuarios;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 *
 * @author rsilvente
 */
public class UsuariosDAO implements ICRUD<Usuarios> {

    /**
     * Método con el cual generamos un nuevo Usuario en la Base de Datos.
     * @param element 
     */
    @Override
    public void addElemet(Usuarios element) {
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.save(element);
            session.getTransaction().commit();
        }catch(RuntimeException e) {
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
     * Método con el cual Actualizamos un Usuario en la Base de Datos.
     * @param element Instancia de la clase Usuario.
     */
    @Override
    public void updateElement(Usuarios element) {
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.update(element);
            session.getTransaction().commit();
        }catch(RuntimeException e){
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();            
        }finally{
            session.flush();
            session.close();
        }
    }

    /**
     * Mëtodo mediante el cual Eliminaremos un Usuario de la Base de Datos.
     * @param id Identidicador del Usuario seleccionado.
     */
    @Override
    public void deleteElement(int id) {
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            Usuarios usuario = (Usuarios) session.load(Usuarios.class, id);
            session.delete(usuario);
            session.getTransaction().commit();
        }catch(RuntimeException e){
            if (trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
    }
    
    /**
     * Método con el que obtenemos un listado de los Usuarios presentes 
     * en la Base de Datos.
     * @return Listado de los Usuarios presentes en la Base de Datos.
     */
    @Override
    public List<Usuarios> getAllElements() {
        List<Usuarios> usuarios = new ArrayList<Usuarios>();
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            usuarios = session.createQuery("from Usuarios").list();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return usuarios;
    }

    /**
     * Método con el que obtendremos los datos de un Usuario en concreto.
     * @param id Identificador únmico del Usuario que queremos obtener.
     * @return Devuelve el Usuario cuyo ID coincide con el ID indicado
     * como parámetro de entrada.
     */
    @Override
    public Usuarios getElementById(int id) {
        Usuarios usuario = null;
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from Usuarios where id = :Id";
            Query query = session.createQuery(queryString);
            query.setInteger("Id", id);
            usuario = (Usuarios) query.uniqueResult();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return usuario;
    }

    /**
     * Método con el cual obtenemos los datos de un Usuario en función del 
     * Nombre.
     * @param username Nombre del Usuario.
     * @return Devuelve una instancia del Usuario buscado.
     */
    public static Usuarios getElementByUsername(String username) {
        
        Usuarios usuario = null;
        Transaction trns = null;
        Session session = ConnectionController.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from Usuarios where Nombre = :Nombre";
            Query query = session.createQuery(queryString);
            query.setString("Nombre", username);
            usuario = (Usuarios) query.uniqueResult();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return usuario;
    }

}
