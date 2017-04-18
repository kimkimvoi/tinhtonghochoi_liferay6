package com.fsoft.bn.exception;

public class BNException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = null;
	private String msgId = null;
    public BNException() {
        super();
    }
 
    public BNException(String message) {
        super(message);
        this.message = message;
    }
    public BNException(String message, String msgId) {
    	this.message = message;
    	this.msgId = msgId;
    }
 
    public BNException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }

	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
    
}
