package allocator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class properties {

	public static String Getproperties(String Key) throws IOException {

		Properties prop = new Properties();
		FileInputStream obj = new FileInputStream(System.getProperty("user.dir") + "\\settings.properties");
		prop.load(obj);

		String value = prop.getProperty(Key);
		return value;

	}

}
