package com.jbk.springauthor.PublicationManagement.exception.author;

public class TestException {
	public static void main(String[] args) {
		try {
			throw new DBException.NoData("No data found for aid ");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			throw new DBException.BadExecution("No suitable execution found");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			throw new DBException.MoreData("More data found for same aid");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			throw new DBException.InvalidParam("Invalid aid found");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
