package com.umesh.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Config {

    static Logger logger= LoggerFactory.getLogger(Config.class);
    private static final String DEFAULT_PROPERTY="config/default.properties";
    private static Properties properties;

    public static void initialize(){

        //load default properties
        properties=getProperties();

        //check for override properties
       for(String key: properties.stringPropertyNames()){
           if(System.getProperties().containsKey(key)){
              properties.setProperty(key, System.getProperty(key));
           }
       }

    //print
        logger.info("Test properties");
       for(String key: properties.stringPropertyNames()){
           logger.info("{}={}", key, properties.getProperty(key));
       }

    }

    public static String get(String key){
        return properties.getProperty(key);
    }
    public static Properties getProperties(){
        Properties prop=new Properties();
        try(InputStream stream=ResourceLoader.getResource(DEFAULT_PROPERTY)){
            prop.load(stream);
        }
        catch (Exception e){
            logger.info("unable to load the property {}", DEFAULT_PROPERTY, e );
        }
        return prop;
    }


    public static void main(String[] args) {
        System.setProperty("browser" , "firefox");
        initialize();

    }
}
