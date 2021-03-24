package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class ApplicationProperties {

    File autoToolsProperties = new File("src\\test\\resources\\config\\AutotoolsProperties.cfg");
    Properties props = new Properties();


    public ApplicationProperties(){
        //  load the properties
        try {
            Reader aReader = new FileReader(autoToolsProperties);
            props.load(aReader);
        }catch (IOException exp){
            System.out.println("IO Exception");
        }
    }

    public String getChromeDriverPath(){

       return props.getProperty("webdriver.chrome.driver");
    }
    public String getAppURL(){
        return props.getProperty("autotoolsURL");
    }


}
