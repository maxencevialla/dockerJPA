package fr.kronologia.myclient;
/**
 * Created by maxence on 03/04/17.
 */
public class MyCharacter {

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
