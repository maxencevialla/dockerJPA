package com.kronologia.characters;

import javax.persistence.*;

/**
 * Created by maxence on 03/04/17.
 */
@Entity
@NamedQuery(name = "findAllChars", query = "SELECT c FROM MyCharacter c")
public class MyCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int level;

    public MyCharacter() {}

    public MyCharacter(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
