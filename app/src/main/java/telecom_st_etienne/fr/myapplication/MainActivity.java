package telecom_st_etienne.fr.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import telecom_st_etienne.fr.myapplication.pathfinder.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Localisation Axians");

        // Définition du rôle de chaque bouton de l'écran d'accueil

        Button connect = (Button) findViewById(R.id.buttonc);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });



        Button locate = (Button) findViewById(R.id.buttonp);
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Localisation.class);
                startActivity(intent);
            }
        });

        //Dijkstra dij = new Dijkstra();

    }
}
