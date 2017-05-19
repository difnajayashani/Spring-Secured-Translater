package Clients;


/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyFileReader {


    //private static final Logger LOGGER = LogManager.getLogger(PropertyReader.class);

    Properties properties = new Properties();
    ClassLoader classLoader = getClass().getClassLoader();

    public String getproperty(String prop, String fileName,String urlParameter1, String urlParameter2
            ,String urlParameter3,String urlParameter4,String urlParameter5,String urlParameter6,String urlParameter7) {

        String outputUrl;
        InputStream stream = classLoader.getResourceAsStream(fileName);

        try {
            //  LOGGER.info("Loading properties.. " + prop);
            properties.load(stream);
        } catch (IOException e) {
            //LOGGER.error("Error while getting properties..");
        }/*
        finally {
            if (stream != null) {
                try {
                    //LOGGER.trace("Closing property stream..");
                    stream.close();
                } catch (IOException ex) {
                    //LOGGER.fatal("Error while closing property stream..", ex);
                }
            }
        }*/
        outputUrl=String.format(properties.getProperty(prop),urlParameter1,urlParameter2,urlParameter3,urlParameter4,urlParameter5,urlParameter6,urlParameter7);
        return outputUrl;
    }

}