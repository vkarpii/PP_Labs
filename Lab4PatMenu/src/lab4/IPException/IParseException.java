package lab4.IPException;

public class IParseException extends Exception{
    public IParseException() {
    }

    public IParseException(String message) {
        super(message);
    }

    public IParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public IParseException(Throwable cause) {
        super(cause);
    }

    public IParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
