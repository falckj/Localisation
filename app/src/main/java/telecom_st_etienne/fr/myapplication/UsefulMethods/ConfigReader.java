package telecom_st_etienne.fr.myapplication.UsefulMethods;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.ini4j.*;

import telecom_st_etienne.fr.myapplication.R;

public class ConfigReader {

	public static Ini readConfig(String string) throws InvalidFileFormatException, FileNotFoundException, IOException{
		
		Ini config = new Ini(new FileReader(new File(string)));
		
		return config;
	}
}
