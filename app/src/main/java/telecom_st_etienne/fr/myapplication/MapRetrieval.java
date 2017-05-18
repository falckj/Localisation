package telecom_st_etienne.fr.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;



import static android.content.ContentValues.TAG;

public class MapRetrieval extends BaseClass{

	public static void main(String[] args) {
		try {
			config = ConfigReader.readConfig("./configs/config3.ini");
		} catch (Exception e) {
			System.err.println("Erreur lors de l'ouverture du fichier.");
		} 
		
		setVariables();
		
		String url = url_prefix + mse_ip + url_suffix;
		HTTPMethods.SSLHandler();
		try {
			
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		HTTPMethods.setMapHeaders(connection, url, charset, authentication);
		
		URL url_ = new URL("https://www.w3schools.com/css/paris.jpg");
		//URLImageSource img = (URLImageSource) connection.getContent();
		InputStream input = connection.getInputStream();
		Bitmap myBitmap = BitmapFactory.decodeStream(input);
		//BufferedImage image = ImageIO.read(url_);
		//ImageIO.write(image, "jpg",new File("./img.jpg"));
		String root = Environment.getExternalStorageDirectory().toString();
		File myDir = new File(root + "/req_images");
		myDir.mkdirs();
		Random generator = new Random();
		int n = 10000;
		n = generator.nextInt(n);
		String fname = "Image-" + n + ".jpg";
		File file = new File(myDir, fname);
		Log.i(TAG, "" + file);
		if (file.exists())
			file.delete();
		try {
			FileOutputStream out = new FileOutputStream(file);
			myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	System.out.println(connection.getURL());
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


        //sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
	}


}