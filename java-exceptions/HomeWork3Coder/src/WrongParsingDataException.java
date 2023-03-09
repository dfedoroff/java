public class WrongParsingDataException extends Exception {

    public WrongParsingDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongParsingDataException(String message) {
        super(message);
    }
}