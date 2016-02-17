package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
 
	/**
	 * gets location of windows chromedriver property from prop file
	 * @return
	 */
	public String getWinChromedriver(){
		String driverLoc = null;
		try {
			driverLoc = getProperty("chromedriverWinLocation");
		} catch (IOException e) {
			throw new IllegalStateException("settings.properties did not contain windows chromedrivervalue");
		}
		return driverLoc;
	}

	/**
	 * gets location of windows chromedriver property from prop file
	 * @return
	 */
	public String getMacChromedriver(){
		String driverLoc = null;
		try {
			driverLoc = getProperty("chromedriverMacLocation");
		} catch (IOException e) {
			throw new IllegalStateException("settings.properties did not contain mac chromedrivervalue");
		}
		return driverLoc;
	}

	/**
	 * gets specified setting from the settings.properties file and returns the value
	 * in a String
	 * @param setting
	 * @return
	 * @throws IOException
	 */
	public String getProperty(String setting) throws IOException {
		String settingValue = null;
		InputStream inputStream = null;
		
		try {
			Properties prop = new Properties();
			String propFileName = "settings.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			settingValue = prop.getProperty(setting);
		} finally {
			inputStream.close();
		}
		return settingValue;
	}

}
