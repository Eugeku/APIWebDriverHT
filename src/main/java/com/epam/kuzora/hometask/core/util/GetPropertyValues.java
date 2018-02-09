package com.epam.kuzora.hometask.core.util;

import java.io.*;
import java.util.Properties;

public class GetPropertyValues {

    public String getPropValues(String propertyName, String propFileName) {
        String result = "";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            Properties prop = new Properties();

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty(propertyName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public double getPropertyDouble(String propertyName, String propFileName) {
        double result = 0;
        try {
            result = Double.parseDouble(getPropValues(propertyName, propFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
