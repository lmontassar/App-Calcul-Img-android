package com.example.lab01.vue;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab01.R;
import com.example.lab01.controller.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        this.controle= com.example.lab01.controller.Controle.getInstance(this);
    }
    private void recupProfil(){
        if(controle.getPoids() != null ) {
            txtPoids.setText(controle.getPoids());
            txtTaille.setText(controle.getTaille());
            txtAge.setText(controle.getAge());
            rdFemme.setChecked(true);
            if(controle.getSexe() == 1){
                rdHomme.setChecked(true);
            }
            ((Button)findViewById(R.id.btnCalc)).performClick();
        }
    }
    /**
     * initialisation des liens avec les objets graphiques
     */
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private RadioButton rdFemme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Controle controle;
    private void init() {
        txtPoids    = (EditText) findViewById(R.id.txtPoids);
        txtTaille   = (EditText)findViewById(R.id.txtTaille);
        txtAge      = (EditText) findViewById(R.id.txtAge);
        rdHomme     = (RadioButton)findViewById(R.id.rdHomme);
        rdFemme     = (RadioButton) findViewById(R.id.rdFemme);
        lblIMG      = (TextView)findViewById(R.id.lblIMG);
        imgSmiley   = (ImageView) findViewById(R.id.imgSmiley);
        this.controle= com.example.lab01.controller.Controle.getInstance(this);
        ecouteCalcul();
        recupProfil();
    }
    /**
     * Ecoute événement sur bouton Calcul
     */
    private void ecouteCalcul() {
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // Initialize variables
                Integer poids = null;
                Integer taille = null;
                Integer age = null;
                Integer sexe = 0;


                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Veuillez saisir des valeurs numériques valides", Toast.LENGTH_SHORT).show();
                    return; // Stop further execution if parsing fails
                }

                if (rdHomme.isChecked()) {
                    sexe = 1;
                }
                if (poids == null || taille == null || age == null || poids <= 0 || taille <= 0 || age <= 0) {

                    Toast.makeText(MainActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                } else {
                    afficheResult(poids, taille, age, sexe);
                }
            }
        });
    }


    /**
     * Affichage de l'IMG du message et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private void afficheResult(Integer poids, Integer taille, Integer age, Integer sexe){
        // création du profit et récupération des informations
        this.controle.creerProfil(poids, taille,age, sexe,this);
        float img = this.controle.getImg();
        String message = this.controle.getMessage();
        if(message.equals("normal") ) {
            imgSmiley.setImageResource(R.drawable.normal);
            lblIMG.setTextColor(Color.GREEN);
        }
        else if(message.equals("trop élevé") ){
            imgSmiley.setImageResource(R.drawable.graisse);
            lblIMG.setTextColor(Color.RED);
        }
        else{
            imgSmiley.setImageResource(R.drawable.maigre);
            lblIMG.setTextColor(Color.RED);
        }
        lblIMG.setText(String.format("%.01f",img)+" : IMG "+message);
    }
}