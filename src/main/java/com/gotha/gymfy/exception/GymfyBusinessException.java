package com.gotha.gymfy.exception;

public class GymfyBusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public GymfyBusinessException(final String message,
                                final Throwable cause) {
        super(message, cause);
    }

    public GymfyBusinessException(final String message) {
        super(message);
    }

    public GymfyBusinessException(final Throwable cause) {
        super(cause);
    }

}
