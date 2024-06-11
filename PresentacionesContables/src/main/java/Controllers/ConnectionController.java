/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;

/**
 * Esta clase define y configura el método de conexión con la base de datos 
 * usada para la aplicación.
 * @author rsilvente
 */
public class ConnectionController {
    
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch(HibernateException e) {
            System.err.println(e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
     * 
     * @return Devuelve el objeto SessionFactory mediante el cual se pueden 
     * realizar consultas a la base de datos del sistema.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
