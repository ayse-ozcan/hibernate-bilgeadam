package com.ayseozcan.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private static final SessionFactory FACTORY;

    static
    {
        try
        {
            /*
           * default olarak -> src/main/resources/hibernate.cfg.xml
             */
            FACTORY = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            throw e;
        }
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
