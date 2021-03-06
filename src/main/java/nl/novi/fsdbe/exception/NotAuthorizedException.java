package nl.novi.fsdbe.exception;

import java.io.Serial;

public class NotAuthorizedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NotAuthorizedException() {
        super("Not authorized.");
    }
}
