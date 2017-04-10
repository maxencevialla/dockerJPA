package com.kronologia.resources.controller;

import com.kronologia.characters.MyCharacter;

import javax.persistence.EntityTransaction;

/**
 * Created by maxence on 09/04/17.
 */
public class CharacterController extends Controller {

    public CharacterController() {
        super();
    }

    public void addCharacter(MyCharacter c) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(c);
        transaction.commit();
    }
}
