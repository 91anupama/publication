package com.jbk.springauthor.PublicationManagement.exception.author;

public abstract class AuthorException extends Exception{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Each exception message will be held here
    private String message;
 
    public AuthorException(String msg)
    {
        this.message = msg;
    }
    //Message can be retrieved using this accessor method
    public String getMessage() {
        return message;
    }
}
