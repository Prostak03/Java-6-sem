package IniParser;

public class IniConfigException extends Exception{
    private Exception innerException;

    public IniConfigException(String message) {
        super(message);
    }
    public IniConfigException(String message, Exception innerException) {
        this(message);
        this.innerException = innerException;
    }

    public Exception getInnerException() {
        return innerException;
    }
}
