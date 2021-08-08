package com.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {
	
	public static boolean validateEmail(String mail) {
			final Pattern VALID_EMAIL_ADDRESS_REGEX = 
					Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
	        return matcher.find();
	}
	
	public static boolean validateDate(String Date) {
			final Pattern DATE_PATTERN = Pattern.compile(
			      "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$" 
			      + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
			      + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" 
			      + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");
			
			Matcher matcher = DATE_PATTERN.matcher(Date);
	        return matcher.find();
	}
	
	public static boolean validateName(String name) {
			final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s]+");
			Matcher matcher = NAME_PATTERN.matcher(name);
			return matcher.find();
	}

}
