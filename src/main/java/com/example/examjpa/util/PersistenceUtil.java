package com.example.examjpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    static EntityManagerFactory entityManagerFactory;
    public static EntityManagerFactory getEntityManagerFactory() {
        try {
            if (entityManagerFactory == null) {
                entityManagerFactory = Persistence.createEntityManagerFactory("examjpa");
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return entityManagerFactory;
    }
}
