package telecom_st_etienne.fr.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.location.Criteria;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import telecom_st_etienne.fr.myapplication.UsefulMethods.Point;

/**
 * Created by Jeremy Falck on 03/05/2017.
 */
class Draw extends View {
    //public    Paint c;
    public  Paint p;
    public Point position;

    private static final int RADIUS = 30;

    private int centerX;
    private int centerY;
    //private int X = (int) position.getX();
    //private int Y = (int) position.getY();
    // Position (X,Y) donnée par le CMX et récupérée par la classe SingleUser
    private int X=50;
    private int Y=500;
    private int speedX = 10;
    private int speedY = 10;
    private int i=0;
    private int positionX;
    private int positionY;
    public Bitmap test;


    //private Paint paint; // Создай его где-нибудь там в конструкторе
    //TODO Mettre à l'échelle les coordonnées du point par rapport aux dimensions de l'image affdfichée sur le téléphone.


    public Draw(Context context) throws IOException {
        super(context);
        //Couleur du cercle de la position
        p = new Paint();
        p.setColor(Color.BLUE);
        //importation de l'image plan_ecole.png
        test = BitmapFactory.decodeResource(getResources(), R.drawable.plan_ecole);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        centerX = w / 2;
        centerY = h / 2;

    }

    protected void onDraw(Canvas c) {



        int w = getWidth();
        int h = getHeight();
        //Test d'évolution des coordonnées pour un affichage dynamique
        X++;
        Y--;
        //TODO Récupérer des nouvelles coordonnées sur le CMX pour faire changer la position du point
        //centerX += speedX; //centerX = positionX
        //centerY += speedY; //centerY = positionY
        //int rightLimit = w - RADIUS;
        //int bottomLimit = h - RADIUS;
        /*
        if (centerX >= rightLimit) {
            centerX = rightLimit;
            speedX *= -1;
        }
        if (centerX <= RADIUS) {
            centerX = RADIUS;
            speedX *= -1;
        }
        if (centerY >= bottomLimit) {
            centerY = bottomLimit;
            speedY *= -1;
        }
        if (centerY <= RADIUS) {
            centerY = RADIUS;
            speedY *= -1;
        }*/
        Rect dest = new Rect(0, 0, getWidth(), getHeight());
        Paint paint2 = new Paint();
        paint2.setFilterBitmap(true);

        //dessin du plan
        c.drawBitmap(test, null, dest, paint2);
        //dessin du cercle traduisant la position
        c.drawCircle(X, Y, RADIUS, p);

        postInvalidateDelayed(50);

    }



}
