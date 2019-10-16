package com.jbk.springauthor.PublicationManagement.exception.publication;

public class DBException extends PublicationException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DBException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	//SQL execution error
    public static class BadExecution extends PublicationException  {
    	private String msg;
    	private static final long serialVersionUID = 3555714415375055302L;
        public BadExecution(String msg) {
        super(msg);
        this.msg="DBExceptionBadExecution";
        }
    }
 
    //No data exist where we expect at least one row
    public static class NoData extends PublicationException {
    	private String msg;
        private static final long serialVersionUID = 8777415230393628334L;
        public NoData(String msg) {
            super(msg);
            this.msg="DBExceptionNoData";
        }
    }
 
    //Multiple rows exist where we expect only single row
    public static class MoreData extends PublicationException{
    	private String msg;
        private static final long serialVersionUID = -3987707665150073980L;
        public MoreData(String msg) {
            super(msg);
            this.msg="DBExceptionMoraData";
        }
}
  //Invalid parameters error
    public static class InvalidParam extends PublicationException{
    	private String msg;
   private static final long serialVersionUID = 4235225697094262603L;
        public InvalidParam(String msg) {
            super(msg);
            this.msg="DBExceptionInvalidParam";
        }
    }
}