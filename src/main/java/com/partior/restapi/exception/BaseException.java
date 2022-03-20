package com.partior.restapi.exception;

public class BaseException extends RuntimeException implements ILoggableException {

    private static final long serialVersionUID = 7532864553039797812L;

    protected int code;

    protected String message;

    public BaseException() {
        super();
    }

    public BaseException(int code) {
        this();
        this.code = code;
    }

    public BaseException(int code, String message) {
        super (message);
        this.message = message;
        this.code = code;
    }

    public BaseException(int code, String message, StackTraceElement[] stackTrace) {

        this(code, message);
        this.setStackTrace(stackTrace);
    }

    public BaseException(Exception e) {
        super(e);
        this.setMessage(e.getMessage());
    }

    public BaseException(BaseException e) {
        super(e);
        this.code = e.code;
        this.setMessage(e.getMessage());
    }

    public int getCode () {
        return code;
    }

    // Error code
    public void setCode (int code) {
        this.code = code;
    }

    public String getMessage () {
        return message;
    }

    /**
     * Message to pass on to caller/client. Should be more functional info rather than technical.
     * Usually for UI Clients
     * @param message
     */
    public void setMessage (String message) {
        this.message = message;
    }

}
