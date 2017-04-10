package com.kronologia.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

/**
 * Created by maxence on 03/04/17.
 *
 * Manages the persistence of the entity T
 */
public class Controller {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public Controller(){
        this.emf = Persistence.createEntityManagerFactory("jdbc"); //For docker
        //this.emf = Persistence.createEntityManagerFactory("h2");
        this.em = emf.createEntityManager();
    }

}