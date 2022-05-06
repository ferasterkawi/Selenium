import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "src/test/java/configs/Configuation.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}

	// Main Data Loading Functions
	public String getURL(){
		String url = properties.getProperty("url");
		if(url!= null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");		
	}

	public long getTimeout() {		
		String timeout = properties.getProperty("timeout");
		if(timeout != null) return Long.parseLong(timeout);
		else throw new RuntimeException("timeout not specified in the Configuration.properties file.");		
	}

    // Login + Searching + Logout Tests Loading Functions 

    public String getMainPagePhrase(){
		String mainPagePhrase = properties.getProperty("mainPagePhrase");
		if(mainPagePhrase!= null) return mainPagePhrase;
		else throw new RuntimeException("mainPagePhrase not specified in the Configuration.properties file.");		
	}

    public String getUserName(){
		String UserName = properties.getProperty("UserName");
		if(UserName!= null) return UserName;
		else throw new RuntimeException("UserName not specified in the Configuration.properties file.");		
	}

    public String getPassword(){
		String Password = properties.getProperty("Password");
		if(Password!= null) return Password;
		else throw new RuntimeException("Password not specified in the Configuration.properties file.");		
	}

    public String getAccountPagePhrase(){
		String accountPagePhrase = properties.getProperty("accountPagePhrase");
		if(accountPagePhrase!= null) return accountPagePhrase;
		else throw new RuntimeException("accountPagePhrase not specified in the Configuration.properties file.");		
	}

    public String getSearchPhrase(){
		String searchPhrase = properties.getProperty("searchPhrase");
		if(searchPhrase!= null) return searchPhrase;
		else throw new RuntimeException("searchPhrase not specified in the Configuration.properties file.");		
	}

    public String getResultPagePhrase(){
		String resultPagePhrase = properties.getProperty("resultPagePhrase");
		if(resultPagePhrase!= null) return resultPagePhrase;
		else throw new RuntimeException("resultPagePhrase not specified in the Configuration.properties file.");		
	}

    // Send 2 Forms Test Loading Tunctions

    public String getProfilePagePhrase(){
		String profilePagePhrase = properties.getProperty("profilePagePhrase");
		if(profilePagePhrase!= null) return profilePagePhrase;
		else throw new RuntimeException("profilePagePhrase not specified in the Configuration.properties file.");		
	}

    public String firstname(){
		String firstname = properties.getProperty("firstname");
		if(firstname!= null) return firstname;
		else throw new RuntimeException("firstname not specified in the Configuration.properties file.");		
	}
    
    public String lastname(){
		String lastname = properties.getProperty("lastname");
		if(lastname!= null) return lastname;
		else throw new RuntimeException("lastname not specified in the Configuration.properties file.");		
	}

    public String place(){
		String place = properties.getProperty("place");
		if(place!= null) return place;
		else throw new RuntimeException("place not specified in the Configuration.properties file.");		
	}

    public String info(){
		String info = properties.getProperty("info");
		if(info!= null) return info;
		else throw new RuntimeException("info not specified in the Configuration.properties file.");		
	}

    public String twitter(){
		String twitter = properties.getProperty("twitter");
		if(twitter!= null) return twitter;
		else throw new RuntimeException("twitter not specified in the Configuration.properties file.");		
	}

    public String github(){
		String github = properties.getProperty("github");
		if(github!= null) return github;
		else throw new RuntimeException("github not specified in the Configuration.properties file.");		
	}

    public String title(){
		String title = properties.getProperty("title");
		if(title!= null) return title;
		else throw new RuntimeException("title not specified in the Configuration.properties file.");		
	}

    public String description(){
		String description = properties.getProperty("description");
		if(description!= null) return description;
		else throw new RuntimeException("description not specified in the Configuration.properties file.");		
	}

    public String company(){
		String company = properties.getProperty("company");
		if(company!= null) return company;
		else throw new RuntimeException("company not specified in the Configuration.properties file.");		
	}

    public String website(){
		String website = properties.getProperty("website");
		if(website!= null) return website;
		else throw new RuntimeException("website not specified in the Configuration.properties file.");		
	}

}