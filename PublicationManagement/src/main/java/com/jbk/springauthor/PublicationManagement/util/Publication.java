package com.jbk.springauthor.PublicationManagement.util;

public class Publication {

	public static boolean isObjectEmppty(Object obj) {
		return obj == null;

	}

	@SuppressWarnings("null")
	public static boolean isStringEmpty(String str) {
		if((str==null)&&(str.equals(" ")))	
		return true;
		else
		return false;
	}
}
