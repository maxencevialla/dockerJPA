package com.kronologia.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mvialla109 on 20/01/17.
 */
public class Client {

    public static List<Client> allClients = new ArrayList<>();
    public static Map<Integer, Client> mapClients = new HashMap<>();

    public static int currentId = 0;

    public String name;
    public int age;
    public int id;

    public Client(String name, int age) {
        this.id = currentId++;
        this.name = name;
        this.age = age;

        mapClients.put(this.id, this);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public static String getAllClients() {

        String result = "";

        for(Client c : mapClients.values()) {
            result += (c.toString() + "\n");
        }

        return result;
    }

    public static Client getByID(int id) {
        return mapClients.get(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
