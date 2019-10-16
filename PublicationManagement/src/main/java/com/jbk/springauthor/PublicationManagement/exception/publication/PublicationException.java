package com.jbk.springauthor.PublicationManagement.exception.publication;

public abstract class PublicationException extends Exception{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Each exception message will be held here
    private String message;
 
    public PublicationException(String msg)
    {
        this.message = msg;
    }
    //Message can be retrieved using this accessor method
    public String getMessage() {
        return message;
    }
}
