package telecom_st_etienne.fr.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import telecom_st_etienne.fr.myapplication.pathfinder.*;

public class MainActivity extends AppCompatActivity {

    //Activité sur laquelle tombe l'utilisateur au lancement de l'application

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Affiche à l'écran les composantes définies dans activity_main.xml
        setContentView(R.layout.activity_main);
        //Titre affiché à l'écran de l'appareil
        setTitle("Localisation Axians");


        // Définition du rôle de chaque bouton de l'écran d'accueil

        //Redirection vers l'activité d'authentification
        Button connect = (Button) findViewById(R.id.buttonc);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        //Redirection vers l'activité de localisation
        Button locate = (Button) findViewById(R.id.buttonp);
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Localisation.class);
                startActivity(intent);
            }
        });
    }
}
