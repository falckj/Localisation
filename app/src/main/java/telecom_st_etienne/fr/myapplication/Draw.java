package telecom_st_etienne.fr.myapplication;

/**
 * Created by Jeremy Falck on 03/05/2017.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.view.View;
import android.widget.ImageView;

public class Draw extends View{
    private Paint paint;

    public Draw(Context context) {
        super(context);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        BitmapFactory.Options myOptions = new BitmapFactory.Options();
        myOptions.inDither = true;
        myOptions.inScaled = false;
        myOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;// important
        myOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.photo_android,myOptions);
        Bitmap workingBitmap = Bitmap.createBitmap(bitmap);
        Bitmap mutableBitmap = workingBitmap.copy(Bitmap.Config.ARGB_8888, true);


/*
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.photo_android);
        iv.setAdjustViewBounds(true);
        iv.setImageBitmap(mutableBitmap);*/
        canvas.drawPicture(R.drawable.photo_android);
        canvas.drawCircle(200, 200, 20, paint);
    }
}
