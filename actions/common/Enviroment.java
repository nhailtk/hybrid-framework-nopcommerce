package common;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:EnviromentConfig/${env}.properties"})
public interface Enviroment extends Config {
	@Key("url")
	String url();
	
	@Key("user")
	String user();
	
	@Key("password")
	String password();
	

}
