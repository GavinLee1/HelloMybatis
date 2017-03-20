package com.hello.mybatis.exception;

public class DatabaseException extends Exception {
    /**
     * Instantiates a new <code>DatabaseException</code>.
     */
    public DatabaseException() {
        super();
    }

    /**
     * Instantiates a new <code>DatabaseException</code>.
     *
     * @param message the message
     */
    public DatabaseException(String message) {
        super(message);
    }

    /**
     * Instantiates a new <code>DatabaseException</code>.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new <code>DatabaseException</code>.
     *
     * @param cause the cause
     */
    public DatabaseException(Throwable cause) {
        super(cause);
    }

}
