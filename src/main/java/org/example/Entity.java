package org.example;

import java.util.HashMap;

public class Entity {
    //private static HashMap<String,Entity> entityHashMap = new HashMap<>();

    //private static void addEntity(String name,Entity entity){
    //    entityHashMap.put(name,entity);
    //}

    //public static Entity getEntity(String name){
    //    if(entityHashMap.containsKey(name))  return entityHashMap.get(name);
    //    return null;
    //}
    private String name;

    public Entity(String name){
        //addEntity(name,this);
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
