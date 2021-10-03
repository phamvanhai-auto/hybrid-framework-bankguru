package utilities;

import com.github.javafaker.Faker;

public class DataUtil {
	private Faker faker;
	
	
	public static DataUtil getData() {
		return new DataUtil();
	}
	
	public DataUtil() {
		faker = new Faker();
	}
	
	public String getFirstName() {
		return faker.name().firstName();
	}
	
	public String getLastName() {
		return faker.name().lastName();
	}
	
	public String getFullName() {
		return faker.name().fullName();
	}
	
	public String getUserName() {
		return faker.name().username();
	}
	
	public String getPassword() {
		return faker.internet().password();
	}
	
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	
	public String getStreetName() {
		return faker.address().streetName();
	}
	
	public String getState() {
		return faker.address().state();
	}
	
	public String getCityName() {
		return faker.address().cityName();
	}
	
	public String getCountry() {
		return faker.address().country();
	}
	
	public String getZipCode() {
		return faker.address().zipCode();
	}
	
	public String getCellPhone() {
		return faker.phoneNumber().cellPhone();
	}
	
	public String getHomePhone() {
		return faker.phoneNumber().subscriberNumber();
	}

}
