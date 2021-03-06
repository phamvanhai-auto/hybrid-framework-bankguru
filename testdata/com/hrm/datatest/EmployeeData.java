package com.hrm.datatest;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class EmployeeData {

	public static EmployeeData getEmployee(){
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "\\testdata\\com\\hrm\\datatest\\Employee.json"), EmployeeData.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	
	}
	
	@JsonProperty("firstname")
	private String firstname;
	
	@JsonProperty("lastname")
	private String lastname;

	@JsonProperty("username")
	private String username;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("ContactDetail")
	ContactDetail contactDetail;

	public static class ContactDetail {
		@JsonProperty("editFirstName")
		private String editFirstName;
		
		@JsonProperty("editLastName")
		private String editLastName;

	}

	public String getEditFirstName() {
		return contactDetail.editFirstName;
	}

	public String getEditLastName() {
		return contactDetail.editLastName;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	
}
