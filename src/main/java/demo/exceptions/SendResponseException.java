package demo.exceptions;

public class SendResponseException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "Response has been sent due to some errors";

    public SendResponseException() {
        super(DEFAULT_MESSAGE);
    }

    public SendResponseException(Exception ex) {
        super(DEFAULT_MESSAGE, ex);
    }
}