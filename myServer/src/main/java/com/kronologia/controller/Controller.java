package com.kronologia.resources.controller;

import com.kronologia.DatabaseManager;
import com.kronologia.characters.MyCharacter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by maxence on 03/04/17.
 *
 * Manages the persistence of the entity T
 */
public class Controller {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public Controller(){
        this.emf = Persistence.createEntityManagerFactory("jdbc");
        this.em = emf.createEntityManager();
    }

}