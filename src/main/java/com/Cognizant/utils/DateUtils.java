/*********************************CREATING CLASS TO ADD TIMESTAMP TO REPORTS*************************************/

package com.Cognizant.utils;

import java.util.Date;

public class DateUtils {

	public static String getTimeStamp() {

		Date date=new Date();

		return date.toString().replaceAll(":","_").replaceAll(" ","_");  

	}

}
