package com.kronologia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

/**
 * Created by maxence on 03/04/17.
 *
 * Manages the persistence of the entity T
 */
public abstract class myCRUD<T> {

    protected EntityManager em;

    public myCRUD() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
        em = emf.createEntityManager();
    }

    public T create(T object) {
        this.em.persist(object);

        this.em.flush();
        this.em.refresh(object);

        return object;
    }
}
