package telecom_st_etienne.fr.myapplication.UserTracking;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import telecom_st_etienne.fr.myapplication.R;
import telecom_st_etienne.fr.myapplication.UsefulMethods.BaseClass;
import telecom_st_etienne.fr.myapplication.UsefulMethods.ConfigReader;
import telecom_st_etienne.fr.myapplication.UsefulMethods.Point;

public class SingleUser extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {

		try {

			config = ConfigReader.readConfig("R.raw.config3");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erreur lors de l'ouverture du fichier.");
		}

		setVariables("R.raw.config3");

		String url = url_prefix+mse_ip+url_suffix+mac;

			while(true){
			System.out.println(getInformation(url,UserOptions.locate));
			//TimeUnit.MILLISECONDS.sleep(1500);
		}
	}


}
