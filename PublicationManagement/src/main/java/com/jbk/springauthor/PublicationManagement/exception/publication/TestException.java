package com.jbk.springauthor.PublicationManagement.exception.publication;

public class TestException {
	 public static void main(String[] args)
	    {
	        try
	        {
	            throw new DBException.NoData("No data found for pid : pid");
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        try
	        {
	            throw new DBException.BadExecution("No suitable execution found");
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        try
	        {
	            throw new DBException.MoreData("More data found");
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        try
	        {
	            throw new DBException.InvalidParam("Invalid parameter found");
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        
	        
	        
	    }
	 
	 
	 
	 
	 
	 
}
