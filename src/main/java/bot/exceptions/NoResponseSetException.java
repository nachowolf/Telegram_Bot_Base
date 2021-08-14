package bot.exceptions;

public class NoResponseSetException extends RuntimeException {
    public NoResponseSetException() {
        super("No response message set.");
    }
}
