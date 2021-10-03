package com.hrm.employee;

import utilities.DataUtil;

public class Employee {
	private DataUtil fakeData;
	
	public Employee() {
		fakeData = DataUtil.getData();
	}
	
	public class PersonalDetails{
		public static final String FIRSTNAME = "Leo";
		public static final String LASTNAME = "Messi";
		public static final String FULLNAME = FIRSTNAME + " " + LASTNAME;
		public static final String USERNAME = "leomessi";
		public static final String PASSWORD = "123123@";
	}
	
	public class ContactDetails{
		public static final String EDIT_FIRSTNAME = "Jonh";
		public static final String EDIT_LASTNAME = "Wick";
		
		
	}
	public class Job{
		
	}
	
	public class Salary{
		
	}
	
}
