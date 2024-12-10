package com.example.lab01.model;

import java.io.Serializable;

public class Profil implements Serializable {
    private static final Integer minFemme = 15;
    private static final Integer maxFemme = 30;
    private static final Integer minHomme = 10;
    private static final Integer maxHomme = 15;

    private int poids;
    private int taille;
    private int age;
    private int sexe;
    private float img;
    private String message;

    public Profil(int poids, int taille, int age, int sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        calculIMG();
        resultIMG();
    }
    public void calculIMG(){
        float tailleM = ((float)taille)/100;
        this.img = (float) ( 1.2*((poids) / (tailleM*tailleM)) + (0.23*age) - (10.83*sexe) - 5.4);
    }
    public void resultIMG(){
        Integer min;
        Integer max;
        if(sexe == 0){
            min = minFemme;
            max = maxFemme;
        } else {
            min = minHomme;
            max = maxHomme;
        }
        message =   (img<min) ? "trop faible":
                    (img>max) ? "trop élevé" :
                                "normal"
                ;

    }
    public void setPoids(int poids) {
        this.poids = poids;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public void setImg(float img) {
        this.img = img;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPoids() {
        return poids;
    }

    public int getTaille() {
        return taille;
    }

    public int getAge() {
        return age;
    }

    public int getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }
}
