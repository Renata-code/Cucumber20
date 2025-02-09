package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {



    //1.first we created properties object

    private static Properties properties = new Properties();

    static {
    //2. get the path and store in String or directly pass into fileInputStreamj

        String path ="configuration.properties";
       //3 we need to open the file
        try {
            FileInputStream file = new FileInputStream(path);
            //4. we need to load the file properties object
            properties.load(file);
            //5. close.file
            file.close();
        } catch (IOException e) {
            System.out.println("Properties file not found");
        }


      }
      //our own custom method to read and get values from configuration.properties file
      public   static String getProperty(String keyWord){

        return properties.getProperty(keyWord);


      }
}
