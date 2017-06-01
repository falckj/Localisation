package telecom_st_etienne.fr.myapplication;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;

import java.io.IOException;

import telecom_st_etienne.fr.myapplication.pathfinder.Dijkstra;

public class Localisation extends AppCompatActivity {
    //Dessin de la carte dans cette activité
    Draw view;

    // méthode pour récupérer la destination entrée par l'utilisateur dans la barre de recherche
    public String doMySearch(String key){
        return key;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            //Lancement du dessin de la carte
            view = new Draw(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //affichage du dessin
        setContentView(view);
        //Titre de l'activité qui sera affiché à l'écran
        setTitle("Carte du Bâtiment");




    }
    @Override
    //Méthode d'affichage de la barre de recherche lors d'un clic sur la loupe
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

}

