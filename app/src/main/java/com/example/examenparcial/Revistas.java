package com.example.examenparcial;

import android.media.audiofx.AudioEffect;

public class Revistas {
    private int id;
    private String description;
    private String portada;
    private  String name;

    public Revistas(String description,String portada,String name){
        this.description= description;
        this.portada=portada;
        this.name=name;
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
    public void setName(String Name) {

        name = Name;
    }
    public String getDescription() {

        return description;
    }
    public void setDescription(String Description) {
        description = Description;
    }
    public String getPortada() {
        return portada;
    }
    public void setPortada(String Portada) {
        portada= Portada;
    }
}
