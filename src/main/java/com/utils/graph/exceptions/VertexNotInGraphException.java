package com.utils.graph.exceptions;

public class VertexNotInGraphException extends Exception {
    public VertexNotInGraphException() {
        super();
    }

    public VertexNotInGraphException(String message) {
        super(message);
    }

    public VertexNotInGraphException(String message, Throwable cause) {
        super(message, cause);
    }

    public VertexNotInGraphException(Throwable cause) {
        super(cause);
    }

    protected VertexNotInGraphException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
