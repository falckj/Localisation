package telecom_st_etienne.fr.myapplication.UserTracking;
import android.annotation.TargetApi;
import android.os.Build;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;


import telecom_st_etienne.fr.myapplication.UsefulMethods.*;

public class Test extends BaseClass {
	
	@TargetApi(Build.VERSION_CODES.KITKAT)

	public static void main(String[] args){
		try {
			config = ConfigReader.readConfig("./configs/config2.ini");
		} catch (Exception e) {
			System.err.println("Erreur lors de l'ouverture du fichier.");
		} 
		setVariables();
		
		JSONObject json = getResponse(url_prefix + mse_ip + url_suffix + mac);
		/*Iterator<String> keys = json.keys();
		Iterator<String> json_sorted_keys = (Iterator<String>) new TreeSet<String>(keys.next());
        while (keys.hasNext()){
            json_sorted_keys.add(keys);
        }
		try(FileWriter fw = new FileWriter("test.txt")){
			while(json_sorted_keys.hasNext()){
				fw.write(json_sorted_keys.next().toString() + "\n");
			}
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	*/
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
