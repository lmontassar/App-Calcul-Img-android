package com.example.lab01.controller;
import android.content.Context;

import com.example.lab01.model.Profil;
import com.example.lab01.outils.Serializer;

/**
 * created by montassar on 21/01/2018.
 */
public final class Controle {
    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic="saveprofile";
    /**
     * Constructeur private
     */
    private Controle(){
        super();
    }
    /**
     * Création de l'instance
     * @return
     */
    public static final Controle getInstance(Context context){
        if(Controle.instance == null) {
            Controle.instance = new Controle();
            recupSerialize(context);
        }
        return Controle.instance;
    }
    private static void recupSerialize(Context context){
        profil = (Profil) Serializer.deSerialize(nomFic,context);
    }

    /**
     * Création du profil
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public void creerProfil(Integer poids, Integer taille, Integer age,Integer sexe,Context context){
        profil = new Profil(poids,taille,age,sexe);
        Serializer.serialize(nomFic,profil,context);
    }

    /**
     * recuparation img de profil
     * @return l'image
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * recupération message du pofil
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }

    public Integer getPoids() {
        if(profil == null){
            return null;
        } else {
            return profil.getPoids();
        }
    }
    public Integer getTaille() {
        if(profil == null){
            return null;
        } else {
            return profil.getTaille();
        }
    }
    public Integer getAge() {
        if(profil == null){
            return null;
        } else {
            return profil.getAge();
        }
    }
    public Integer getSexe() {
        if(profil == null){
            return null;
        } else {
            return profil.getSexe();
        }
    }


}