package com.tutorialsninja.qa.utilities;

import java.util.Date;

public class Utilities {
	public static String generateEmailWithTimeStamp() {
		Date date=new Date();
		return "krshouvik"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}

}
