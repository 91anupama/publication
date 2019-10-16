package com.jbk.springauthor.PublicationManagement.exception.author;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DBException extends AuthorException {
	
	private static final long serialVersionUID = 1L;
	public DBException(String msg) {
		super(msg);
		
	}
	//SQL execution error
	 @ResponseStatus(value=HttpStatus.BAD_REQUEST)  //400
    public static class BadExecution extends AuthorException  {
    	//private String msg;
    	private static final long serialVersionUID = 3555714415375055302L;
        public BadExecution(String msg) {
        super(msg);
    //    this.msg="No suitable execution found";
        }
    }
 
    //No data exist where we expect at least one row
	 @ResponseStatus(HttpStatus.NOT_FOUND )  // 404
    public static class NoData extends AuthorException {
    	//private String msg;
        private static final long serialVersionUID = 8777415230393628334L;
        public NoData(String msg) {
            super(msg);
           // this.msg="No Data found for aid";
        }
    }
 
    //Multiple rows exist where we expect only single row
	 @ResponseStatus(value=HttpStatus.CONFLICT)  // 409
    public static class MoreData extends AuthorException{
    	private String msg;
        private static final long serialVersionUID = -3987707665150073980L;
        public MoreData(String msg) {
            super(msg);
            this.msg="Mora Data found";
        }
}
  //Invalid parameters error
	 @ResponseStatus(value=HttpStatus.FORBIDDEN)  // 403
    public static class InvalidParam extends AuthorException{
    	private String msg;
   private static final long serialVersionUID = 4235225697094262603L;
        public InvalidParam(String msg) {
            super(msg);
            this.msg="Invalid Parameter found for update aid";
        }
		
    }
}