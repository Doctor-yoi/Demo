package com.research.demo.logger;

import com.research.demo.logger.config.Configurator;
import com.research.demo.logger.config.XMLConfigurator;
import com.research.demo.logger.config.YAMLConfigurator;

import java.net.URL;

public class ContextInitializer {
    final public static String CONFIG_XML = "log_config.xml";
    final public static String CONFIG_YAML = "log_config.yml";

    private static final LoggerContext DEFAULT_LOGGER_CONTEXT = new LoggerContext();

    static {
    }



    public static void autoconfig() {
        URL url = getConfigURL();
        if(url == null){
            System.err.println("Cannot find log_config.xml or log_config.yml in resources path!");
            return ;
        }
        String urlString = url.toString();
        Configurator configurator = null;

        if(urlString.endsWith("xml")){
            configurator = new XMLConfigurator(url,DEFAULT_LOGGER_CONTEXT);
        }
        if(urlString.endsWith("yml")){
            configurator = new YAMLConfigurator(url,DEFAULT_LOGGER_CONTEXT);
        }
        configurator.doConfigure();
    }

    private static URL getConfigURL(){
        URL url = null;
        ClassLoader classLoader = ContextInitializer.class.getClassLoader();
        url = classLoader.getResource(CONFIG_XML);
        if(url != null){
            return url;
        }
        url = classLoader.getResource(CONFIG_YAML);
        if(url != null){
            return url;
        }
        return null;
    }

    public static LoggerContext getDefautLoggerContext(){
        return DEFAULT_LOGGER_CONTEXT;
    }

}
