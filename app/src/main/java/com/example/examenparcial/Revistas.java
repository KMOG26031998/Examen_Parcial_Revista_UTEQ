package com.example.examenparcial;

import android.media.audiofx.AudioEffect;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revistas {

    private String description;
    private String portada;
    private  String name;
    public Revistas() {
    }
    public Revistas(String description,String portada,String name){
        this.description= description;
        this.portada=portada;
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public void setName(String Name) {
        this.name = Name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String Description) {
        this.description = Description;
    }
    public String getPortada() {
        return portada;
    }
    public void setPortada(String Portada) {
        this.portada= Portada;
    }
    public Revistas(JSONObject item) throws JSONException {
        name= item.getString("name");
        description= item.getString("description");
        portada= item.getString("portada");
    }
    public static ArrayList<Revistas> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revistas> revistasList = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            revistasList.add(new Revistas(datos.getJSONObject(i)));
        }
        return revistasList;
    }
}
