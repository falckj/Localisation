package telecom_st_etienne.fr.myapplication;

/**
 * Created by Jeremy Falck on 03/05/2017.
 */
import android.app.Activity;
import android.bluetooth.BluetoothA2dp;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Draw extends View {
    private Paint paint;
    Bitmap test;


    public Draw(Context context) {
        super(context);
        test = BitmapFactory.decodeResource(getResources(), R.drawable.evacplan);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint = new Paint();
        paint.setColor(Color.MAGENTA);

        int x = 200;
        int y = 200;
        super.onDraw(canvas);
        canvas.drawBitmap(test, 0, 0, null);
        canvas.drawCircle(x, y, 20, paint);

        long starttime = 0;
        while (true) {
            long millis = System.currentTimeMillis() - starttime;
            if (millis >= 1000) {
                starttime = millis;
                invalidate();
                Bitmap bit = new Bitmap();
                canvas.drawBitmap(bit, 0, 0, Color.WHITE);
                canvas.drawCircle(x++, y++, 20, paint);
            }
        }
    }
}/*
        super.onDraw(canvas);
        canvas.drawBitmap(test, 0, 0, null);
        canvas.drawCircle(x+1, y+1, 20, paint);
    }

}
public class Draw extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    private AnimatedView mAnimatedView = null;

    Bitmap test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mAnimatedView = new AnimatedView(this);
        //Set our content to a view, not like the traditional setting to a layout
        setContentView(mAnimatedView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) { }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mAnimatedView.onSensorEvent(event);
        }
    }

    public class AnimatedView extends View {

        private static final int CIRCLE_RADIUS = 25; //pixels

        private Paint mPaint;
        private int x;
        private int y;
        private int viewWidth;
        private int viewHeight;

        public AnimatedView(Context context) {
            super(context);
            mPaint = new Paint();
            mPaint.setColor(Color.MAGENTA);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            viewWidth = w;
            viewHeight = h;
        }

        public void onSensorEvent (SensorEvent event) {
            x = x - (int) event.values[0];
            y = y + (int) event.values[1];
            //Make sure we do not draw outside the bounds of the view.
            //So the max values we can draw to are the bounds + the size of the circle
            if (x <= 0 + CIRCLE_RADIUS) {
                x = 0 + CIRCLE_RADIUS;
            }
            if (x >= viewWidth - CIRCLE_RADIUS) {
                x = viewWidth - CIRCLE_RADIUS;
            }
            if (y <= 0 + CIRCLE_RADIUS) {
                y = 0 + CIRCLE_RADIUS;
            }
            if (y >= viewHeight - CIRCLE_RADIUS) {
                y = viewHeight - CIRCLE_RADIUS;
            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawCircle(x, y, CIRCLE_RADIUS, mPaint);
            //We need to call invalidate each time, so that the view continuously draws
            invalidate();
        }
    }
}*/