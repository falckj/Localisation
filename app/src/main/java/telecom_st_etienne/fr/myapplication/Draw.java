package telecom_st_etienne.fr.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import telecom_st_etienne.fr.myapplication.UsefulMethods.Point;
import telecom_st_etienne.fr.myapplication.UserTracking.Test;

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
    private int X=50;
    private int Y=500;
    private int speedX = 10;
    private int speedY = 10;
    private int i=0;
    private int positionX;
    private int positionY;
    public Bitmap test;
    //private Paint paint; // Создай его где-нибудь там в конструкторе


    public Draw(Context context) throws IOException {
        super(context);
        p = new Paint();
        p.setColor(Color.BLUE);
        test = BitmapFactory.decodeResource(getResources(), R.drawable.plan_ecole);
        //Test test = new Test(context);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        centerX = w / 2;
        centerY = h / 2;

    }

    protected void onDraw(Canvas c) {
       /* List<String> text = new ArrayList<String>();
        text.add("test1");
        text.add("test2");*/


        int w = getWidth();
        int h = getHeight();
        X++;
        Y--;
        centerX += speedX; //centerX = positionX
        centerY += speedY; //centerY = positionY
        int rightLimit = w - RADIUS;
        int bottomLimit = h - RADIUS;
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
        /*Paint paint3 = new Paint();
        paint3.setColor(Color.RED);
        paint3.setTextSize(100);*/
        //c.drawBitmap(test, 0, 0, null);
        c.drawBitmap(test, null, dest, paint2);
        c.drawCircle(X, Y, RADIUS, p);
        //c.drawText(text.get(i++%2), centerX-70, centerY, paint3);

        postInvalidateDelayed(50);

    }



}
