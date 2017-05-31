package telecom_st_etienne.fr.myapplication.UserTracking;
import android.content.Context;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.TreeSet;


import telecom_st_etienne.fr.myapplication.UsefulMethods.*;



public class Test extends BaseClass {
	
	private Context mContext;

	public static void main(String[] args){// Test(Context context) throws IOException {
        //this.mContext = context;
        //InputStream is = mContext.getAssets().open("raw/config2.ini");
		try {
			config = ConfigReader.readConfig("R.raw.config2.ini");
		} catch (Exception e) {
			System.err.println("Erreur lors de l'ouverture du fichier.");
		} 
		setVariables("location");

		JSONObject json = getResponse(url_prefix + mse_ip + url_suffix + mac);

        TreeSet<String> sorted = new TreeSet<String>();
        Iterator<String> it = json.keys();

        while (it.hasNext()) {
            sorted.add(it.next());
        }
        Iterator<String> it2 = sorted.iterator();
            try(FileWriter fw = new FileWriter("test.txt")){
                while(it2.hasNext()){
                    fw.write(it2.next().toString() + "\n");
                }
                fw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
    }

}
