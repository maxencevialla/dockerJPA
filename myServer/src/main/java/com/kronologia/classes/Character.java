package com.kronologia.classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxence on 03/04/17.
 */
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int level;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Item> items;

    public Character() {}

    public static Character createCharacter(String name) {
        Character c = new Character();
        c.setName(name);
        c.setLevel(1);
        c.setItems(new ArrayList<Item>());

        return c;
    }

    //Return the character identified by ID
    public static Character getCharacterByID(int id) {
        Character c = createCharacter("Paul");
        return c;
    }

    public static String getAllCharacters() {
        return "GetAllCharacters";
    }

    //Add the item to the current character
    public void addItem(Item i) {
        this.items.add(i);
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
