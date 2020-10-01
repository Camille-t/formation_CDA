package com.camille.mondeafpa;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // déclaration des variables (référencement des éléments graphiques)
    private EditText mNumberOfFacesInput;
    private Button mRollButton;

    public static final String EXTRA_MESSAGE = "com.camille.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) { // méthode onCreate() appelée lorsque l'activité est créée
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // méthode setContentView() permet de déterminer quel fichier layout utiliser
        // Classe R (pour Resources) générée lors de la compilation du projet par Android Studio et qui contient l'ensemble des identifiants de toutes les ressources du projet

        // référencement des éléments graphiques (branchement)
        mNumberOfFacesInput = (EditText) findViewById(R.id.activity_main_faces_input); // findViewById renvoie la Vue correspondante que l'on caste (conversion vers le bon type)
        mRollButton = (Button) findViewById(R.id.activity_main_roll_btn);

        // Une fois le bouton de lancement du dé activé, l'utilisateur peut cliquer dessus
        // Pour détecter que l'utilisateur a cliqué sur le bouton, on implémente un listener avec la méthode setOnClickListener() sur l'objet mRollButton
        // puis on implémente l'interface OnClickListener de la méthode View
        mRollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // méthode appelée chaque fois que l'utilisateur appuie sur le bouton
                Intent intent = new Intent(MainActivity.this, DisplayNumberActivity.class);
                Bundle b = new Bundle();
                b.putInt("nbOfFaces", Integer.parseInt(mNumberOfFacesInput.getText().toString()));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
