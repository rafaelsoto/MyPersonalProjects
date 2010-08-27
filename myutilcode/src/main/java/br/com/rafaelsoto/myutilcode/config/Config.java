package br.com.rafaelsoto.myutilcode.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Implements a external properties config file.
 * @author Rafael Soto
 *
 */
public class Config {

	
	private static Logger log = Logger.getLogger(Config.class);
	
	private static Config singleton = null;
	
	private Properties propertie = new Properties();
	
	private Config() throws FileNotFoundException, URISyntaxException, IOException{
		
		loadProperties();
	}
	
	/**
	 * Get a config value by config key
	 * @param key
	 * @return
	 */
	public static String config(String key)
	{
		if(singleton == null)
		{
			try {
				singleton = new Config();
			} catch (Exception e) {
				
				log.fatal("Erro ao criar arquivo de configuracao",e);
				
				throw new RuntimeException(e);
			} 
		}
		
		return singleton.getPropertie(key);
	}
	
	public static String config(String key,String... values)
	{
		String retorno = config(key);
		
		
		retorno = MessageFormat.format(retorno, values);
		
//		for (int i = 0; i < values.length; i++) {
//			retorno.replaceAll("{"+i+"}", values[i]);
//		}
		
		return retorno;
	}
	
	/**
	 * Load all config rows in config.properties file in {@link Properties}}
	 * @throws URISyntaxException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loadProperties() throws URISyntaxException, FileNotFoundException, IOException
	{
		try {
			
     		CodeSource codeSource = Config.class.getProtectionDomain().getCodeSource();
			File jarFile = new File(codeSource.getLocation().toURI().getPath());
			File jarDir = jarFile.getParentFile();

			if (jarDir != null && jarDir.isDirectory() && new File(jarDir, "config.properties").exists()) {
				
			
						File propFile = new File(jarDir, "config.properties");
			 
						this.propertie.load(new BufferedReader(new FileReader(propFile)));
			
			 
			}
			else
			{
			  log.warn("Erro ao tentar localizar diretorio arquivo de configuracao");
			  
			  InputStream s = Config.class.getClassLoader().getResourceAsStream("config.properties");
			  
			  	 if(s != null)
				 {
					 this.propertie.load(s);
				 }
				 else
				 {

					 log.warn("Erro ao tentar localizar diretorio arquivo de configuracao");
					
				 }
			}
			
		} 
		 catch (FileNotFoundException e) {
			 log.fatal("Erro ao tentar abrir arquivo de configuracao",e);
			 throw e;
		}
		 catch (IOException e) {
			 log.fatal("Erro ao tentar abrir arquivo de configuracao",e);
			 throw e;
		}

	}
	
	public String getPropertie(String key)
	{
		String value = this.propertie.getProperty(key);
		
		if(value == null)
		{
			log.fatal("Entrada solicitada não está presente no arquivo de properties");
			
			return null;
		}
		else
		return value;
	
	}
	
	
	
}
