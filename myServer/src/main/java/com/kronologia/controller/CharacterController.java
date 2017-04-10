package com.kronologia.controller;

import com.kronologia.characters.MyCharacter;
import com.kronologia.controller.Controller;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by maxence on 09/04/17.
 */
public class CharacterController extends Controller {

    public CharacterController() {
        super();
    }

    public List getCharacters() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<MyCharacter> query = em.createNamedQuery("findAllChars", MyCharacter.class);
        List<MyCharacter> dogs = query.getResultList();
        return dogs;
    }

    public void addCharacter(MyCharacter c) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(c);
        transaction.commit();
    }

    public MyCharacter getCharacter(int id) {
        MyCharacter c = em.find(MyCharacter.class, id);
        return c;
    }

    public MyCharacter levelup(int id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        MyCharacter c = em.find(MyCharacter.class, id);
        c.setLevel(c.getLevel()+1);
        em.merge(c);
        transaction.commit();
        return c;
    }
}
