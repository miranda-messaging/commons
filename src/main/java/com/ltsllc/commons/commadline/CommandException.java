package com.ltsllc.commons.commadline;

/**
 * Created by miranda on 7/11/2017.
 */
public class CommandException extends Exception {
    public CommandException (Throwable cause) {
        super(cause);
    }

    public CommandException (String message) {
        super(message);
    }
}
