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

    public String getproperty(String prop, String fileName,String param1, String param2
            ,String param3,String param4,String param5,String param6,String param7) {

        String outputUrl;
        InputStream stream = classLoader.getResourceAsStream(fileName);

        try {
            //  LOGGER.info("Loading properties.. " + prop);
            properties.load(stream);
        } catch (IOException e) {
            //LOGGER.error("Error while getting properties..");
        }
        finally {
            if (stream != null) {
                try {
                    //LOGGER.trace("Closing property stream..");
                    stream.close();
                } catch (IOException ex) {
                    //LOGGER.fatal("Error while closing property stream..", ex);
                }
            }
        }
        outputUrl=String.format(properties.getProperty(prop),param1,param2,param3,param4,param5,param6,param7);
        return outputUrl;
    }

}